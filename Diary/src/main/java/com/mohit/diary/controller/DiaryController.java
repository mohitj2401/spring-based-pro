package com.mohit.diary.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.diary.dto.DiaryDto;
import com.mohit.diary.dto.ErrorMessage;
import com.mohit.diary.service.DiaryService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	DiaryService service;

	@GetMapping
	public List<DiaryDto> getAllDiary() {
		return service.getAllDiary();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity createDiary(@Valid @RequestBody DiaryDto diaryDTO, Errors errors) {
		String response = "";
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			error.setCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(error);

		}
		return ResponseEntity.ok(service.createDiary(diaryDTO));
	}

	@SuppressWarnings("rawtypes")
	@PutMapping
	public ResponseEntity updateDiary(@Valid @RequestBody DiaryDto diaryDTO, Errors errors) {
		String response = "";
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(",/n"));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			error.setCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(error);

		}
		return ResponseEntity.ok(service.updateDiary(diaryDTO));
	}

	@DeleteMapping("/{diaryId}")
	public String deleteDiary(@PathVariable("diaryId") Long diaryId) {
		return service.deleteDiary(diaryId);
	}
}
