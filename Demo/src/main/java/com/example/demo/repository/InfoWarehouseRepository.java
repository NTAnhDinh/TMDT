package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InformationWarehouse;

@Repository
public interface InfoWarehouseRepository extends JpaRepository<InformationWarehouse, String>{

}
