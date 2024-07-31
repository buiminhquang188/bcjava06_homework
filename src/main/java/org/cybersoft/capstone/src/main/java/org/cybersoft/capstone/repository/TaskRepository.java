package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.dto.TaskProgressDTO;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskRepository {
    List<TaskEntity> getTasks();

    List<TaskEntity> getTasks(Integer id);

    TaskEntity getTask(Integer id);

    Integer createTask(TaskDTO taskDTO);

    Integer deleteTask(Integer id);

    Integer updateTask(Integer id, TaskDTO taskDTO);

    Integer updateTaskByProjectId(Integer id);

    Integer updateProgressTask(Integer id, TaskProgressDTO taskProgressDTO);

    List<StatusEntity> getTaskStatisticByUserId(Integer userId);

    List<TaskEntity> getTaskByUserId(Integer userId);
}
