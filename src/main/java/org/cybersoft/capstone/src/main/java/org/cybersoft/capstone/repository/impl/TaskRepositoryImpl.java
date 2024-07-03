package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.TaskRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    @Override
    public List<TaskEntity> getTasks() {
        List<TaskEntity> tasks = new ArrayList<>();
        String sql = """
                SELECT t.id,
                       t.name,
                       t.start_date,
                       t.end_date,
                       u.first_name,
                       u.last_name,
                       p.name,
                       s.name
                FROM task t
                         JOIN users u ON u.id = t.id_user
                         JOIN project p ON p.id = t.id_project
                         JOIN status s ON s.id = t.id_status;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TaskEntity task = new TaskEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );
                ProjectEntity project = new ProjectEntity(
                        resultSet.getString("p.name")
                );
                UserEntity user = new UserEntity(
                        resultSet.getString("u.first_name"),
                        resultSet.getString("u.last_name")
                );
                StatusEntity status = new StatusEntity(
                        resultSet.getString("s.name")
                );

                task.setProject(project);
                task.setUser(user);
                task.setStatus(status);
                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }
}
