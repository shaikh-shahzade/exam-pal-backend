package com.exampal.model.quiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import com.exampal.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "quiz")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long qid;
	private boolean active;
	private String title;
	@Column(length = 99999999)
	private String description;
	private int maxMarks;
	private int passingMarks;
	private int noOfQuestions;
	private int maxTime;
	@Column(name = "lastDate", columnDefinition = "TIMESTAMP")
	private LocalDateTime lastDate;
	@Column(name = "startDate", columnDefinition = "TIMESTAMP")
	private LocalDateTime startDate;
	private String difficulty;
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonIgnore
	private User user;
	
	@OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Question> question = new ArrayList<Question>();
	
	@ManyToOne()
	private Category category;
	//private int cid;
	
	@OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	private List<QuizAttempt> quizAttempt = new ArrayList<QuizAttempt>();
	
	
}
