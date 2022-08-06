package com.mohit.idea.entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Idea {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "content", nullable = false, columnDefinition = "TEXT")
	private String content;

	@Column(nullable = false)
	private Timestamp created_at;

	@Column(nullable = false)
	private String status;

	@Column(nullable = true)
	private Timestamp completed_at;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCompleted_at() {
		return completed_at;
	}

	public void setCompleted_at(Timestamp completed_at) {
		this.completed_at = completed_at;
	}

}
