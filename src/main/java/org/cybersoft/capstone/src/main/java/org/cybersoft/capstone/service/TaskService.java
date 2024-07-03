package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> getTasks();

    TaskEntity getTask(Integer id);

    Boolean createTask(TaskDTO taskDTO);

    Boolean deleteTask(Integer id);

    Boolean updateTask(Integer id, TaskDTO taskDTO);
}
