package com.tmdt.ngohongthai.controller;

import com.tmdt.ngohongthai.entities.HomeStay;
import com.tmdt.ngohongthai.services.HomeStayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    HomeStayService homeStayService;

    @RequestMapping("/")
    public List<HomeStay> main() {
        return homeStayService.getAll();
    }
}
