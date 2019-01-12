package api.soccer.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.soccer.management.model.NguoiChoi;
import api.soccer.management.model.TiSo;
import api.soccer.management.repository.DSNguoiChoiRepository;
import api.soccer.management.repository.NguoiChoiRepository;

import java.util.List;

import javax.persistence.EntityNotFoundException;

@Service
public class NguoiChoiService {
	@Autowired
	NguoiChoiRepository nguoiChoiRepository;
	@Autowired
	DsTranCaCuocService dscc;
	@Autowired
	DSNguoiChoiRepository listPlayer;

	public List<NguoiChoi> findAll() {
		return nguoiChoiRepository.findAll();

	}

	public NguoiChoi addPlayer(NguoiChoi player) {
		return nguoiChoiRepository.save(player);
	}

	public boolean deletePlayer(int id) {
		NguoiChoi entity = findOne(id);
		if (entity == null)
			return false;
		else {
			nguoiChoiRepository.delete(entity);
			return true;
		}
	}

	public NguoiChoi findOne(int id) {
		return nguoiChoiRepository.getOne(id);

	}

	public NguoiChoi findByUsername(String username) {
		return nguoiChoiRepository.findByUserName(username);
	}

	public int countBalance(int player_id) {
		NguoiChoi nc = findOne(player_id);
		int result = 0;
		if (nc == null)
			result = 0;
		else {
			List<TiSo> list_ts = listPlayer.getListScore(player_id);
			int totalBet = 0;
			double total_Revenue = 0;
			for (TiSo tiSo : list_ts) {
				List<NguoiChoi> listPlayers = listPlayer.getListPlayer(tiSo.getTiso_id());
				totalBet += tiSo.getPrice();
				total_Revenue += dscc.totalMoneyWinForOneTS(tiSo.getDs_cacuoc().getTrandau_id(), tiSo.getTiso_id())
						/ listPlayers.size();
			}
			result = nc.getTongThu() - totalBet + (int) (Math.round(total_Revenue));
		}
		return result;
	}
}
