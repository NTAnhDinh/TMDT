package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Feedback;
import com.example.demo.repository.FeedbackRepository;
@Service
public class FeedbackService {

	@Autowired
	FeedbackRepository feedbackRepository;

	public Feedback save(Feedback f) {
		return feedbackRepository.save(f);
	}
	public void e() {
//		feedbackRepository.
	}
}
