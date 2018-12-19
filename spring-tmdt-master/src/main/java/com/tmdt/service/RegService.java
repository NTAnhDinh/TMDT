package com.tmdt.service;

import com.tmdt.model.RegisterService;
import com.tmdt.repository.RegisterSDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RegService {

    @Autowired
    RegisterSDAO registerSDAO;

    public List<RegisterService> findAll(){
        return registerSDAO.findAll();
    }

    public List<RegisterService> findDate() {
        return registerSDAO.findAllByDate_finishedBefore();
    }
    public RegisterService add_regService(RegisterService registerService) {
        return registerSDAO.save(registerService);
    }
}
