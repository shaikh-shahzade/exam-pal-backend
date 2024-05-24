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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Answer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	private String content;
	private Boolean isCorrect;
	private Integer choice;
	
//	
//	@ManyToOne
//	@JsonIgnore
//	private Question question;
//	
	@OneToMany(mappedBy = "answer" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JsonIgnore
	private List<AttemptedQuestion> attemptedQuestions = new ArrayList<AttemptedQuestion>();
	
	
}
