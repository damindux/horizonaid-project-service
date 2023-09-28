package com.horizonaid.projectsservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Document("projects")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Project {
    private String id;
    private String title;
    private String description;

    @Field(name = "goal")
    private int fundingGoal;

    @Field(name = "start-date")
    private LocalDate startDate;

    @Field(name = "end-date")
    private LocalDate endDate;
}
