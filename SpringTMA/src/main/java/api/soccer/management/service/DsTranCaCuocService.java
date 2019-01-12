package api.soccer.management.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import api.soccer.management.model.DanhSachTranCaCuoc;
import api.soccer.management.model.NguoiChoi;
import api.soccer.management.model.TiSo;
import api.soccer.management.repository.DSNguoiChoiRepository;
import api.soccer.management.repository.DSTranCaCuocRepository;

@Service
public class DsTranCaCuocService {
	@Autowired
	DSTranCaCuocRepository ds;
	@Autowired
	DSNguoiChoiRepository listPlayer;

	public int totalMoneyBet(int id_trandau) {
		List<TiSo> list_ts = ds.getOne(id_trandau).getList_ts();
		int total = 0;
		for (TiSo tiSo : list_ts) {
			List<NguoiChoi> listPlayers = listPlayer.getListPlayer(tiSo.getTiso_id());
			total += tiSo.getPrice() * listPlayers.size();
		}
		return total;
	}

	public double totalMoneyWinForOneTS(int id_trandau, int id_ts) {
		List<NguoiChoi> listPlayers = listPlayer.getListPlayer(id_ts);
		return ((1 - (15 / 100)) * totalMoneyBet(id_trandau) + 100000) / (listPlayers.size());
	}

	public List<DanhSachTranCaCuoc> findAll() {
		return ds.findAll();

	}

	public DanhSachTranCaCuoc findOne(int id) {
		return ds.getOne(id);
	}

	public DanhSachTranCaCuoc addMatch(DanhSachTranCaCuoc match) {
		return ds.save(match);
	}

	public boolean deleteMatch(int id) {
		DanhSachTranCaCuoc entity = findOne(id);
		if (entity == null)
			return false;
		else {
			ds.delete(entity);
			return true;
		}
	}
}
