package org.cybersoft.capstone.service;

import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;

public interface TaskService {
    List<TaskEntity> getTasks();
}
