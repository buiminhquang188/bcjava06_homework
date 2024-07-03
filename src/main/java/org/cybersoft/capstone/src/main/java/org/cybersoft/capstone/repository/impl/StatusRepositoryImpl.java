package org.cybersoft.capstone.repository.impl;

import org.cybersoft.capstone.config.MySQLConfig;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.repository.StatusRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusRepositoryImpl implements StatusRepository {

    @Override
    public List<StatusEntity> getStatuses() {
        List<StatusEntity> statuses = new ArrayList<>();
        String sql = """
                SELECT s.id, s.name from status s
                """;
        Connection connection = MySQLConfig.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                StatusEntity status = new StatusEntity(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                );

                statuses.add(status);
            }

            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statuses;
    }
}
