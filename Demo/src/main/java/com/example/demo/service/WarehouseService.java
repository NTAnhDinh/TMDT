package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Warehouse> getList() {

		return warehouseRepository.findAll();
	}

	public int buyProduct(WarehouseId id, int quantity, String idInvoice) {
		System.out.println("t gui "+id.toString()+" "+quantity+" "+idInvoice);
		int error = 0;
		Warehouse w = warehouseRepository.getWarehouse(id.getIdWarehouse(), id.getIdProduct());
		List<InvoiceDetail> listid = is.getById(idInvoice);
		int remain = w.getNumberInventory() - quantity;
		
		InvoiceDetail ide = new InvoiceDetail();
		for (InvoiceDetail invoiceDetail : listid) {
			System.out.println(invoiceDetail.toString());
			if (invoiceDetail.getProduct().getIdProduct().equals(id.getIdProduct())) {
				ide = invoiceDetail;
				break;
			}
		}
		if (remain < 0) {
			System.out.println(id.getIdProduct()+" run out of");
			error =1;

		} else {
			System.out.println("ban duoc "+w.getSoldedNumber()+" "+quantity);
			w.setSoldedNumber(w.getSoldedNumber() + quantity);
			w.setNumberInventory(remain);
			ide.setStatus(1);
			is.addInvoiceDetail(ide);
			warehouseRepository.save(w);
			error = 0;
		}
		return error;
	}

	public static void main(String[] args) {

	}

}
