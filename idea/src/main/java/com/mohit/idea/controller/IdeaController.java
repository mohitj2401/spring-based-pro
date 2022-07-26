package com.mohit.idea.controller;

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

import com.mohit.idea.dto.ErrorMessage;
import com.mohit.idea.dto.IdeaDTO;
import com.mohit.idea.service.IdeaService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/idea")
public class IdeaController {
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IdeaService ideaService;

	@GetMapping
	public List<IdeaDTO> getIdea() {
		return ideaService.getAllIdeas();
	}

	@SuppressWarnings("rawtypes")
	@PostMapping
	public ResponseEntity createIdea(@Valid @RequestBody IdeaDTO ideaDTO, Errors errors) {

		String response = "";
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(","));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			error.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(error);

		}
		return ResponseEntity.ok(ideaService.createIdea(ideaDTO));
	}

	@SuppressWarnings("rawtypes")
	@PutMapping
	public ResponseEntity updateIdea(@Valid @RequestBody IdeaDTO ideaDTO, Errors errors) {
		String response = "";
		if (errors.hasErrors()) {
			response = errors.getAllErrors().stream().map(ObjectError::getDefaultMessage)
					.collect(Collectors.joining(",/n"));
			ErrorMessage error = new ErrorMessage();
			error.setMessage(response);
			error.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return ResponseEntity.ok(error);

		}
		return ResponseEntity.ok(ideaService.updateIdea(ideaDTO));
	}

	@DeleteMapping("/{ideaId}")
	public String deleteIdea(@PathVariable("ideaId") Long ideaId) {
		return ideaService.deleteIdea(ideaId);
	}
}
