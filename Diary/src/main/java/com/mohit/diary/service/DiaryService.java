package com.mohit.diary.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.diary.dto.DiaryDto;
import com.mohit.diary.entity.Diary;
import com.mohit.diary.repository.DiaryRepository;

import jakarta.validation.Valid;

@Service
public class DiaryService {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	DiaryRepository repository;

	public List<DiaryDto> getAllDiary() {
		List<Diary> diarys = repository.findAll();
		List<DiaryDto> diaryDtos = new ArrayList<>();
		for (Diary diary : diarys) {
			logger.info(diary.toString());
			DiaryDto ideaDto = DiaryDto.valueOf(diary);
			logger.info(ideaDto.toString());
			diaryDtos.add(ideaDto);
		}
		logger.info(diaryDtos.toString());
		return diaryDtos;
	}

	public String createDiary(@Valid DiaryDto diaryDto) {
		Diary diary = diaryDto.createEntity();
		repository.save(diary);

		return "Successfully Created Diary";
	}

	public String updateDiary(@Valid DiaryDto diaryDto) {
		Diary diary = diaryDto.createEntity();
		repository.save(diary);

		return "Successfully Updated Diary";
	}

	public String deleteDiary(Long diaryId) {
		Optional<Diary> diary = repository.findById(diaryId);
		if (diary.isPresent()) {
			Diary entityDiary = diary.get();
			repository.delete(entityDiary);
		}

		return "Successfully Deleted Diary";
	}
}
