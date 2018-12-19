package com.tmdt.service;

import com.tmdt.model.Homestay;
import com.tmdt.repository.HomestayDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomestayService {
    @Autowired
    HomestayDAO homestayDAO;

    public List<Homestay> findAll() {
        return homestayDAO.findAll();
    }

    public Homestay getOne(int id) {
        return homestayDAO.getOne(id);
    }

    public List<Homestay> getHomestayByUser(String homestay_master) {
        return homestayDAO.findHomestayByHomestay_master(homestay_master);
    }

}
