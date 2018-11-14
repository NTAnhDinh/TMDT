package com.tmdt.ngohongthai.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.tmdt.ngohongthai.entities.Room;
import com.tmdt.ngohongthai.services.RoomService;

@RestController
public class RoomController {
	 @Autowired
RoomService roomService;
	    @GetMapping(value="/getAll" , params = { "page", "size","direction"})
	    public Page<Room> getAllRoom(@RequestParam( "page" ) int page, 
	    		@RequestParam( "size" ) int size,
	    		@RequestParam( "direction" ) String direction){
	    	return roomService.findAll(page,size,direction,"room_id");
	    }
	    @GetMapping(value="/sort", params = { "page", "size","direction","sortBy" } )
	    public Page<Room> sort( @RequestParam( "page" ) int page, 
	    		@RequestParam( "size" ) int size,
	    		@RequestParam( "direction" ) String direction,
	    		@RequestParam( "sortBy" ) String sortBy){
	    	return roomService.sortListRoom(page, size,direction,sortBy);
	    }
	
	 
	    @GetMapping(value = "/getRoom/{id}")
	    public Room getRoom(@PathVariable("id") int id) {
	    	
			return roomService.getOne(id);
	    	
	    }
	 
		@PostMapping(value="/createRoom" )
	    public boolean createRoom( @RequestBody Room room) {

			return 	roomService.createRoom(room);
		
	    	
	    }
	    @PutMapping(value="/updateRoom/{id}" )
	    public boolean updateRoom(@PathVariable int id,@RequestBody Room body) {
	    	return 	roomService.updateRoom(id, body);
			
	    	
	    }
	    @DeleteMapping("/deleteRoom/{id}")
	    public boolean deleteRoom(@PathVariable int id) {
	    	return roomService.delete(id);
	    }
	    
}
