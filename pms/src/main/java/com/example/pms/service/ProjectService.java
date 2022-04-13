package com.example.pms.service;

import com.example.pms.dto.ProjectDTO;

import java.util.List;

public interface ProjectService {
    boolean saveProject(ProjectDTO projectDTO);

    List<ProjectDTO> getAllProjects();

    ProjectDTO updateProject(ProjectDTO projectDTO);
}
