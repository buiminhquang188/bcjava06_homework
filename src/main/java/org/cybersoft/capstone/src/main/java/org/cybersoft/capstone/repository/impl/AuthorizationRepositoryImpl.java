package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.entity.RoleDetailEntity;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.repository.AuthorizationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorizationRepositoryImpl implements AuthorizationRepository {
    @Override
    public List<RoleDetailEntity> getAuthorizationByUserId(AuthorizationDTO authorizationDTO) {
        List<RoleDetailEntity> rolesDetailEntity = new ArrayList<>();

        String sql = """
                SELECT u.id,
                       r.name,
                       rd.action,
                       rd.url,
                       rd.method,
                       rd.action_name,
                       rd.action_code
                FROM users AS u
                         JOIN users_roles AS ur ON u.id = ur.id_user
                         JOIN roles AS r ON ur.id_permission = r.id
                         JOIN roles_detail AS rd ON r.id = rd.id_permission
                WHERE u.id = ?
                  AND rd.method = ?
                  AND rd.url = ?
                  AND ur.licensed = ?
                  AND rd.check_action = ?;
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, authorizationDTO.getId());
            preparedStatement.setString(2, authorizationDTO.getMethod());
            preparedStatement.setString(3, authorizationDTO.getUrl());
            preparedStatement.setInt(4, authorizationDTO.getLicensed());
            preparedStatement.setInt(5, authorizationDTO.getCheckAction());

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                RoleEntity role = new RoleEntity(
                        resultSet.getString("r.name")
                );

                RoleDetailEntity roleDetailEntity = new RoleDetailEntity(
                        resultSet.getInt("u.id"),
                        resultSet.getString("rd.action"),
                        resultSet.getString("rd.action_name"),
                        resultSet.getString("rd.action_code"),
                        resultSet.getString("rd.url"),
                        resultSet.getString("rd.method"),
                        role
                );

                rolesDetailEntity.add(roleDetailEntity);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rolesDetailEntity;
    }
}
