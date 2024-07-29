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
                UserEntity user = new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );

                users.add(user);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public List<UserEntity> getUserOptionsByRole(Integer id) {
        List<UserEntity> users = new ArrayList<>();
        String sql = """
                SELECT u.id, u.first_name, u.last_name
                FROM users u
                WHERE u.id_role = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name")
                );

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
}