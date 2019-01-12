package api.soccer.management.repository;

import api.soccer.management.model.NguoiChoi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface NguoiChoiRepository extends JpaRepository<NguoiChoi, Integer> {
	@Query("select n from NguoiChoi n where n.username =:username")
	NguoiChoi findByUserName(String username);
}
