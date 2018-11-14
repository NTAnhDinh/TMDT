package com.tmdt.ngohongthai.repositories;


import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;

import com.tmdt.ngohongthai.entities.Room;

public interface RoomDAO extends JpaRepository<Room, Integer>{
	 
	@Query( value= "select * from room as r  " ,nativeQuery = true)
	Page<Room> findRomm(  Pageable pageable );
	@Query( value= "select * from room as r where  " ,nativeQuery = true)
	Page<Room> getListOrderBy(Pageable pageable);
}
