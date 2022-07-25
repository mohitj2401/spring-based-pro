package com.mohit.story.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mohit.story.entity.Story;

import jakarta.validation.constraints.NotNull;

public class StoryDto {

	private Long id;

	@NotNull(message = "Title field is required")
	private String title;

	@NotNull(message = "Content field is required")
	private String content;

	@NotNull(message = "Created at field is required")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private Date created_at;

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

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Story createEntity() {
		Story story = new Story();
		story.setId(this.getId());
		story.setContent(this.getContent());
		story.setCreated_at(this.getCreated_at());
		story.setTitle(this.getTitle());
		return story;

	}

	public static StoryDto valueOf(Story story) {
		StoryDto storyDto = new StoryDto();
		storyDto.setId(story.getId());
		storyDto.setContent(story.getContent());
		storyDto.setCreated_at(story.getCreated_at());
		storyDto.setTitle(story.getTitle());
		return storyDto;
	}
}
