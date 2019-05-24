package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public Product save(Product p) {
		return productRepository.save(p);
	}

	public Product findByNameProduct(String nameProduct) {
		return productRepository.findByNameProduct(nameProduct);
	}

	public Product findByIdProduct(String idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}

	public List<Product> search(String keyword) {
		return productRepository.search(keyword);
	}

	public List<String> searchProduct(String keyword) {
		return productRepository.searchProduct(keyword);
	}

	public Page<Product> getList(int page) {
		return productRepository.findAll(PageRequest.of(page,3,Sort.by(Sort.Direction.ASC,"idProduct")));
	}
	public void updatePrice(long price,String idProduct) {
		 productRepository.updatePrice(price, idProduct);
	}
	public String randomId(int limit, String ngay) {
		String id = "PO";
		Random r = new Random();
		List<Product> listIn = productRepository.findAll();
		int stt = r.nextInt(limit);
		int count = 0;
		while (count != listIn.size() || stt == 0) {
			stt = r.nextInt(limit);
			count = 0;
			for (int i = 0; i < listIn.size(); i++) {
				if (Integer.parseInt(listIn.get(i).getIdProduct().substring(6, 9).trim()) == stt) {
					break;
				} else {
					count++;
					if (count == listIn.size()) {
						String s = ngay.substring(5, 7) + ngay.substring(8, 10);
						id += s;
						break;
					}
				}

			}
		}
		ArrayList<Integer> listStt = convertInToArr(stt);
		ArrayList<Integer> listLimit = convertInToArr(limit);

		int time = listLimit.size() - listStt.size();
		for (int i = 0; i < time; i++) {
			id += "0";
		}
		id += stt;

		return id;

	}
	public ArrayList<Integer> convertInToArr(int x) {
		ArrayList<Integer> l = new ArrayList<>();
		do {
			l.add(x % 10);
			x /= 10;

		} while (x != 0);
		return l;
	}
}
