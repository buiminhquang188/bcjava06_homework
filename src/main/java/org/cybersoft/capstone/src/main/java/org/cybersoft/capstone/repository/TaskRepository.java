package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskRepository {
    List<TaskEntity> getTasks();

    Integer createTask(TaskDTO taskDTO);

    Integer deleteTask(Integer id);
}
