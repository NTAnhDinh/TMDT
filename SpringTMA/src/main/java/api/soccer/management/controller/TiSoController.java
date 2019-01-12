package api.soccer.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import api.soccer.management.model.NguoiChoi;
import api.soccer.management.model.TiSo;
import api.soccer.management.service.TiSoService;
import reactor.core.publisher.Mono;

import java.security.Principal;
import java.util.*;

@Controller
@RequestMapping("/soccer/")
public class TiSoController {
	@Autowired
	TiSoService scoreService;

	@GetMapping(value = "/score")
	public ResponseEntity<List<TiSo>> listAllTiSo() {
		List<TiSo> listtiso = scoreService.findAll();
		if (listtiso.isEmpty()) {
			return new ResponseEntity<List<TiSo>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TiSo>>(listtiso, HttpStatus.OK);
	}

	@GetMapping(value = "/score/{id}")
	public ResponseEntity<TiSo> getOne(@PathVariable(value = "id") String score_id) {
		TiSo ts = scoreService.findOne(Integer.parseInt(score_id));
		return new ResponseEntity<TiSo>(ts, HttpStatus.OK);
	}

	@DeleteMapping("/deleteScore/{id}")
	public boolean deletePlayer(@PathVariable(value = "id") int id) {
		return scoreService.deleteScore(id);
	}

	@PostMapping(value = "/createScore")
	public ResponseEntity<TiSo> createScore(@RequestBody TiSo score) {
		return new ResponseEntity<TiSo>(scoreService.addScore(score), HttpStatus.OK);
	}
}
