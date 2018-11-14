package com.tmdt.ngohongthai.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;

import org.springframework.stereotype.Service;

import com.tmdt.ngohongthai.entities.Room;
import com.tmdt.ngohongthai.repositories.RoomDAO;

@Service
public class RoomService {
	@Autowired
	RoomDAO roomDAO;

	public Room getOne(int room_id) {
		return roomDAO.getOne(room_id);

	}

	public Page<Room> findAll(int pageNumber, int pageSize, String directions, String orderBy) {
		Pageable request;
	Sort sortable= null;
		if (directions.equals("DESC")) {
			sortable = Sort.by(orderBy).descending();
		} else {
			sortable = Sort.by(orderBy).ascending();}
		
		request = PageRequest.of(pageNumber, pageSize, sortable);
		return roomDAO.findRomm(request);

	}

	public boolean createRoom(Room room) {
		Room r = roomDAO.getOne(room.getRoom_id());
		if (!r.equals(null)) {
			return false;
		} else
			roomDAO.save(room);
		return true;
	}

	public boolean updateRoom(int room_id, Room room) {

		Room room_old = roomDAO.getOne(room_id);
		if (room_old.equals(null)) {
			return false;
		} else {
			room_old.setRoom_name(room.getRoom_name());
			room_old.setRoom_status(room.getRoom_status());
			room_old.setRoom_number_guest(room.getRoom_number_guest());
			room_old.setRoom_reviews(room.getRoom_reviews());
			room_old.setRoom_number_reviews(room.getRoom_number_reviews());
			room_old.setRoom_address(room.getRoom_address());
			room_old.setRoom_price(room.getRoom_price());
			room_old.setRoom_describe(room.getRoom_describe());
			room_old.setRoom_information(room.getRoom_information());
			room_old.setRoom_type(room.getRoom_type());
			room_old.setHomestay_id(room.getHomestay_id());
			room_old.setRoom_image(room.getRoom_image());
			roomDAO.save(room_old);
		}
		return true;
	}

	public boolean delete(int room_id) {
		Room r = roomDAO.getOne(room_id);
		roomDAO.delete(r);
		return true;
	}

	

	public Page<Room> sortListRoom(int pageNumber, int pageSize, String direction, String  orderBy
			) {
		Pageable request;
		Sort sortable = null;
		if (direction.equals("DESC")) {
			sortable = Sort.by(orderBy).descending();
		} else {
			
			sortable = Sort.by(orderBy).ascending();}
		
		request = PageRequest.of(pageNumber, pageSize, sortable);
		return roomDAO.findRomm(request);
	}
	
}
