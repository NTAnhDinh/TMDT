package com.tmdt.controller;

import com.tmdt.model.Homestay;
import com.tmdt.model.RegisterService;
import com.tmdt.service.HomestayService;
import com.tmdt.service.LocationService;
import com.tmdt.service.RegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MainController {

    @Autowired
    HomestayService homestayService;

    @Autowired
    RegService regService;

    @Autowired
    LocationService locationService;

    @RequestMapping("/")
    public String index(ModelMap mm) {
        List<RegisterService> list = regService.findDate();
        List<Homestay> listHomestay = new ArrayList<>();
        for (RegisterService r : list) {
            listHomestay.add(homestayService.getOne(r.getHomestay_id()));
        }
        int rand = 0;
        List<Homestay> arr = new ArrayList<>();
        while(arr.size() < 4) {
            rand = new Random().nextInt(listHomestay.size());
            if (arr.contains(listHomestay.get(rand))) {
                continue;
            } else {
                arr.add(listHomestay.get(rand));
            }
        }
        System.out.println(regService.findDate().get(0).getDate_finished());
        mm.addAttribute("homestay", arr);
        mm.addAttribute("location", locationService.findAll());
        return "index";
    }
}
