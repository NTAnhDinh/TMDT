package com.example.demo.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.StaticDto;
import com.example.demo.model.Invoice;
import com.example.demo.model.InvoiceDetail;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, String>, PagingAndSortingRepository<Invoice, String> {

	@Query(value = "insert into InvoiceDetail (id_invoice,id_product,quantity,price"
			+ ") values (:idInvoice,:idProduct,:quantity,:price)", nativeQuery = true)
	@Transactional
	InvoiceDetail addDetail(@Param("idInvoice") String idInvoice, @Param("idProduct") String idProduct,
			@Param("quantity") Integer quantity, @Param("price") long price);

	InvoiceDetail findByIdInvoice(String idInvoice);

	@Query("delete from InvoiceDetail where id_invoice =:idInvoice")
	void deleteDetail(@Param("idInvoice") String idInvoice);

	@Query("select count(id_invoice) FROM Invoice WHERE date = CURDATE()")
	int getInvoiceInDay();

	@Query("SELECT COALESCE(SUM(total),0) FROM Invoice WHERE date = CURDATE()")
	long getSumMoneyInDay();

	@Query("SELECT COUNT(idInvoice) FROM DeletedInvoice WHERE date = CURDATE()")
	int getDeletedInvoice();

	@Query("SELECT COUNT(d.product) FROM Receipt r INNER JOIN ReceiptDetail d ON r.id = d.id WHERE r.date = CURDATE()")
	int getItemReturned();

	@Query("SELECT p.idProduct" + " FROM InvoiceDetail id INNER JOIN id.invoice i  "
			+ "INNER JOIN id.product p  WHERE YEAR(i.date)=:year"
			+ " AND p.idCategory=:idCategory GROUP BY p.idProduct ORDER BY SUM(id.quantity) DESC ")
	List<String> getTop10Product(@Param("idCategory") String idCategory, @Param("year") int year, Pageable page);

	@Query("SELECT new com.example.demo.dto.StaticDto( p.idProduct, p.nameProduct, SUM(id.quantity),"
			+ " MONTH(i.date)) FROM InvoiceDetail id INNER JOIN id.invoice i " + " INNER JOIN id.product p"
			+ " WHERE YEAR(i.date)=:year AND p.idProduct=:idProduct GROUP BY p.idProduct, MONTH(i.date)")
	List<StaticDto> getTrends(@Param("idProduct") String idProduct, @Param("year") int year);
}
