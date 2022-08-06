package com.mohit.story.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.mohit.story.dto.ErrorMessage;
import com.mohit.story.dto.StoryDto;
import com.mohit.story.service.StoryService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/story")
public class StoryController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	StoryService service;

	@GetMapping
	public List<StoryDto> getAllStories() {
		return service.getAllStories();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity createStory(@Valid @RequestBody StoryDto storyDto, Errors errors) {
		List<String> response;
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
			ErrorMessage errorResponse = new ErrorMessage();
			errorResponse.setOutput(response);
			errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(errorResponse);
		}
		service.createStory(storyDto);
		response = new ArrayList<String>();
		response.add("Hello");
		return ResponseEntity.ok(response);
	}

	@SuppressWarnings("rawtypes")
	@PutMapping
	public ResponseEntity updateStory(@Valid @RequestBody StoryDto storyDto, Errors errors) {
		List<String> response;
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList());
			ErrorMessage errorResponse = new ErrorMessage();
			errorResponse.setOutput(response);
			errorResponse.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(errorResponse);
		}
		response = service.updateStory(storyDto);

		return ResponseEntity.ok(response);
	}

	@SuppressWarnings("rawtypes")
	@DeleteMapping("/{storyId}")
	public ResponseEntity deletestory(@PathVariable("storyId") Long storyId) {
		List<String> response = service.deleteStory(storyId);
		return ResponseEntity.ok(response);
	}

}
