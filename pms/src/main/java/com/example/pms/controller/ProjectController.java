package com.example.pms.controller;

import com.example.pms.dto.ProjectDTO;
import com.example.pms.service.ProjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "projects")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @PostMapping
    public ResponseEntity<String> addProject(@RequestBody ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
        return ResponseEntity.ok("Projects successfully added");

    }
    @PutMapping
    public ResponseEntity<String> updateProject(@RequestBody ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
        return ResponseEntity.ok("Projects successfully updated");

    }
}
