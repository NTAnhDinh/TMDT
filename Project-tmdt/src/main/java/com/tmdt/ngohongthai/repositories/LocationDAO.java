package com.tmdt.ngohongthai.repositories;

import com.tmdt.ngohongthai.entities.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationDAO extends JpaRepository<Location, Integer> {
}
