package com.tmdt.service;

import com.tmdt.model.Location;
import com.tmdt.repository.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationDAO locationDAO;

    public List<Location> findAll() {
        return locationDAO.findAll();
    }
}
