package com.exampal.model.quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	private String text;
	private Boolean isCorrect;
	private Integer option;
}
