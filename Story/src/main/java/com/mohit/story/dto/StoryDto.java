package com.mohit.story.dto;

import java.time.LocalDateTime;

import com.mohit.story.entity.Story;

import jakarta.validation.constraints.NotNull;

public class StoryDto {

	private Long id;

	@NotNull(message = "Title field is required")
	private String title;

	@NotNull(message = "Content field is required")
	private String content;

	private LocalDateTime createdAt;

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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Story createEntity() {
		Story story = new Story();
		story.setId(this.getId());
		story.setContent(this.getContent());
		story.setTitle(this.getTitle());
		return story;

	}

	public static StoryDto valueOf(Story story) {
		StoryDto storyDto = new StoryDto();
		storyDto.setId(story.getId());
		storyDto.setContent(story.getContent());
		storyDto.setCreatedAt(story.getCreatedAt());
		storyDto.setTitle(story.getTitle());
		return storyDto;
	}
}
