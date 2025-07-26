package com.exampal.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ai_audit_logs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AIAuditLog {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String type;

	@Column(length = 5000)
	private String prompt;

	@Column(length = 10000)
	private String response;

	private LocalDateTime timestamp;
	
	 public AIAuditLog(String type, String prompt, String response, LocalDateTime timestamp) {
	        this.type = type;
	        this.prompt = prompt;
	        this.response = response;
	        this.timestamp = timestamp;
	    }
	

}
