package api.soccer.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.soccer.management.model.*;
import api.soccer.management.repository.DSNguoiChoiRepository;

@Service
public class DanhSachNguoiChoiService {

	@Autowired
	DSNguoiChoiRepository listPlayersRepo;

	public DanhSachNguoiChoi findOne(int id) {
		return listPlayersRepo.getOne(id);
	}

	public DanhSachNguoiChoi add(DanhSachNguoiChoi listPlayers) {
		return listPlayersRepo.save(listPlayers);
	}

	public boolean delete(int id) {
		DanhSachNguoiChoi entity = findOne(id);
		if (entity == null)
			return false;
		else {
			listPlayersRepo.delete(entity);
			return true;
		}
	}
}
