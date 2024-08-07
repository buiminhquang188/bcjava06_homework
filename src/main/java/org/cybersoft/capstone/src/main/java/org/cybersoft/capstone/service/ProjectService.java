package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;

import java.util.List;

public interface ProjectService {
    List<ProjectEntity> getProjects();

    List<ProjectEntity> getProjects(Integer id);

    ProjectEntity getProject(Integer id);

    Boolean createProject(ProjectDTO projectDTO);

    Boolean updateProject(Integer id, ProjectDTO projectDTO);

    Boolean deleteProject(Integer id);

    List<ProjectEntity> getProjectOptions(RoleDetailDTO roleDetailDTO);

    List<ProjectEntity> getProjectOptions(Integer id);

    List<ProjectEntity> getProjectDetail(Integer id);

    List<StatusEntity> getProjectStatistic(Integer id);
}
