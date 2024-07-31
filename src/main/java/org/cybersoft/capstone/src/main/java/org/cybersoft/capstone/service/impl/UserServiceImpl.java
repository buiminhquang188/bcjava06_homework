package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.constant.Role;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.ProjectRepository;
import org.cybersoft.capstone.repository.UserRepository;
import org.cybersoft.capstone.repository.impl.ProjectRepositoryImpl;
import org.cybersoft.capstone.repository.impl.UserRepositoryImpl;
import org.cybersoft.capstone.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();
    private final ProjectRepository projectRepository = new ProjectRepositoryImpl();

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
        return this.userRepository.createUser(userDTO);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Integer resultIndex = this.userRepository.deleteUser(id);
        return resultIndex > 0;
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

        return this.userRepository.getUserOptionsByRole(Role.LEADER.getId());
    }

    @Override
    public UserEntity getUserWithRole(Integer id) {
        return this.userRepository.getUserWithRole(id);
    }
}
