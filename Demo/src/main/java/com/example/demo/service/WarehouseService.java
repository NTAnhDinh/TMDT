package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.model.Warehouse;
import com.example.demo.model.WarehouseId;
import com.example.demo.repository.WarehouseRepository;

@Service
public class WarehouseService {
	@Autowired
	WarehouseRepository warehouseRepository;
	@Autowired
	InvoiceDetailService is;

	public Page<Warehouse> getList(int page) {

		return warehouseRepository.findAll(PageRequest.of(page,3,Sort.by(Sort.Direction.ASC,"product.idProduct")));
	}
public Warehouse getByIdProduct(String idProduct) {
	return warehouseRepository.getByIdProduct(idProduct);
}
	public int buyProduct(WarehouseId id, int quantity, String idInvoice) {
		System.out.println("t gui " + id.toString() + " " + quantity + " " + idInvoice);
		int error = 0;
		Warehouse w = warehouseRepository.getWarehouse(id.getIdWarehouse(), id.getIdProduct());
		List<InvoiceDetail> listid = is.getById(idInvoice);
		int remain = w.getNumberInventory() - quantity;

		InvoiceDetail ide = new InvoiceDetail();
		if (ide.getStatus() == 0) {// row chi tiet chua dc duyet
			for (InvoiceDetail invoiceDetail : listid) {
				System.out.println(invoiceDetail.toString());
				if (invoiceDetail.getProduct().getIdProduct().equals(id.getIdProduct())) {
					ide = invoiceDetail;
					break;
				}
			}
			if (remain < 0) {
				System.out.println(id.getIdProduct() + " run out of");
				w.setStatus(1);// xet trang thai sp trong kho het hang
				error = 1;

			} else {
				System.out.println("ban duoc " + w.getSoldedNumber() + " " + quantity);
				w.setSoldedNumber(w.getSoldedNumber() + quantity);
				w.setNumberInventory(remain);
				ide.setStatus(1);
				is.addInvoiceDetail(ide);
				error = 0;
			}
		}
		else {
			error=2;// thong bao hoa don da finish roi
		}
		warehouseRepository.save(w);
		return error;
	}

	public static void main(String[] args) {

	}

}
