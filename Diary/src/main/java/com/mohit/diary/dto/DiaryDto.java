package com.mohit.diary.dto;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.mohit.diary.entity.Diary;

import jakarta.validation.constraints.NotNull;

public class DiaryDto {

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

	public static DiaryDto valueOf(Diary diary) {
		DiaryDto diaryDto = new DiaryDto();
		diaryDto.setContent(diary.getContent());
		diaryDto.setId(diary.getId());
		diaryDto.setTitle(diary.getTitle());
		diaryDto.setCreated_at(diary.getCreated_at());
		return diaryDto;
	}

	public Diary createEntity() {
		Diary diary = new Diary();
		diary.setContent(this.getContent());
		diary.setId(this.getId());
		diary.setTitle(this.getTitle());
		diary.setCreated_at(this.getCreated_at());
		return diary;
	}
}
