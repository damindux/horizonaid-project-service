package com.horizonaid.projectsservice.repository;

import com.horizonaid.projectsservice.model.Project;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProjectRepository extends MongoRepository<Project, String> {
}
