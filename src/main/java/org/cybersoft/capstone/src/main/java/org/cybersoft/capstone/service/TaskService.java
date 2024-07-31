package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.dto.TaskProgressDTO;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> getTasks();

    List<TaskEntity> getTasks(Integer id);

    TaskEntity getTask(Integer id);

    Boolean createTask(TaskDTO taskDTO);

    Boolean deleteTask(Integer id);

    Boolean updateTask(Integer id, TaskDTO taskDTO);

    Boolean updateProgressTask(Integer id, TaskProgressDTO taskProgressDTO);

    List<StatusEntity> getTaskStatisticByUserId(Integer userId);

    List<TaskEntity> getTasksByUserId(Integer userId);
}
