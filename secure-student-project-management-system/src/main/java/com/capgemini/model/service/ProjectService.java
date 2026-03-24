package com.capgemini.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.capgemini.model.entity.Project;
import com.capgemini.model.entity.Student;
import com.capgemini.model.repository.ProjectRepository;
import com.capgemini.model.repository.StudentRepository;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Autowired
    private StudentRepository studentRepo;

    private Student getLoggedInStudent() {

        String email = SecurityContextHolder.getContext()
                .getAuthentication().getName();

        return studentRepo.findByEmail(email).get();
    }

    public Project createProject(Project project) {

        Student student = getLoggedInStudent();
        project.setStudent(student);

        return projectRepo.save(project);
    }

    public List<Project> getAllProjects() {

        Student student = getLoggedInStudent();
        return projectRepo.findByStudentId(student.getId());
    }

    public Project updateProject(Integer id, Project updatedProject) {

        Student student = getLoggedInStudent();
        Project project = projectRepo.findById(id).get();

        if (!project.getStudent().getId().equals(student.getId())) {
            throw new RuntimeException("Unauthorized Access");
        }

        project.setTitle(updatedProject.getTitle());
        project.setDescription(updatedProject.getDescription());

        return projectRepo.save(project);
    }

    public void deleteProject(Integer id) {

        Student student = getLoggedInStudent();
        Project project = projectRepo.findById(id).get();

        if (!project.getStudent().getId().equals(student.getId())) {
            throw new RuntimeException("Unauthorized Access");
        }

        projectRepo.delete(project);
    }
}