package com.tmdt.repository;

import com.tmdt.model.RegisterService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.tmdt.model.Homestay;

import java.util.List;


@Repository
public interface RegisterSDAO extends JpaRepository<RegisterService, Integer> {

    @Query("SELECT r FROM RegisterService r where r.date_finished > current_date")
    List<RegisterService> findAllByDate_finishedBefore();
}
