package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dto.StaticDto;
import com.example.demo.model.Product;
import com.example.demo.repository.InvoiceRepository;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;
	@Autowired
	InvoiceRepository invoiceRepository;

	public Product save(Product p, String multipartFile) {
		try {
//			 FileInputStream inputStream = new FileInputStream(multipartFile.getOriginalFilename());;
//			 inputStream.read(multipartFile.getBytes());
//	 
//			 imageString=new String(Base64.encodeBase64(multipartFile.getBytes()), "UTF-8");
			ClassLoader classLoader = getClass().getClassLoader();
			System.out.println(
					"image string " + "D:\\CodeJAVA\\Test\\Demo\\src\\main\\resources\\static\\imgs\\" + multipartFile);
			File inputFile = new File("D:\\CodeJAVA\\Test\\Demo\\src\\main\\resources\\static\\imgs\\" + multipartFile);
			byte[] fileContent = FileUtils.readFileToByteArray(inputFile);
			String encodedString = Base64.getEncoder().encodeToString(fileContent);
			p.setMyfile(encodedString);
////			String fileName = multipartFile.getOriginalFilename();
////			File f = new File(this.getFolderUpload(), fileName);
////			System.out.println(fileName + " " + f.getAbsolutePath());
////			multipartFile.transferTo(f);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return productRepository.save(p);
	}

	public Product findByNameProduct(String nameProduct) {
		return productRepository.findByNameProduct(nameProduct);
	}

	public Product findByIdProduct(String idProduct) {
		return productRepository.findByIdProduct(idProduct);
	}

	public List<String> searchProduct(String keyword) {
		return productRepository.searchProduct(keyword);
	}

	public Page<Product> getList(int page) {
		return productRepository.findAll(PageRequest.of(page, 5, Sort.by(Sort.Direction.ASC, "idProduct")));
	}

	public void updatePrice(long price, String idProduct) {
		productRepository.updatePrice(price, idProduct);
	}

	public List<Object> getTrends(int year, String idCategory) {
		List<String> listIdProducts = invoiceRepository.getTop10Product(idCategory, year, PageRequest.of(0, 10));
		List<Object> results = new ArrayList<Object>();
		for (int i = 0; i < listIdProducts.size(); i++) {
			System.out.println("top 10 " + listIdProducts.get(i));
			List<StaticDto> staticDto = invoiceRepository.getTrends(listIdProducts.get(i), year);
			System.out.println("service " + staticDto.size());
			results.add(staticDto);
		}

		return results;
	}

	public String randomId(int limit, String ngay) {
		String id = "P";
		Random r = new Random();
		List<Product> listIn = productRepository.findAll();
		int stt = r.nextInt(limit);
		int count = 0;
		while (count != listIn.size() || stt == 0) {
			stt = r.nextInt(limit);
			count = 0;
			for (int i = 0; i < listIn.size(); i++) {
				if (Integer.parseInt(listIn.get(i).getIdProduct().substring(5, 8).trim()) == stt) {
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
