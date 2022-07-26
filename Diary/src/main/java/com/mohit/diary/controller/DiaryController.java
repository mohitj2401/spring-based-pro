package com.mohit.diary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.diary.service.DiaryService;

@RestController
@CrossOrigin
@RequestMapping("/diary")
public class DiaryController {

	@Autowired
	DiaryService service;
}
