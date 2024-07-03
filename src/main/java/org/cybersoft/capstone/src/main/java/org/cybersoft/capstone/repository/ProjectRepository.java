package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;

import java.util.List;

public interface ProjectRepository {
    List<ProjectEntity> getProjects();

    ProjectEntity getProject(Integer id);

    Integer createProject(ProjectDTO projectDTO);

    Integer updateProject(Integer id, ProjectDTO projectDTO);

    Integer deleteProject(Integer id);

    List<ProjectEntity> getProjectOptions();
}
