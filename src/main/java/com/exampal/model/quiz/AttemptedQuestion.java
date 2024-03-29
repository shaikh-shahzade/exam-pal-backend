package com.exampal.model.quiz;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class AttemptedQuestion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Answer answer;
	
	
	
}
