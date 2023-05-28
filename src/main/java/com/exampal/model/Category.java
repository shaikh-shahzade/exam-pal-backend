package com.exampal.model;

import java.util.List;

import org.hibernate.query.sqm.FetchClauseType;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cid;
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "category" , cascade = CascadeType.ALL , fetch = FetchType.EAGER)
	private List<Quiz> quiz;
}
