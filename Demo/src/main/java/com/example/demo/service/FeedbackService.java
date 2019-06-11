package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;

	public Page<Feedback> getAll(int page) {
		return feedbackRepository.findAll(PageRequest.of(page, 3, Sort.by(Sort.Direction.ASC, "dateReport")));
	}

	public Feedback save(Feedback f) {
		return feedbackRepository.save(f);
	}

	public Feedback getFeedback(int id) {
		return feedbackRepository.getOne(id);
	}

	public void e() {
//		feedbackRepository.
	}
}
