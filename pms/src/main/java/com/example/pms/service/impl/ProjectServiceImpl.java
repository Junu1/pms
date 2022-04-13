package com.example.pms.service.impl;

import com.example.pms.dto.ProjectDTO;
import com.example.pms.model.Project;
import com.example.pms.repository.ProjectRepository;
import com.example.pms.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public boolean saveProject(ProjectDTO projectDTO) {
        Project project = new Project();
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setAddedDate(new Date());
        projectRepository.save(project);
        return true;
    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        List<ProjectDTO> projectDTOList = new ArrayList<>();
        for (Project project : projects) {
            ProjectDTO projectDTO = new ProjectDTO();
            projectDTO.setId(project.getId());
            projectDTO.setName(project.getName());
            projectDTO.setDescription(project.getDescription());
            projectDTO.setAddedDate(project.getAddedDate());
            projectDTOList.add(projectDTO);
        }
        return projectDTOList;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO projectDTO) {
        Project project = projectRepository.getById(projectDTO.getId());
        project.setId(projectDTO.getId());
        project.setName(projectDTO.getName());
        project.setDescription(projectDTO.getDescription());
        project.setAddedDate(new Date());
        projectRepository.save(project);
        return projectDTO;
    }

}
