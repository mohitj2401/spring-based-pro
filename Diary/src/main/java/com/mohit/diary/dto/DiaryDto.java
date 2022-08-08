package com.mohit.diary.dto;

import java.time.LocalDateTime;

import com.mohit.diary.entity.Diary;

import jakarta.validation.constraints.NotNull;

public class DiaryDto {

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

	public static DiaryDto valueOf(Diary diary) {
		DiaryDto diaryDto = new DiaryDto();
		diaryDto.setContent(diary.getContent());
		diaryDto.setId(diary.getId());
		diaryDto.setTitle(diary.getTitle());
		diaryDto.setCreatedAt(diary.getCreatedAt());
		return diaryDto;
	}

	public Diary createEntity() {
		Diary diary = new Diary();
		diary.setContent(this.getContent());
		diary.setId(this.getId());
		diary.setTitle(this.getTitle());
		return diary;
	}

	@Override
	public String toString() {
		return "DiaryDto [id=" + id + ", title=" + title + ", content=" + content + ", createdAt=" + createdAt + "]";
	}

}
