package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.repository.TaskRepository;
import org.cybersoft.capstone.repository.impl.TaskRepositoryImpl;
import org.cybersoft.capstone.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public List<TaskEntity> getTasks() {
        return this.taskRepository.getTasks();
    }
}
