package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.entity.TaskEntity;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserMapper {
    public Map<String, List<TaskEntity>> tasksEntitiesToResponse(List<TaskEntity> tasks) {
        return tasks.stream()
                .collect(Collectors.groupingBy(taskEntity -> taskEntity.getStatus()
                        .getName()));
    }
}
