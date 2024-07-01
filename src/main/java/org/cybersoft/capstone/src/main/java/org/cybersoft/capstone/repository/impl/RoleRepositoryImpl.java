package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.repository.RoleRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleRepositoryImpl implements RoleRepository {
    @Override
    public List<RoleEntity> getRoles() {
        List<RoleEntity> roles = new ArrayList<>();

        Connection connection = MySQLConfig.getConnection();
        String sql = """
                SELECT r.id, r.name, r.description FROM roles r
                """;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RoleEntity role = new RoleEntity();
                role.setId(resultSet.getInt("id"));
                role.setName(resultSet.getString("name"));
                role.setDescription(resultSet.getString("description"));

                roles.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return roles;
    }
}
