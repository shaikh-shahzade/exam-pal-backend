package com.exampal.model.quiz;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	private Integer TotalAttempted;
	private Integer correctAnswers;
	private Long timeTaken;
	
	@OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	@JoinColumn(name="result")
	private List<AttemptedQuestion> attemptedQuestion = new  ArrayList<AttemptedQuestion>();
	
//	@OneToOne(mappedBy = "result",cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//	@JsonIgnore
//	private QuizAttempt attempt;
	
}
