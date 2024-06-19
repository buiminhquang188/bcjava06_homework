package org.cybersoft.buoi25.repository;

import org.cybersoft.buoi25.config.MySQLConfig;
import org.cybersoft.buoi25.dto.RoleDTO;
import org.cybersoft.buoi25.entity.RoleEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public Connection connection;

    public RoleRepository() {
        this.connection = MySQLConfig.getConnection();
    }

    public List<RoleEntity> getRoles() {
        List<RoleEntity> roles = new ArrayList<>();

        try {
            if (this.connection.isClosed()) this.connection = MySQLConfig.getConnection();
            String query = """
                    SELECT *
                    FROM roles;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                RoleEntity role = new RoleEntity();
                role.setId(resultSet.getLong("id"));
                role.setName(resultSet.getString("name"));
                role.setDescription(resultSet.getString("description"));

                roles.add(role);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roles;
    }

    public Integer saveRole(RoleDTO roleDTO) {
        Integer resultIndex = null;
        try {
            if (this.connection.isClosed()) this.connection = MySQLConfig.getConnection();
            String query = """
                    INSERT INTO roles(name, description) VALUE (?, ?)
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, roleDTO.getName());
            preparedStatement.setString(2, roleDTO.getDescription());

            resultIndex = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return resultIndex;
    }
}
