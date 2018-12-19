package com.tmdt.repository;

import com.tmdt.model.Homestay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomestayDAO extends JpaRepository<Homestay, Integer> {

    @Query("select h from Homestay h where h.homestay_master =:homestay_master")
    List<Homestay> findHomestayByHomestay_master(String homestay_master);
}
