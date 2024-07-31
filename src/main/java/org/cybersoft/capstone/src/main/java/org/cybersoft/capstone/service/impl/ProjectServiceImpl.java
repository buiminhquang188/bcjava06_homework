package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.UsersProjectEntity;
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

        UsersProjectEntity usersProjectEntity = this.projectRepository.getUsersProjectByUserIdAndProjectId(projectDTO.getUserIdProject(), resultIndex);

        if (usersProjectEntity == null) {
            this.projectRepository.createUserProject(projectDTO.getUserIdProject(), resultIndex);
        }

        return resultIndex > 0;
    }

    @Override
    public Boolean updateProject(Integer id, ProjectDTO projectDTO) {
        ProjectEntity project = this.getProject(id);
        UsersProjectEntity usersProjectEntity = null;
        Integer resultIndex = this.projectRepository.updateProject(id, projectDTO);

        if (project.getUser()
                    .getId() != null && project.getId() != null) {
            usersProjectEntity = this.projectRepository.getUsersProjectByUserIdAndProjectId(
                    project.getUser()
                            .getId(),
                    project.getId()
            );
        } else {
            usersProjectEntity = this.projectRepository.getUsersProjectByUserIdAndProjectIdIsNull(
                    project.getUser()
                            .getId()
            );
        }

        if (usersProjectEntity != null) {
            this.projectRepository.updateUserProjectByUserIdAndProjectId(
                    project.getUser()
                            .getId(),
                    project.getId(),
                    projectDTO.getUserIdProject(),
                    id
            );
        } else {
            this.projectRepository.createUserProject(projectDTO.getUserIdProject(), id);
        }

        return resultIndex > 0;
    }

    @Override
    public Boolean deleteProject(Integer id) {
        Integer resultIndex = this.projectRepository.deleteProject(id);
        return resultIndex > 0;
    }

    @Override
    public List<ProjectEntity> getProjectOptions(RoleDetailDTO roleDetailDTO) {
        if (roleDetailDTO.getName()
                .equals("ADMIN")) {
            return this.projectRepository.getProjectOptions();
        }
        return this.projectRepository.getProjectOptions(roleDetailDTO.getId());
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
