package com.mohit.diary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohit.diary.repository.DiaryRepository;

@Service
public class DiaryService {

	@Autowired
	DiaryRepository repository;
}
