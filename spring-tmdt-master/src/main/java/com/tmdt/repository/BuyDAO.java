package com.tmdt.repository;

import com.tmdt.model.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyDAO extends JpaRepository<Buy, Integer> {
}
