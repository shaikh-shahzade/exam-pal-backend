package com.exampal.model;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.id.factory.spi.GenerationTypeStrategy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Quiz")
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
	@Column(length = 65555)
	private String description;
	private int maxMarks;
	private int noOfQuestions;
	private int maxTime;
	private LocalDate lastDate;
	private LocalDate startDate;
	
	
	@ManyToOne()
	private User user;
	
	@OneToMany(mappedBy = "quiz" ,cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Question> question;
	
	@ManyToOne()
	private Category category;
	//private int cid;
	
	
}
