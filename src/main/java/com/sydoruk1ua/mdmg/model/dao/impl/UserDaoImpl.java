package com.sydoruk1ua.mdmg.model.dao.impl;

import com.sydoruk1ua.mdmg.model.dao.UserDao;
import com.sydoruk1ua.mdmg.model.entity.Role;
import com.sydoruk1ua.mdmg.model.entity.User;
import com.sydoruk1ua.mdmg.util.Connector;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    public static final String FIND_ALL_USERS = "SELECT u.id, u.email, u.password, u.first_name, u.last_name, " +
            "u.role_id, r.type AS role_type\n" +
            "FROM users AS u JOIN roles AS r ON u.role_id = r.id";
    private final static Logger LOGGER = Logger.getLogger(UserDaoImpl.class);

    @Override
    public Optional<User> findByEmail(String email) {
        // return Optional.empty();
        throw new UnsupportedOperationException();
    }

    @Override
    public void create(User entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Optional<User> findById(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<User> findAll() {
        List<User> listOfAllUsers = new ArrayList<>();
        try (PreparedStatement preparedStatement = Connector.getConnection().prepareStatement(FIND_ALL_USERS)) {

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                do {
                    Integer roleId = resultSet.getInt("role_id");
                    String roleType = resultSet.getString("role_type");
                    Role role = new Role(roleId, roleType);

                    User user = User.builder()
                            .withId(resultSet.getInt("id"))
                            .withEmail(resultSet.getString("email"))
                            .withPassword(resultSet.getString("password"))
                            .withFirstName(resultSet.getString("first_name"))
                            .withLastName(resultSet.getString("last_name"))
                            .withRole(role)
                            .build();
                    listOfAllUsers.add(user);
                } while (resultSet.next());
            } else {
                LOGGER.warn("Result Set is empty!");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.ERROR, e);
        }

        return listOfAllUsers;
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
