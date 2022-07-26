package com.mohit.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.diary.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

}
