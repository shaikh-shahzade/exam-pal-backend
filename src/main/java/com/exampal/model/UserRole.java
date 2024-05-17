package com.exampal.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * UserRoles:
 * 	1: admin
 * 	2: user
 * 	3: host
 * 
 * */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class UserRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JsonIgnore
	private User user;
	
	@ManyToOne( cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Role role;
}
