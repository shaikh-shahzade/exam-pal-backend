package com.exampal.service;

import reactor.core.publisher.Mono;

public interface AIService {

	public Mono<String> generateQuestions(String topic);
	public Mono<String> evaluateAnswer(String question, String studentAnswer);
}
