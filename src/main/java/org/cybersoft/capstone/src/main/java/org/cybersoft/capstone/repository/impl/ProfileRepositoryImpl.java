package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.ProfileDTO;
import org.cybersoft.capstone.entity.*;
import org.cybersoft.capstone.repository.ProfileRepository;
import org.cybersoft.capstone.util.Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfileRepositoryImpl implements ProfileRepository {
    @Override
    public ProfileEntity getProfile(Integer id) {
        ProfileEntity profile = new ProfileEntity();
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT u.id,
                       u.first_name,
                       u.last_name,
                       u.username,
                       t.id,
                       t.name,
                       t.start_date,
                       t.end_date,
                       p.id,
                       p.name,
                       s.id,
                       s.name
                FROM users u
                         INNER JOIN task t ON t.id_user = u.id
                         INNER JOIN project p ON p.id = t.id_project
                         INNER JOIN status s ON s.id = t.id_status
                WHERE u.id = ?
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                UserEntity user = new UserEntity(
                        resultSet.getInt("u.id"),
                        resultSet.getString("u.first_name"),
                        resultSet.getString("u.last_name"),
                        resultSet.getString("u.username")
                );

                ProjectEntity project = new ProjectEntity(
                        resultSet.getInt("p.id"),
                        resultSet.getString("p.name")
                );

                StatusEntity status = new StatusEntity(
                        Utils.parseIntFromResultSet(resultSet.getInt("s.id")),
                        resultSet.getString("s.name")
                );

                TaskEntity task = new TaskEntity(
                        Utils.parseIntFromResultSet(resultSet.getInt("t.id")),
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("t.start_date"),
                        resultSet.getTimestamp("t.end_date"),
                        project,
                        status
                );

                profile.setUser(user);
                profile.getTasks()
                        .add(task);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return profile;
    }

    @Override
    public List<StatusEntity> getStatProfile(Integer id) {
        List<StatusEntity> statuses = new ArrayList<>();
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT s.id, s.name, COUNT(1) AS total
                FROM users u
                         JOIN task t ON t.id_user = u.id
                         JOIN status s ON s.id = t.id_status
                WHERE u.id = ?
                GROUP BY s.id
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StatusEntity status = new StatusEntity(
                        resultSet.getInt("s.id"),
                        resultSet.getString("s.name"),
                        resultSet.getInt("total")
                );

                statuses.add(status);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statuses;
    }

    @Override
    public Integer updateProfile(ProfileDTO profileDTO, Integer userId) {
        if (profileDTO.getPassword() == null || profileDTO.getPassword()
                .isEmpty() || profileDTO.getPassword()
                    .isBlank()) {
            return this.updateProfileWithoutPassword(profileDTO, userId);
        }
        return this.updateProfileWithPassword(profileDTO, userId);
    }

    private Integer updateProfileWithPassword(ProfileDTO profileDTO, Integer userId) {
        Integer resultIndex = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE users u
                SET u.first_name = ?,
                    u.last_name  = ?,
                    u.password = ?,
                    u.phone      = ?
                WHERE u.id = ?;
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profileDTO.getFirstName());
            preparedStatement.setString(2, profileDTO.getLastName());
            preparedStatement.setString(3, profileDTO.getPassword());
            preparedStatement.setString(4, profileDTO.getPhoneNumber());
            preparedStatement.setInt(5, userId);

            resultIndex = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    private Integer updateProfileWithoutPassword(ProfileDTO profileDTO, Integer userId) {
        Integer resultIndex = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE users u
                SET u.first_name = ?,
                    u.last_name  = ?,
                    u.phone      = ?
                WHERE u.id = ?;
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, profileDTO.getFirstName());
            preparedStatement.setString(2, profileDTO.getLastName());
            preparedStatement.setString(3, profileDTO.getPhoneNumber());
            preparedStatement.setInt(4, userId);

            resultIndex = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }
}
