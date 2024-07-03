package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskRepository {
    List<TaskEntity> getTasks();
}
