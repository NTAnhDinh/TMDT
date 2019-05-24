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

import com.example.demo.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> , PagingAndSortingRepository<Product, Integer> {

	@Query("select p from Product p where p.nameProduct =:name_product ")
	Product findByNameProduct(@Param("name_product") String nameProduct);

	@Query("SELECT p FROM Product p where name_product =:keyword")
	public List<Product> search(@Param("keyword") String keyword);

	@Query("SELECT nameProduct FROM Product p where name_product like %:keyword%")
	public List<String> searchProduct(@Param("keyword") String keyword);

	@Query("select p from Product p where p.idProduct =:idProduct ")
	Product findByIdProduct(@Param("idProduct") String idProduct);

	@Transactional
	@Modifying
	@Query("update Product  set price =:price where idProduct =:idProduct ")
	void updatePrice(@Param("price") long price, @Param("idProduct") String idProduc);
}
