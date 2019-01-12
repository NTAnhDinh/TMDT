package api.soccer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import api.soccer.management.repository.DSNguoiChoiRepository;

@Controller
@RequestMapping("/soccer/")
public class CaCuocController {
	@Autowired
	DSNguoiChoiRepository re;
//	@GetMapping("/{tiso_id}")
//	public void deletePlayer(@PathVariable(value="tiso_id") int id) {
//		System.out.println(re.countTotalPlayer(id));
//	}
}
