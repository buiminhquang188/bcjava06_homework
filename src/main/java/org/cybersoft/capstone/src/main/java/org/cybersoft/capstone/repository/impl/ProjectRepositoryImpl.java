package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.repository.ProjectRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    @Override
    public List<ProjectEntity> getProjects() {
        List<ProjectEntity> projects = new ArrayList<>();
        String sql = """
                SELECT p.id, p.name, p.start_date, p.end_date
                FROM project p
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("execute query getProjects");

            while (resultSet.next()) {
                ProjectEntity projectEntity = new ProjectEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );

                projects.add(projectEntity);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public ProjectEntity getProject(Integer id) {
        ProjectEntity projectEntity = null;
        String sql = """
                SELECT p.id, p.name, p.start_date, p.end_date
                FROM project p
                WHERE p.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("execute query getProject");

            while (resultSet.next()) {
                projectEntity = new ProjectEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projectEntity;
    }

    @Override
    public Integer createProject(ProjectDTO projectDTO) {
        Integer resultIndex = null;
        String sql = """
                INSERT INTO project(name, start_date, end_date)
                VALUE (?, ?, ?)
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, projectDTO.getName());
            preparedStatement.setObject(2, projectDTO.getStartDate());
            preparedStatement.setObject(3, projectDTO.getEndDate());

            resultIndex = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer updateProject(Integer id, ProjectDTO projectDTO) {
        Integer resultIndex = null;
        String sql = """
                UPDATE project p
                SET p.name       = ?,
                    p.start_date = ?,
                    p.end_date   = ?
                WHERE p.id = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, projectDTO.getName());
            preparedStatement.setTimestamp(2, projectDTO.getStartDate());
            preparedStatement.setTimestamp(3, projectDTO.getEndDate());
            preparedStatement.setInt(4, id);

            resultIndex = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer deleteProject(Integer id) {
        Integer resultIndex = null;
        String sql = """
                DELETE
                FROM project p
                WHERE p.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultIndex = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return resultIndex;
    }

    @Override
    public List<ProjectEntity> getProjectOptions() {
        List<ProjectEntity> projects = new ArrayList<>();
        String sql = """
                SELECT p.id, p.name from project p;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProjectEntity project = new ProjectEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );

                projects.add(project);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }
}
