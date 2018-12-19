package com.tmdt.controller;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.tmdt.config.PaypalPaymentIntent;
import com.tmdt.config.PaypalPaymentMethod;
import com.tmdt.model.RegisterService;
import com.tmdt.model.Users;
import com.tmdt.service.BuyService;
import com.tmdt.service.HomestayService;
import com.tmdt.service.PaypalService;
import com.tmdt.service.RegService;
import com.tmdt.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Controller
public class ServiceController {

    public static final String URL_PAYPAL_SUCCESS = "pay/success";
    public static final String URL_PAYPAL_CANCEL = "pay/cancel";

    @Autowired
    BuyService buyService;

    @Autowired
    PaypalService paypalService;

    @Autowired
    RegService regService;

    @Autowired
    HomestayService homestayService;

    @RequestMapping("/service")
    public String service(ModelMap mm, HttpSession session) {
        Users u = (Users) session.getAttribute("user");
        System.out.println(u.getUser_name());
        List<RegisterService> list = new ArrayList<>();
        for(RegisterService r : regService.findAll()) {
            if(r.getHomestay().getUsers().getUser_name().equals(u.getUser_name())) {
                list.add(r);
            }
        }
        List<Integer> running = new ArrayList<>();
        List<RegisterService> runObj = new ArrayList<>();
        for(RegisterService r : regService.findDate()) {
            if(r.getHomestay().getUsers().getUser_name().equals(u.getUser_name())) {
                running.add(r.getHomestay_id());
                runObj.add(r);
            }
        }
        mm.addAttribute("running", running);
        mm.addAttribute("homestay", homestayService.getHomestayByUser(u.getUser_name()));
        mm.addAttribute("reg", list);
        mm.addAttribute("runObj", runObj);
        LocalDateTime ldt = LocalDateTime.now();
        mm.addAttribute("nows", DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt));
        mm.addAttribute("service",buyService.getAllService());
        return "service";
    }

    @GetMapping("service/pay")
    public String buy(HttpServletRequest request, @RequestParam("price") double price,
                      @RequestParam("service_id") int service_id, HttpSession session,
                      @RequestParam("homestay_id") int homestay_id) {
        session.setAttribute("current_service", service_id);
        session.setAttribute("current_homestay", homestay_id);
        String cancelUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_CANCEL;
        String successUrl = Utils.getBaseURL(request) + "/" + URL_PAYPAL_SUCCESS;

        try {
            Payment payment = paypalService.createPayment(price, "USD", PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale, "thanh toan", cancelUrl, successUrl);
            for(Links links : payment.getLinks()) {
                if(links.getRel().equals("approval_url")) {
                    return "redirect:" + links.getHref();
                }
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
    @GetMapping(URL_PAYPAL_CANCEL)
    public String cancelPay() {
        return "cancel";
    }

    @GetMapping(URL_PAYPAL_SUCCESS)
    public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId,
                             HttpSession session, RedirectAttributes ra) {
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if (payment.getState().equals("approved")) {
                RegisterService r = new RegisterService();
                Users u = (Users) session.getAttribute("user");
                Calendar cal = Calendar.getInstance();
                System.out.println("Ngày đầu:" + cal.getTime());
                int homestay_id = (int) session.getAttribute("current_homestay");
                int service_id =(int) session.getAttribute("current_service");
                for(RegisterService r2 : regService.findDate()) {
                    r2.getHomestay().getUsers().getUser_name();
                    if(r2.getHomestay().getUsers().getUser_name().equals(u.getUser_name())) {
                        cal.setTime(r2.getDate_finished());
                        System.out.println("Sau khi set:" + cal.getTime());
                    }
                }
                System.out.println("Ngoài dòng for: " + cal.getTime());
                r.setHomestay_id(homestay_id);

                r.setDate_started(cal.getTime());
                if(service_id == 0) {
                    cal.add(Calendar.MONTH, 1);
                    r.setDate_finished(cal.getTime());
                } else if(service_id == 1) {
                    cal.add(Calendar.MONTH, 6);
                    r.setDate_finished(cal.getTime());
                } else {
                    cal.add(Calendar.YEAR, 1);
                    r.setDate_finished(cal.getTime());
                }
                r.setService_id(service_id);
                r.setPrice(buyService.getById(service_id).getService_price());
                regService.add_regService(r);
                ra.addFlashAttribute("message","Bạn đã thanh toán thành công !");
                return "redirect:/service";
            }
        } catch (PayPalRESTException e) {
            System.out.println(e.getMessage());
        }
        return "redirect:/";
    }
}
