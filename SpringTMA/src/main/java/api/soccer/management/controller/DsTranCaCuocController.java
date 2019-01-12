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

import api.soccer.management.model.DanhSachTranCaCuoc;
import api.soccer.management.model.TiSo;
import api.soccer.management.service.DsTranCaCuocService;

@Controller
@RequestMapping("/soccer/")
public class DsTranCaCuocController {
	@Autowired
	DsTranCaCuocService ds;

	@GetMapping(value = "/listMatches")
	public ResponseEntity<List<DanhSachTranCaCuoc>> listMatches() {
		List<DanhSachTranCaCuoc> listBet = ds.findAll();
		return new ResponseEntity<List<DanhSachTranCaCuoc>>(listBet, HttpStatus.OK);
	}

	@GetMapping(value = "/listMatches/{id}")
	public ResponseEntity<DanhSachTranCaCuoc> getMatches(@PathVariable(value = "id") int id) {
		DanhSachTranCaCuoc trancc = ds.findOne(id);
		return new ResponseEntity<DanhSachTranCaCuoc>(trancc, HttpStatus.OK);
	}

	@DeleteMapping("/deleteMatches/{id}")
	public boolean deleteMatches(@PathVariable(value = "id") int id) {
		return ds.deleteMatch(id);
	}

	@PostMapping(value = "/createMatch")
	public ResponseEntity<DanhSachTranCaCuoc> createMatches(@RequestBody DanhSachTranCaCuoc match) {
		return new ResponseEntity<DanhSachTranCaCuoc>(ds.addMatch(match), HttpStatus.OK);
	}
}
