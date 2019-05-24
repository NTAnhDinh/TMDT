package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.InvoiceDetail;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetail,String>{
	
			@Query("select id from InvoiceDetail id  where id_invoice=:id_invoice")
			List<InvoiceDetail> getById1( @Param("id_invoice") String idInvoice);

}
