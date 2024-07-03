package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectEntity> getProjects();

    ProjectEntity getProject(Integer id);

    Boolean createProject(ProjectDTO projectDTO);

    Boolean updateProject(Integer id, ProjectDTO projectDTO);

    Boolean deleteProject(Integer id);

    List<ProjectEntity> getProjectOptions();
}
