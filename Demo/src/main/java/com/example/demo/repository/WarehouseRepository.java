package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Warehouse;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
	@Query("select w from Warehouse w where id_warehouse=:idWarehouse and id_product=:idProduct")
	Warehouse getWarehouse(@Param("idWarehouse") int idWarehouse, @Param("idProduct") String idProduct);

	
//	@Query("update Warehouse  set soldedNumber=:quan " + "where idWarehouse=:idWarehouse" + " and idProduct=:idProduct")
//	@Modifying
//	void updateSocked(@Param("idWarehouse") int idWarehouse, @Param("idProduct") String idProduct,
//			@Param("quan") int quan);
}
