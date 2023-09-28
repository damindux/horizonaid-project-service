package com.horizonaid.projectsservice.service;

import com.horizonaid.projectsservice.model.Project;
import com.horizonaid.projectsservice.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public void updateProject(Project project) {
        Project savedProject = projectRepository.findById(project.getId())
                .orElseThrow(() -> new RuntimeException(String.format("Cannot Find the Project %s", project.getId())));

        savedProject.setTitle(project.getTitle());
        savedProject.setDescription(project.getDescription());
        savedProject.setFundingGoal(project.getFundingGoal());
        savedProject.setStartDate(project.getStartDate());
        savedProject.setEndDate(project.getEndDate());

        projectRepository.save(project);
    }

    public Project getProjectById(String id) {
        Optional<Project> projectOptional = projectRepository.findById(id);

        if (projectOptional.isPresent())
            return projectOptional.get();
        else
            throw new RuntimeException("Project Not Found!");
    }

    public void deleteProject(String id) {
        projectRepository.deleteById(id);
    }
}
