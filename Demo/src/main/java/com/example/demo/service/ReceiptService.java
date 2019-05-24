package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Receipt;
import com.example.demo.model.ReceiptDetail;
import com.example.demo.repository.ReceiptRepository;

@Service
public class ReceiptService {
	@Autowired
	ReceiptRepository receiptRepository;

	
	public Receipt save(Receipt r) {
		return receiptRepository.save(r);
	}
}
