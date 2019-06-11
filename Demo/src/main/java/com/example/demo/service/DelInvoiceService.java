package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DeletedInvoice;
import com.example.demo.repository.DelInvoiceRepository;

@Service
public class DelInvoiceService {
	@Autowired
	DelInvoiceRepository re;

	public DeletedInvoice save(DeletedInvoice d) {
		return re.save(d);
	}
}
