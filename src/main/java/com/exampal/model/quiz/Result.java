package com.exampal.model.quiz;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Result {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long resId;
	private Integer marks;
	private Integer questionsAttempted;
	private Integer correctAnswers;
	private Integer timeTaken;
	
	@OneToOne(mappedBy = "result",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private QuizAttempt attempt;
}
