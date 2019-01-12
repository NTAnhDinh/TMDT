package api.soccer.management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import api.soccer.management.model.*;

@Repository
public interface DSNguoiChoiRepository extends JpaRepository<DanhSachNguoiChoi, Integer> {
	@Query("select count(ds.nguoichoi_id) from DanhSachNguoiChoi ds where ds.tiso_id =:score_id")
	int countTotalPlayer(@Param("score_id") int score_id);

	@Query("select tiso_id from DanhSachNguoiChoi where nguoichoi_id =:player_id")
	List<TiSo> getListScore(@Param("player_id") int player_id);

	@Query("select nguoichoi_id from DanhSachNguoiChoi where tiso_id =:score_id")
	List<NguoiChoi> getListPlayer(@Param("score_id") int score_id);
}
