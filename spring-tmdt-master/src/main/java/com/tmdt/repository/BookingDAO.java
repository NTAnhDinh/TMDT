package com.tmdt.repository;

import com.tmdt.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingDAO extends JpaRepository<Booking, Integer> {
    @Query("select b from Booking  b where b.user_name =:user_name")
    List<Booking> findBookingByUser_name(String user_name);

}
