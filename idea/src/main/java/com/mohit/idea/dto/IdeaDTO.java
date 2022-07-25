package com.mohit.idea.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mohit.idea.entity.Idea;

import jakarta.validation.constraints.NotNull;

public class IdeaDTO {

	private Long id;

	@NotNull
	private String content;

	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date created_at;

	@NotNull
	private String status;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date completed_at;

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCompleted_at() {
		return completed_at;
	}

	public void setCompleted_at(Date completed_at) {
		this.completed_at = completed_at;
	}

	public static IdeaDTO valueOf(Idea idea) {
		IdeaDTO ideaDto = new IdeaDTO();
		ideaDto.setCompleted_at(idea.getCompleted_at());
		ideaDto.setContent(idea.getContent());
		ideaDto.setCreated_at(idea.getCreated_at());
		ideaDto.setId(idea.getId());
		ideaDto.setStatus(idea.getStatus());
		return ideaDto;
	}

	public Idea createEntity() {
		Idea idea = new Idea();
		idea.setCompleted_at(this.getCompleted_at());
		idea.setContent(this.getContent());
		idea.setCreated_at(this.getCreated_at());
		idea.setId(this.getId());
		idea.setStatus(this.getStatus());
		return idea;
	}
}
