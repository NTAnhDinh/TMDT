package api.soccer.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import api.soccer.management.model.NguoiChoi;
import api.soccer.management.repository.DSNguoiChoiRepository;
import api.soccer.management.service.NguoiChoiService;

@Controller
@RequestMapping("/soccer/")
public class NguoiChoiController {
	@Autowired
	NguoiChoiService nguoiChoiService;

	@GetMapping(value = "/players")
	public ResponseEntity<List<NguoiChoi>> listAllPlayers() {
		List<NguoiChoi> listtiso = nguoiChoiService.findAll();
		if (listtiso.isEmpty()) {
			return new ResponseEntity<List<NguoiChoi>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<NguoiChoi>>(listtiso, HttpStatus.OK);
	}

	@GetMapping(value = "/player/{id}")
	public ResponseEntity<NguoiChoi> getOne(@PathVariable(value = "id") int id) {
		return new ResponseEntity<NguoiChoi>(nguoiChoiService.findOne(id), HttpStatus.OK);
	}

	@DeleteMapping("/deletePlayer/{id}")
	public boolean deletePlayer(@PathVariable int id) {
		return nguoiChoiService.deletePlayer(id);
	}

	@PostMapping(value = "/createPlayer")
	public ResponseEntity<NguoiChoi> createNguoiChoi(@RequestBody NguoiChoi nguoiChoi) {
		return new ResponseEntity<NguoiChoi>(nguoiChoiService.addPlayer(nguoiChoi), HttpStatus.OK);
	}
}
