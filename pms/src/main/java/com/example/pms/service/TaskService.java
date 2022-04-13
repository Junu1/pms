package com.example.pms.service;

import com.example.pms.dto.TaskDTO;

import java.util.List;

public interface TaskService {
    public boolean saveTask(TaskDTO taskDTO);

    List<TaskDTO> getAllTasks();

    TaskDTO updateTask(TaskDTO taskDTO);
}
