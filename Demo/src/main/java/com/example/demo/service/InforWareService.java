package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InformationWarehouse;
import com.example.demo.repository.InfoWarehouseRepository;
@Service
public class InforWareService {
	@Autowired
	InfoWarehouseRepository iwRepository;

	public List<InformationWarehouse> findAll() {
		return iwRepository.findAll();
	}
}
