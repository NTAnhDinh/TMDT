package com.tmdt.ngohongthai.services;

import com.tmdt.ngohongthai.entities.HomeStay;
import com.tmdt.ngohongthai.repositories.HomeStayDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeStayService {
    @Autowired
    HomeStayDAO homeStayDAO;

    public List<HomeStay> getAll() {
        return homeStayDAO.findAll();
    }
}
