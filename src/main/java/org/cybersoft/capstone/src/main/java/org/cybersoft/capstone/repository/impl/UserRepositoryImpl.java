package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.UserRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<>();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT u.id, u.first_name, u.last_name, u.username, r.name
                FROM users u
                         JOIN roles r ON r.id = u.id_role
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("execute query getUsers");

            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));

                RoleEntity role = new RoleEntity();
                role.setName(resultSet.getString("name"));
                user.setRole(role);

                users.add(user);
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public UserEntity getUser(Integer id) {
        UserEntity user = new UserEntity();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT u.id, u.first_name, u.last_name, u.username
                FROM users u
                WHERE u.id = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public Integer createUser(UserDTO userDTO) {
        Integer resultIndex = null;

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                INSERT INTO users(first_name, last_name, username, phone, password, id_role)
                VALUE (?, ?, ?, ?, ?, ?)
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, userDTO.getFirstName());
            preparedStatement.setString(2, userDTO.getLastName());
            preparedStatement.setString(3, userDTO.getUsername());
            preparedStatement.setString(4, userDTO.getPhoneNumber());
            preparedStatement.setString(5, userDTO.getPassword());
            preparedStatement.setInt(6, userDTO.getRole());

            resultIndex = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer deleteUser(Integer id) {
        Integer resultIndex = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                DELETE
                FROM users u
                WHERE u.id = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultIndex = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public List<UserEntity> getUserOptions() {
        List<UserEntity> users = new ArrayList<>();
        String sql = """
                SELECT u.id, u.first_name, u.last_name from users u
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));

                users.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public List<UserEntity> getUserOptionsByRoleIdAndUserId(Integer roleId, Integer userId) {
        List<UserEntity> users = new ArrayList<>();
        String sql = """
                SELECT u.id, u.first_name, u.last_name
                FROM users u
                WHERE u.id_role = ? AND u.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, roleId);
            preparedStatement.setInt(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));

                users.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public List<UserEntity> getUserOptionsInRole(List<Integer> roleIds) {
        List<UserEntity> users = new ArrayList<>();
        String sql = String.format("""
                SELECT u.id, u.first_name, u.last_name
                FROM users u
                WHERE u.id_role IN (%s)
                """, roleIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity(resultSet.getInt("id"), resultSet.getString("first_name"), resultSet.getString("last_name"));

                users.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public UserEntity getUserByUsernameAndPassword(LoginDTO loginDTO) {
        UserEntity user = new UserEntity();
        String sql = """
                SELECT u.id, u.username FROM users u
                WHERE u.username = ? AND u.password = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, loginDTO.getUsername());
            preparedStatement.setString(2, loginDTO.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public List<UserEntity> getUsersInProject(List<Integer> projectIds) {
        List<UserEntity> users = new ArrayList<>();
        Connection connection = MySQLConfig.getConnection();

        String sql = String.format("""
                SELECT u.id, u.first_name, u.last_name, u.username, r.name
                FROM users u
                         LEFT JOIN users_project up ON up.id_user = u.id
                         JOIN roles r ON r.id = u.id_role
                WHERE up.id_project IN (%s)
                GROUP BY u.id;
                """, projectIds.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getInt("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setUsername(resultSet.getString("username"));

                RoleEntity role = new RoleEntity();
                role.setName(resultSet.getString("name"));
                user.setRole(role);

                users.add(user);
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public UserEntity getUserWithRole(Integer id) {
        UserEntity user = new UserEntity();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT u.id, u.first_name, u.last_name, u.username, r.id, r.name
                FROM users u
                         LEFT JOIN roles r ON r.id = u.id_role
                WHERE u.id = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user.setId(resultSet.getInt("u.id"));
                user.setFirstName(resultSet.getString("u.first_name"));
                user.setLastName(resultSet.getString("u.last_name"));
                user.setUsername(resultSet.getString("u.username"));

                RoleEntity role = new RoleEntity(resultSet.getString("r.name"));

                user.setRole(role);
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return user;
    }

    @Override
    public List<UserEntity> getUserInProjectByOwnerId(Integer ownerId) {
        List<UserEntity> users = new ArrayList<>();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT u.id, u.first_name, u.last_name, u.username, r.name
                FROM users u
                         LEFT JOIN task t ON u.id = t.id_user
                         LEFT JOIN project p ON p.id = t.id_project
                         LEFT JOIN users_project up ON up.id_project = t.id_project
                         LEFT JOIN status s ON s.id = t.id_status
                         LEFT JOIN roles r ON r.id = u.id_role
                WHERE up.id_user = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, ownerId);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("execute query getUserInProjectByOwnerId");

            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getInt("u.id"));
                user.setFirstName(resultSet.getString("u.first_name"));
                user.setLastName(resultSet.getString("u.last_name"));
                user.setUsername(resultSet.getString("u.username"));

                RoleEntity role = new RoleEntity();
                role.setName(resultSet.getString("r.name"));
                user.setRole(role);

                users.add(user);
            }

            connection.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}