package com.exampal.model.quiz;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenerationTime;

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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="question")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long quesid;
	private String content;
	
	
	@ManyToOne
	@JsonIgnore
	private Quiz quiz;
	
	@OneToMany(orphanRemoval = true, fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JoinColumn(name="question")
	private List<Answer> answers = new ArrayList<Answer>();
//	
//	@OneToMany(mappedBy = "question" , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
//	@JsonIgnore
//	private List<AttemptedQuestion> attemptedQuestions = new ArrayList<AttemptedQuestion>();
//	
	
}
