package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.dto.TaskProgressDTO;
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
                       u.id,
                       u.first_name,
                       u.last_name,
                       p.name,
                       s.name
                FROM task t
                         LEFT JOIN users u ON u.id = t.id_user
                         LEFT JOIN project p ON p.id = t.id_project
                         LEFT JOIN status s ON s.id = t.id_status
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

                int userId = resultSet.getInt("u.id");
                UserEntity user = new UserEntity(
                        userId > 0 ? userId : null,
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

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    @Override
    public List<TaskEntity> getTasks(Integer id) {
        List<TaskEntity> tasks = new ArrayList<>();
        String sql = """
                SELECT t.id,
                       t.name,
                       t.start_date,
                       t.end_date,
                       u.first_name,
                       u.last_name,
                       p.name,
                       s.name,
                       t.id_user,
                       u.id,
                       up.id_user,
                       up.id_project
                FROM task t
                         LEFT JOIN users_project up ON t.id_project = up.id_project
                         LEFT JOIN project p ON p.id = t.id_project
                         LEFT JOIN users u ON u.id = t.id_user
                         LEFT JOIN status s ON s.id = t.id_status
                WHERE t.id_user = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TaskEntity task = new TaskEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );
                ProjectEntity project = new ProjectEntity(
                        resultSet.getInt("up.id_project"),
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

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    @Override
    public TaskEntity getTask(Integer id) {
        TaskEntity task = null;
        String sql = """
                SELECT t.id,
                       t.name,
                       t.start_date,
                       t.end_date,
                       u.id,
                       p.id,
                       s.id
                FROM task t
                         LEFT JOIN users u ON u.id = t.id_user
                         LEFT JOIN project p ON p.id = t.id_project
                         LEFT JOIN status s ON s.id = t.id_status
                WHERE t.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                task = new TaskEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );

                int projectId = resultSet.getInt("p.id");
                ProjectEntity project = new ProjectEntity(
                        projectId > 0 ? projectId : null
                );

                int userId = resultSet.getInt("u.id");
                UserEntity user = new UserEntity(
                        userId > 0 ? userId : null
                );

                int statusId = resultSet.getInt("s.id");
                StatusEntity status = new StatusEntity(
                        statusId > 0 ? statusId : null
                );

                task.setProject(project);
                task.setUser(user);
                task.setStatus(status);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return task;
    }

    @Override
    public Integer createTask(TaskDTO taskDTO) {
        Integer resultIndex = null;
        String sql = """
                INSERT INTO task(name, start_date, end_date, id_user, id_project, id_status)
                    VALUE (?, ?, ?, ?, ?, ?)
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, taskDTO.getName());
            preparedStatement.setTimestamp(2, taskDTO.getStartDate());
            preparedStatement.setTimestamp(3, taskDTO.getEndDate());
            preparedStatement.setInt(4, taskDTO.getUserId());
            preparedStatement.setInt(5, taskDTO.getProjectId());
            preparedStatement.setInt(6, taskDTO.getStatusId());

            resultIndex = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer deleteTask(Integer id) {
        Integer resultIndex = null;
        String sql = """
                DELETE
                FROM task t
                WHERE t.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

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
    public Integer updateTask(Integer id, TaskDTO taskDTO) {
        Integer resultIndex = null;
        String sql = """
                UPDATE task t
                SET t.name = ?,
                    t.start_date = ?,
                    t.end_date = ?,
                    t.id_project = ?,
                    t.id_user = ?,
                    t.id_status = ?
                WHERE t.id = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, taskDTO.getName());
            preparedStatement.setTimestamp(2, taskDTO.getStartDate());
            preparedStatement.setTimestamp(3, taskDTO.getEndDate());
            preparedStatement.setObject(4, taskDTO.getProjectId());
            preparedStatement.setObject(5, taskDTO.getUserId());
            preparedStatement.setObject(6, taskDTO.getStatusId());
            preparedStatement.setInt(7, id);

            resultIndex = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer updateTaskByProjectId(Integer id) {
        Integer result = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE task t
                SET t.id_project = NULL
                WHERE t.id_project = ?
                """;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            result = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public Integer updateProgressTask(Integer id, TaskProgressDTO taskProgressDTO) {
        Integer result = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE task t
                SET t.id_status = ?
                WHERE t.id = ?;
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, taskProgressDTO.getStatusId());
            preparedStatement.setInt(2, id);
            result = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public List<StatusEntity> getTaskStatisticByUserId(Integer userId) {
        List<StatusEntity> statuses = new ArrayList<>();
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT s.id, s.name, COUNT(s.id) AS total
                FROM task t
                         JOIN status s ON s.id = t.id_status
                WHERE t.id_user = ?
                GROUP BY s.id
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
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
    public List<TaskEntity> getTaskByUserId(Integer userId) {
        List<TaskEntity> tasks = new ArrayList<>();
        String sql = """
                SELECT t.name, t.start_date, t.end_date, s.id, s.name
                FROM task t
                         JOIN status s ON s.id = t.id_status
                WHERE t.id_user = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StatusEntity status = new StatusEntity(
                        resultSet.getInt("s.id"),
                        resultSet.getString("s.name")
                );

                TaskEntity task = new TaskEntity(
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("t.start_date"),
                        resultSet.getTimestamp("t.end_date"),
                        status
                );

                tasks.add(task);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    @Override
    public List<TaskEntity> getTaskByOwnerId(Integer projectId) {
        List<TaskEntity> tasks = new ArrayList<>();
        String sql = """
                SELECT t.id,
                       t.name,
                       t.start_date,
                       t.end_date,
                       u.first_name,
                       u.last_name,
                       p.name,
                       s.name,
                       t.id_user,
                       u.id,
                       up.id_user,
                       up.id_project
                FROM task t
                         LEFT JOIN project p ON p.id = t.id_project
                         LEFT JOIN users_project up ON up.id_project = t.id_project
                         LEFT JOIN users u ON u.id = t.id_user
                         LEFT JOIN status s ON s.id = t.id_status
                where up.id_user = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                TaskEntity task = new TaskEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );
                ProjectEntity project = new ProjectEntity(
                        resultSet.getInt("up.id_project"),
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

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return tasks;
    }

    @Override
    public Integer updateTaskByUserId(Integer userId) {
        Integer resultIndex = null;
        String sql = """
                UPDATE task t
                SET t.id_user = null
                WHERE t.id_user = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            resultIndex = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }
}
