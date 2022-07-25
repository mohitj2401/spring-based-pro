package com.mohit.story.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.story.dto.StoryDto;
import com.mohit.story.entity.Story;
import com.mohit.story.repository.StoryRepository;

import jakarta.validation.Valid;

@Service
public class StoryService {

	@Autowired
	StoryRepository repository;

	public List<StoryDto> getAllStories() {
		List<Story> stories = repository.findAll();
		List<StoryDto> storyDtos = new ArrayList<>();
		for (Story story : stories) {
			StoryDto storyDto = StoryDto.valueOf(story);
			storyDtos.add(storyDto);
		}
		return storyDtos;
	}

	public List<String> createStory(@Valid StoryDto storyDto) {
		Story story = storyDto.createEntity();
		repository.save(story);
		List<String> response = new ArrayList<String>();
		response.add("hello");
		return response;
	}

	public List<String> updateStory(@Valid StoryDto storyDto) {
		Story story = storyDto.createEntity();
		repository.save(story);
		List<String> response = new ArrayList<String>();
		response.add("hello");
		return response;

	}

	public String deleteStory(Long storyId) {
		Story story = repository.findById(storyId).get();
		repository.delete(story);
		return "Deleted";
	}

}
