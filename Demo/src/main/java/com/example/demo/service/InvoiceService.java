package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Invoice;
import com.example.demo.repository.InvoiceRepository;

@Service
public class InvoiceService {
	@Autowired
	InvoiceRepository invoiceRepository;
	@Autowired
	ReceiptService receiptService;

	public void addInvoice(Invoice in) {
		invoiceRepository.save(in);

	}

	public Invoice getOne(String idIn) {
		return invoiceRepository.getOne(idIn);
	}

	public Page<Invoice> findAll(int page) {
		return invoiceRepository.findAll(PageRequest.of(page,5,Sort.by(Sort.Direction.ASC,"idInvoice")));
	}


	public void delete(String idInvoice, int status) {
		Invoice invoice = invoiceRepository.getOne(idInvoice);
		invoice.setStatus(status);
		invoiceRepository.save(invoice);
	}

	public String randomId(int limit, String ngay) {
		String id = "IV";
		Random r = new Random();
		List<Invoice> listIn = invoiceRepository.findAll();
		int stt = r.nextInt(limit);
		int count = 0;
		while (count != listIn.size() || stt == 0) {
			stt = r.nextInt(limit);
			count = 0;
			for (int i = 0; i < listIn.size(); i++) {
				if (Integer.parseInt(listIn.get(i).getIdInvoice().substring(6, 10).trim()) == stt) {
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

	public int getQuantityInvoice() {
		return invoiceRepository.getInvoiceInDay();

	}
	public long getSumMoney() {
		
		return invoiceRepository.getSumMoneyInDay();

	}
	
	public int getDeletedInvoice() {
		return invoiceRepository.getDeletedInvoice();

	}
	
	public int getItemReturned() {
		return invoiceRepository.getItemReturned();

	}


}
