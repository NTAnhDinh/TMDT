package com.tmdt.ngohongthai.services;

import com.tmdt.ngohongthai.entities.Location;
import com.tmdt.ngohongthai.repositories.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationDAO locationDAO;

    public Location getOne(int location_id) {
        return locationDAO.getOne(location_id);
    }

    public List<Location> findAll() {
        return locationDAO.findAll();
    }
}
