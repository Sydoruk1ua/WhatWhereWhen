package com.sydoruk1ua.mdmg.model.dao.impl;

import com.sydoruk1ua.mdmg.model.dao.UserDao;
import com.sydoruk1ua.mdmg.model.entity.Role;
import com.sydoruk1ua.mdmg.model.entity.User;
import com.sydoruk1ua.mdmg.util.Connector;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    private static final String FIND_ALL_USERS = "SELECT u.id, u.email, u.password, u.first_name, u.last_name, " +
            "u.role_id, r.type AS role_type\n" +
            "FROM users AS u JOIN roles AS r ON u.role_id = r.id";
    private static final String FIND_USER_BY_EMAIL = "SELECT u.id, u.email, u.password, u.first_name, u.last_name, " +
            "u.role_id, r.type AS role_type\n" +
            "FROM users AS u JOIN roles AS r ON u.role_id = r.id " +
            "WHERE u.email = ?";
    private static final String INSERT_USER = "INSERT INTO users (email, password, first_name, last_name, role_id) " +
            "VALUES (?, ?, ?, ?, ?)";
    private static final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Optional<User> findByEmail(String email) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(FIND_USER_BY_EMAIL)) {
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.ofNullable(getUser(resultSet));
                } else {
                    LOGGER.warn("There is no user with this email: " + email);
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return Optional.empty();
    }

    @Override
    public void create(User user) {
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(INSERT_USER)) {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getPassword());
            preparedStatement.setString(3, user.getFirstName());
            preparedStatement.setString(4, user.getLastName());
            preparedStatement.setInt(5, user.getRole().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    @Override
    public Optional<User> findById(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        List<User> listOfAllUsers = new ArrayList<>();
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(FIND_ALL_USERS);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            if (resultSet.next()) {
                do {
                    listOfAllUsers.add(getUser(resultSet));
                } while (resultSet.next());
            } else {
                LOGGER.warn("Result Set is empty!");
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }

        return listOfAllUsers;
    }

    private User getUser(ResultSet resultSet) throws SQLException {
        Integer roleId = resultSet.getInt("role_id");
        String roleType = resultSet.getString("role_type");
        Role role = new Role(roleId, roleType);

        return User.builder()
                .withId(resultSet.getInt("id"))
                .withEmail(resultSet.getString("email"))
                .withPassword(resultSet.getString("password"))
                .withFirstName(resultSet.getString("first_name"))
                .withLastName(resultSet.getString("last_name"))
                .withRole(role)
                .build();
    }

    @Override
    public void update(User entity) {
        throw new UnsupportedOperationException(); //TODO
    }

    @Override
    public void deleteById(Integer id) {
        throw new UnsupportedOperationException();
    }
}
