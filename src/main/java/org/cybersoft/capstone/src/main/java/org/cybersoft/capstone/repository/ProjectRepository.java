package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;

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
}
