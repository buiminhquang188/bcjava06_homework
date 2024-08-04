package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.dto.TaskProgressDTO;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.repository.ProjectRepository;
import org.cybersoft.capstone.repository.TaskRepository;
import org.cybersoft.capstone.repository.impl.ProjectRepositoryImpl;
import org.cybersoft.capstone.repository.impl.TaskRepositoryImpl;
import org.cybersoft.capstone.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository = new TaskRepositoryImpl();
    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    @Override
    public List<TaskEntity> getTasks() {
        return this.taskRepository.getTasks();
    }

    @Override
    public List<TaskEntity> getTasks(Integer id) {
        return this.taskRepository.getTasks(id);
    }

    @Override
    public TaskEntity getTask(Integer id) {
        return this.taskRepository.getTask(id);
    }

    @Override
    public Boolean createTask(TaskDTO taskDTO) {
        Integer resultIndex = this.taskRepository.createTask(taskDTO);

        return resultIndex > 0;
    }

    @Override
    public Boolean deleteTask(Integer id) {
        Integer resultIndex = this.taskRepository.deleteTask(id);
        return resultIndex > 0;
    }

    @Override
    public Boolean updateTask(Integer id, TaskDTO taskDTO) {
        Integer resultIndex = this.taskRepository.updateTask(id, taskDTO);
        return resultIndex > 0;
    }

    @Override
    public Boolean updateProgressTask(Integer id, TaskProgressDTO taskProgressDTO) {
        Integer resultIndex = this.taskRepository.updateProgressTask(id, taskProgressDTO);
        return resultIndex > 0;
    }

    @Override
    public List<StatusEntity> getTaskStatisticByUserId(Integer userId) {
        return this.taskRepository.getTaskStatisticByUserId(userId);
    }

    @Override
    public List<StatusEntity> getTaskStatisticByOwnerIdAndUserId(Integer ownerId, Integer userId) {
        return this.taskRepository.getTaskStatisticByOwnerIdAndUserId(ownerId, userId);
    }

    @Override
    public List<TaskEntity> getTasksByUserId(Integer userId) {
        return this.taskRepository.getTaskByUserId(userId);
    }

    @Override
    public List<TaskEntity> getTaskByOwnerId(Integer projectId) {
        return this.taskRepository.getTaskByOwnerId(projectId);
    }

    @Override
    public List<TaskEntity> getTaskByOwnerIdAndUserId(Integer ownerId, Integer userId) {
        return this.taskRepository.getProjectIdByOwnerIdAndUserId(ownerId, userId);
    }
}
