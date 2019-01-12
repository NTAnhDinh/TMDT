package api.soccer.management.repository;

import api.soccer.management.model.DanhSachTranCaCuoc;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DSTranCaCuocRepository extends JpaRepository<DanhSachTranCaCuoc, Integer> {
}
