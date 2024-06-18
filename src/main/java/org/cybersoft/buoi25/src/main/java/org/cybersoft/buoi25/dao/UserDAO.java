package org.cybersoft.buoi25.dao;

import org.cybersoft.buoi25.config.MySQLConfig;
import org.cybersoft.buoi25.entity.UserEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    private Connection connection;

    public UserDAO() {
        this.connection = MySQLConfig.getConnection();
    }

    public List<UserEntity> getUserByUsernameAndPassword(String username, String password) {
        List<UserEntity> users = new ArrayList<>();
        try {
            if (this.connection.isClosed()) this.connection = MySQLConfig.getConnection();

            String query = """
                    SELECT *
                    FROM users u
                    WHERE u.username = ? AND u.password = ?
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                UserEntity user = new UserEntity();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));

                users.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }
}
