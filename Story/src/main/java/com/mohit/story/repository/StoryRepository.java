package com.mohit.story.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.story.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {

}
