package api.soccer.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import api.soccer.management.model.NguoiChoi;
import api.soccer.management.model.TiSo;
import api.soccer.management.repository.TiSoRepository;

import java.util.*;

@Service
public class TiSoService {
	@Autowired
	TiSoRepository tiSoRepository;

	public List<TiSo> findAll() {
		return tiSoRepository.findAll();

	}

	public TiSo findOne(int id) {
		return tiSoRepository.getOne(id);
	}

	public TiSo addScore(TiSo score) {
		return tiSoRepository.save(score);
	}

	public boolean deleteScore(int id) {
		TiSo entity = findOne(id);
		if (entity == null)
			return false;
		else {
			tiSoRepository.delete(entity);
			return true;
		}
	}

	public int totalMoney() {
		int total = 0;

		return 0;
	}
}
