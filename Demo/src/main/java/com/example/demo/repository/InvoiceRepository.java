package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceDetail;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String> {

	@Query(value = "insert into InvoiceDetail (id_invoice,id_product,quantity,price"
			+ ") values (:idInvoice,:idProduct,:quantity,:price)", nativeQuery = true)
	@Transactional
	InvoiceDetail addDetail(@Param("idInvoice") String idInvoice, @Param("idProduct") String idProduct,
			@Param("quantity") Integer quantity, @Param("price") long price);

	InvoiceDetail findByIdInvoice(String idInvoice);

	@Query("delete from InvoiceDetail where id_invoice =:idInvoice")
	void deleteDetail(@Param("idInvoice") String idInvoice);

//	@Query("update Invoice i set i.status=:status where i.idInvoice = :id_invoice")
//	void updateStatus(@Param("status") int status, @Param("id_invoice") String idInvoice);

//	@Query("select new com.example.demo.dto.StaticDto(i.idInvoice, i.total,i.date,id.idProduct,) from invoice i join invoice_detail id on i.id_invoice=id.id_invoice")
//	int countInvoice();

}
