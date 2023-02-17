package com.demo.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.api.entity.WorkNotes;

public interface WorkNotesRepository extends JpaRepository<WorkNotes, Integer>{

}
