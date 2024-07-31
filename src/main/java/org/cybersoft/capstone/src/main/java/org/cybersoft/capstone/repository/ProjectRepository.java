package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.UsersProjectEntity;

import java.util.List;

public interface ProjectRepository {
    List<ProjectEntity> getProjects();

    List<ProjectEntity> getProjects(Integer id);

    ProjectEntity getProject(Integer id);

    Integer createProject(ProjectDTO projectDTO);

    Integer updateProject(Integer id, ProjectDTO projectDTO);

    Integer deleteProject(Integer id);

    List<ProjectEntity> getProjectOptions();

    List<ProjectEntity> getProjectOptions(Integer id);

    List<ProjectEntity> getProjectDetail(Integer id);

    List<StatusEntity> getProjectStat(Integer id);

    List<Integer> getProjectIdsByUserId(Integer userId);

    UsersProjectEntity getUsersProjectByUserIdAndProjectId(Integer userId, Integer projectId);

    UsersProjectEntity getUsersProjectByUserIdAndProjectIdIsNull(Integer userId);

    Integer createUserProject(Integer userId, Integer projectId);

    void updateUserProject(Integer userId, Integer projectId);

    void deleteUserProjectByProjectId(Integer id);

    void updateUserProjectByUserIdAndProjectId(Integer userId, Integer projectId, Integer inputUserId, Integer inputProjectId);
}
