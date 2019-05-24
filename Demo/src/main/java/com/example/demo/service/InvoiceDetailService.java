package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.InvoiceDetail;
import com.example.demo.repository.InvoiceDetailRepository;

@Service
public class InvoiceDetailService {
	@Autowired
	InvoiceDetailRepository invoiceDetailRepository;

	public void addInvoiceDetail(InvoiceDetail id) {
		invoiceDetailRepository.save(id);
	}

	public List<InvoiceDetail> getList() {
		return invoiceDetailRepository.findAll();
	}
public List<InvoiceDetail> getById(String id){
	List<InvoiceDetail> l= new ArrayList<>();
	l.addAll(invoiceDetailRepository.getById1(id));
	return l;
}
	public static void main(String[] args) {
		List<InvoiceDetail> l = new InvoiceDetailService().getList();
		for (InvoiceDetail invoiceDetail : l) {
			System.out.println(invoiceDetail.toString());
		}
	}
}
