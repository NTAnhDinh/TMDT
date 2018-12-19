package com.tmdt.service;

import com.tmdt.model.Buy;
import com.tmdt.repository.BuyDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyService {
    @Autowired
    BuyDAO buyDAO;

    public List<Buy> getAllService() {
        return buyDAO.findAll();
    }

    public Buy getById(int id) {
        return buyDAO.getOne(id);
    }


}
