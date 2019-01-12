package api.soccer.management.repository;

import api.soccer.management.model.TiSo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TiSoRepository extends JpaRepository<TiSo, Integer> {
	
}
