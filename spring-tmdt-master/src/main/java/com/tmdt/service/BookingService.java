package com.tmdt.service;

import com.tmdt.model.Booking;
import com.tmdt.repository.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    @Autowired
    BookingDAO bookingDAO;

    public Booking save(Booking booking) {
        return bookingDAO.save(booking);
    }

    public List<Booking> getBookingByUser(String user_names) {
        return bookingDAO.findBookingByUser_name(user_names);
    }

    public List<Booking> getAllBooking() {
        return bookingDAO.findAll();
    }

    public Booking getBookById(int id) {
        return bookingDAO.getOne(id);
    }

    public Booking updateBookinf(Booking booking) {
        return bookingDAO.save(booking);
    }
}
