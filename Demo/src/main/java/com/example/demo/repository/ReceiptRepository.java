package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Receipt;
@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, String> {
	@Modifying
	@Query(value = "insert into ReceiptDetail values(:id,:idProduct,:moneyPaid)", nativeQuery = true)
	void addDetail(@Param("id") int id,@Param("idProduct") String idProduct,
			@Param("moneyPaid") double moneyPaid);
}
