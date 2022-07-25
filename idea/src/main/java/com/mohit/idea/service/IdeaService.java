package com.mohit.idea.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.idea.dto.IdeaDTO;
import com.mohit.idea.entity.Idea;
import com.mohit.idea.repository.IdeaRepository;

import jakarta.validation.Valid;

@Service
public class IdeaService {

	@Autowired
	IdeaRepository ideaRepository;

	public List<IdeaDTO> getAllIdeas() {
		List<Idea> ideas = ideaRepository.findAll();
		List<IdeaDTO> ideaDtos = new ArrayList<>();
		for (Idea idea : ideas) {
			IdeaDTO ideaDto = IdeaDTO.valueOf(idea);
			ideaDtos.add(ideaDto);
		}
		return ideaDtos;
	}

	public String createIdea(@Valid IdeaDTO ideaDto) {
		Idea idea = ideaDto.createEntity();
		ideaRepository.save(idea);

		return "Successfully Created Idea";
	}

	public String updateIdea(@Valid IdeaDTO ideaDto) {
		Idea idea = ideaDto.createEntity();
		ideaRepository.save(idea);

		return "Successfully Updated Idea";
	}

	public String deleteIdea(Long ideaId) {
		Optional<Idea> idea = ideaRepository.findById(ideaId);
		if (idea.isPresent()) {
			Idea entityIdea = idea.get();
			ideaRepository.delete(entityIdea);
		}

		return "Successfully Deleted Idea";
	}

}
