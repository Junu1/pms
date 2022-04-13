package com.example.pms.controller;

import com.example.pms.dto.TaskDTO;
import com.example.pms.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskDTO>> getAllTasks(){
        return ResponseEntity.ok(taskService.getAllTasks());
    }

    @PostMapping
    public ResponseEntity<String> addTask( @RequestBody TaskDTO taskDTO){
        taskService.saveTask(taskDTO);
        return ResponseEntity.ok("Task added successfully");
    }

    @PutMapping
    public ResponseEntity<String> updateTask(@RequestBody TaskDTO taskDTO){
        taskService.saveTask(taskDTO);
        return ResponseEntity.ok("Tasks updated successfully ");
    }

}
