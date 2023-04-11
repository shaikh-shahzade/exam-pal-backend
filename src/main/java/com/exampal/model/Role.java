package com.exampal.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

	@Id
	
	private Long id;
	private String role;
	
	@OneToMany(mappedBy ="role" ,fetch = FetchType.EAGER , cascade = CascadeType.ALL)
	@JsonIgnore
	Set<UserRole> userRole = new HashSet<UserRole>();
}
