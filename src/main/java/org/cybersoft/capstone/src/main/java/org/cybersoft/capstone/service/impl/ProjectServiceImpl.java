package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.repository.ProjectRepository;
import org.cybersoft.capstone.repository.impl.ProjectRepositoryImpl;
import org.cybersoft.capstone.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

    @Override
    public List<ProjectEntity> getProjects() {
        return this.projectRepository.getProjects();
    }

    @Override
    public List<ProjectEntity> getProjects(Integer id) {
        return this.projectRepository.getProjects(id);
    }

    @Override
    public ProjectEntity getProject(Integer id) {
        return this.projectRepository.getProject(id);
    }

    @Override
    public Boolean createProject(ProjectDTO projectDTO) {
        Integer resultIndex = this.projectRepository.createProject(projectDTO);
        return resultIndex > 0;
    }

    @Override
    public Boolean updateProject(Integer id, ProjectDTO projectDTO) {
        Integer resultIndex = this.projectRepository.updateProject(id, projectDTO);
        return resultIndex > 0;
    }

    @Override
    public Boolean deleteProject(Integer id) {
        Integer resultIndex = this.projectRepository.deleteProject(id);
        return resultIndex > 0;
    }

    @Override
    public List<ProjectEntity> getProjectOptions() {
        return this.projectRepository.getProjectOptions();
    }

    @Override
    public List<ProjectEntity> getProjectOptions(Integer id) {
        return this.projectRepository.getProjectOptions(id);
    }

    @Override
    public List<ProjectEntity> getProjectDetail(Integer id) {
        return this.projectRepository.getProjectDetail(id);
    }

    @Override
    public List<StatusEntity> getProjectStatistic(Integer id) {
        return this.projectRepository.getProjectStat(id);
    }

}
