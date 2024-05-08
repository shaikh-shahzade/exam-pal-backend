package com.exampal.model.quiz;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import com.exampal.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QuizAttempt {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private LocalDate date;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private String status;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "resId")
	private Result result;
	
	@ManyToOne()
	@JoinColumn(name = "users_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "qid")
	private Quiz quiz;
	
}
