package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.*;
import org.cybersoft.capstone.repository.ProjectRepository;
import org.cybersoft.capstone.repository.TaskRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectRepositoryImpl implements ProjectRepository {
    private final TaskRepository taskRepository = new TaskRepositoryImpl();

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
            System.out.println("execute query GET ALL Projects");

            while (resultSet.next()) {
                ProjectEntity projectEntity = new ProjectEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getTimestamp("start_date"),
                        resultSet.getTimestamp("end_date")
                );

                projects.add(projectEntity);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public List<ProjectEntity> getProjects(Integer id) {
        List<ProjectEntity> projects = new ArrayList<>();
        String sql = """
                SELECT p.id, p.name, p.start_date, p.end_date
                FROM project p
                         LEFT JOIN users_project up ON up.id_project = p.id
                WHERE up.id_user = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

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
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public ProjectEntity getProject(Integer id) {
        ProjectEntity projectEntity = null;
        String sql = """
                SELECT p.id, p.name, p.start_date, p.end_date, u.id, u.first_name, u.last_name
                FROM project p
                         LEFT JOIN users_project up ON up.id_project = p.id
                         LEFT JOIN users u ON u.id = up.id_user
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
                        resultSet.getInt("p.id"),
                        resultSet.getString("p.name"),
                        resultSet.getTimestamp("p.start_date"),
                        resultSet.getTimestamp("p.end_date")
                );

                UserEntity user = new UserEntity();
                int userId = resultSet.getInt("u.id");
                user.setId(
                        userId > 0 ? userId : null
                );
                user.setFirstName(resultSet.getString("u.first_name"));
                user.setLastName(resultSet.getString("u.last_name"));

                projectEntity.setUser(user);
            }
            connection.close();
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
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, projectDTO.getName());
            preparedStatement.setTimestamp(2, projectDTO.getStartDate());
            preparedStatement.setTimestamp(3, projectDTO.getEndDate());

            preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                resultIndex = resultSet.getInt(1);
            }

            System.out.println("Insert Create Project");
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
            System.out.println("Update Project");
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }

    @Override
    public Integer deleteProject(Integer id) {
        this.taskRepository.updateTaskByProjectId(id);
        this.deleteUserProjectByProjectId(id);

        Connection connection = MySQLConfig.getConnection();

        Integer resultIndex = null;
        String sql = """
                DELETE
                FROM project p
                WHERE p.id = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            Statement statement = connection.createStatement();
            statement.execute("SET FOREIGN_KEY_CHECKS = 0");
            resultIndex = preparedStatement.executeUpdate();
            statement.execute("SET FOREIGN_KEY_CHECKS = 1");
            statement.close();
            connection.close();
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
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public List<ProjectEntity> getProjectOptions(Integer id) {
        List<ProjectEntity> projects = new ArrayList<>();
        String sql = """
                SELECT p.id, p.name
                FROM project p
                         LEFT JOIN users_project up ON up.id_project = p.id
                WHERE up.id_user = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                ProjectEntity project = new ProjectEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );

                projects.add(project);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public List<ProjectEntity> getProjectDetail(Integer id) {
        List<ProjectEntity> projects = new ArrayList<>();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT t.name, t.start_date, t.end_date, u.id, u.first_name, u.last_name, s.id, s.name
                FROM project p
                         JOIN task t ON t.id_project = p.id
                         JOIN users u ON u.id = t.id_user
                         JOIN status s ON s.id = t.id_status
                WHERE p.id = ?
                ORDER BY u.id;
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("execute query getProjectDetail");

            while (resultSet.next()) {
                ProjectEntity project = new ProjectEntity();

                TaskEntity task = new TaskEntity(
                        resultSet.getString("t.name"),
                        resultSet.getTimestamp("t.start_date"),
                        resultSet.getTimestamp("t.end_date")
                );

                StatusEntity status = new StatusEntity(
                        resultSet.getInt("s.id"),
                        resultSet.getString("s.name")
                );
                task.setStatus(status);

                UserEntity user = new UserEntity(
                        resultSet.getInt("u.id"),
                        resultSet.getString("u.first_name"),
                        resultSet.getString("u.last_name")
                );

                project.setTask(task);
                project.setUser(user);
                projects.add(project);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projects;
    }

    @Override
    public List<StatusEntity> getProjectStat(Integer id) {
        List<StatusEntity> statuses = new ArrayList<>();
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT s.id, s.name, COUNT(s.id) AS total
                FROM project p
                         JOIN task t ON t.id_project = p.id
                         JOIN status s ON s.id = t.id_status
                WHERE p.id = ?
                GROUP BY s.id;
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
    public List<Integer> getProjectIdsByUserId(Integer userId) {
        List<Integer> projectIds = new ArrayList<>();

        String sql = """
                SELECT up.id_project
                FROM users u
                         LEFT JOIN users_project up ON up.id_user = u.id
                WHERE u.id = ?
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                projectIds.add(resultSet.getInt("up.id_project"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projectIds;
    }

    @Override
    public UsersProjectEntity getUsersProjectByUserIdAndProjectId(Integer userId, Integer projectId) {
        UsersProjectEntity usersProjectEntity = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT up.id, up.id_user, up.id_project
                FROM users_project up
                WHERE up.id_user = ? AND up.id_project = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usersProjectEntity = new UsersProjectEntity();
                usersProjectEntity.setId(resultSet.getInt("up.id"));
                usersProjectEntity.setIdUser(resultSet.getInt("up.id_user"));
                usersProjectEntity.setIdProject(resultSet.getInt("up.id_project"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usersProjectEntity;
    }

    @Override
    public UsersProjectEntity getUsersProjectByUserIdAndProjectIdIsNull(Integer userId) {
        UsersProjectEntity usersProjectEntity = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT up.id ,up.id_user
                FROM users_project up
                WHERE up.id_user = ? AND up.id_project IS NULL
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usersProjectEntity = new UsersProjectEntity();
                usersProjectEntity.setId(resultSet.getInt("up.id"));
                usersProjectEntity.setIdUser(resultSet.getInt("up.id_user"));
                usersProjectEntity.setIdProject(null);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usersProjectEntity;
    }

    @Override
    public UsersProjectEntity getUsersProjectByProjectIdAndUserIdIsNull(Integer projectId) {
        UsersProjectEntity usersProjectEntity = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT up.id, up.id_project
                FROM users_project up
                WHERE up.id_project = ?
                  AND up.id_user IS NULL
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                usersProjectEntity = new UsersProjectEntity();
                usersProjectEntity.setId(resultSet.getInt("up.id"));
                usersProjectEntity.setIdUser(null);
                usersProjectEntity.setIdProject(resultSet.getInt("up.id_project"));
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usersProjectEntity;
    }

    @Override
    public Integer createUserProject(Integer userId, Integer projectId) {
        Integer result = null;
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                INSERT INTO users_project(id_user, id_project)
                VALUE (?, ?)
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, projectId);

            result = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    @Override
    public void updateUserProject(Integer userId, Integer projectId) {
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE users_project up
                SET up.id_project = ?
                WHERE up.id_user = ?;
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            preparedStatement.setInt(2, userId);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUserProjectByProjectId(Integer id) {
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                DELETE
                FROM users_project up
                WHERE up.id_project = ?;
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserProjectById(Integer userProjectId, Integer inputUserId, Integer inputProjectId) {
        Connection connection = MySQLConfig.getConnection();
        String sql = """
                UPDATE users_project up
                SET up.id_user = ?,
                    up.id_project = ?
                WHERE up.id = ?
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, inputUserId);
            preparedStatement.setInt(2, inputProjectId);
            preparedStatement.setInt(3, userProjectId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateUserProjectByUserId(Integer id) {
        String sql = """
                UPDATE users_project up
                SET up.id_user = null
                WHERE up.id_user = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getProjectIdByOwnerIdAndUserId(Integer ownerId, Integer userId) {
        Connection connection = MySQLConfig.getConnection();
        Integer projectId = null;
        String sql = """
                SELECT p.id
                FROM task t
                         LEFT JOIN task p ON t.id_project = p.id
                         LEFT JOIN users_project up ON up.id_project = p.id
                         LEFT JOIN users u ON u.id = t.id_user
                WHERE u.id = ?
                  AND up.id_user = ?;
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, ownerId);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                projectId = resultSet.getInt("p.id");
                break;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projectId;
    }
}
