package com.mohit.idea.dto;

import java.sql.Timestamp;

import com.mohit.idea.entity.Idea;

import jakarta.validation.constraints.NotNull;

public class IdeaDTO {

	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String content;

	@NotNull
	private String status;

	private Timestamp completedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getCompletedAt() {
		return completedAt;
	}

	public void setCompletedAt(Timestamp completedAt) {
		this.completedAt = completedAt;
	}

	public static IdeaDTO valueOf(Idea idea) {
		IdeaDTO ideaDto = new IdeaDTO();
		ideaDto.setCompletedAt(idea.getCompletedAt());
		ideaDto.setContent(idea.getContent());
		ideaDto.setTitle(idea.getTitle());
		ideaDto.setId(idea.getId());
		ideaDto.setStatus(idea.getStatus());
		return ideaDto;
	}

	public Idea createEntity() {
		Idea idea = new Idea();
		idea.setCompletedAt(this.getCompletedAt());
		idea.setContent(this.getContent());
		idea.setTitle(this.getTitle());
		idea.setId(this.getId());
		idea.setStatus(this.getStatus());
		return idea;
	}
}
