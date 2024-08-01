package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.constant.Role;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.ProjectRepository;
import org.cybersoft.capstone.repository.TaskRepository;
import org.cybersoft.capstone.repository.UserRepository;
import org.cybersoft.capstone.repository.impl.ProjectRepositoryImpl;
import org.cybersoft.capstone.repository.impl.TaskRepositoryImpl;
import org.cybersoft.capstone.repository.impl.UserRepositoryImpl;
import org.cybersoft.capstone.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();
    private final TaskRepository taskRepository = new TaskRepositoryImpl();

    @Override
    public List<UserEntity> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public List<UserEntity> getUsersInProject(Integer id) {
        List<Integer> projectIds = this.projectRepository.getProjectIdsByUserId(id);
        return this.userRepository.getUsersInProject(projectIds);
    }

    @Override
    public UserEntity getUser(Integer id) {
        return this.userRepository.getUser(id);
    }

    @Override
    public Integer createUser(UserDTO userDTO) {
        Integer resultIndex = this.userRepository.createUser(userDTO);
        Boolean result = this.createUserPermission(userDTO.getRole(), resultIndex);
        if (result) return resultIndex;
        return 0;
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Integer resultIndex = this.userRepository.deleteUser(id);
        Integer resultDeleteTask = this.taskRepository.updateTaskByUserId(id);
        return this.deleteUserPermission(id);
    }

    @Override
    public List<UserEntity> getUserOptions(RoleDetailDTO roleDetailDTO) {
        if (roleDetailDTO.getName()
                .equals("ADMIN")) {
            return this.userRepository.getUserOptions();
        }

        return this.userRepository.getUserOptionsInRole(List.of(Role.LEADER.getId(), Role.USER.getId()));
    }

    @Override
    public List<UserEntity> getUserOptionsByRole(RoleDetailDTO roleDetailDTO) {
        if (roleDetailDTO.getName()
                .equals("ADMIN")) {
            return this.userRepository.getUserOptionsInRole(List.of(
                    Role.ADMIN.getId(), Role.LEADER.getId()
            ));
        }

        return this.userRepository.getUserOptionsByRoleIdAndUserId(Role.LEADER.getId(), roleDetailDTO.getId());
    }

    @Override
    public UserEntity getUserWithRole(Integer id) {
        return this.userRepository.getUserWithRole(id);
    }

    @Override
    public List<UserEntity> getUserInProjectByOwnerId(Integer ownerId) {
        return this.userRepository.getUserInProjectByOwnerId(ownerId);
    }

    @Override
    public Boolean createUserPermission(Integer roleId, Integer userId) {
        Integer result = this.userRepository.createUserPermission(roleId, userId);
        return result > 0;
    }

    @Override
    public Boolean deleteUserPermission(Integer userId) {
        Integer result = this.userRepository.deleteUserPermission(userId);
        return result > 0;
    }
}
