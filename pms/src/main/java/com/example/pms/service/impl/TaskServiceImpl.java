package com.example.pms.service.impl;

import com.example.pms.dto.TaskDTO;
import com.example.pms.model.Task;
import com.example.pms.repository.TaskRepository;
import com.example.pms.service.TaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public boolean saveTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setCreatedDate(new Date());
        taskRepository.save(task);
        return true;
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDTO> taskDTOList = new ArrayList<>();
        for (Task task : tasks) {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setId(task.getId());
            taskDTO.setName((task.getName()));
            taskDTO.setDescription(task.getDescription());
            taskDTO.setCreatedDate(task.getCreatedDate());
            taskDTOList.add(taskDTO);
        }
        return taskDTOList;
    }

    @Override
    public TaskDTO updateTask(TaskDTO taskDTO) {
        Task task = taskRepository.getById(taskDTO.getId());
        task.setId(taskDTO.getId());
        task.setName(taskDTO.getName());
        task.setDescription(taskDTO.getDescription());
        task.setCreatedDate(new Date());
        taskRepository.save(task);
        return taskDTO;
    }
}
