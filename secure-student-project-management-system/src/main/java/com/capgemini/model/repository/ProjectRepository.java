package com.capgemini.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.model.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

    List<Project> findByStudentId(Integer studentId);
}