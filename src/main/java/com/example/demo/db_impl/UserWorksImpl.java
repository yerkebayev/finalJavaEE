package com.example.demo.db_impl;

import com.example.demo.db.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserWorksImpl {
    Connection connection;
    public UserWorksImpl(Connection connection) {
        this.connection = connection;
    }
    public User getUser(String email) {
        User user = null;
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?")) {
            statement.setString(1, email);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    user = new User(resultSet.getLong("id"), resultSet.getString("email"),resultSet.getString("password"),resultSet.getString("full_name"), resultSet.getInt("role_id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void addUser(User user) {
        try (PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO users(email,password,full_name,role_id) VALUES (?,?,?,?)")) {
            insertStatement.setString(1, user.getEmail());
            insertStatement.setString(2, user.getPassword());
            insertStatement.setString(3, user.getFullname());
            insertStatement.setInt(4, user.getRole_id());
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void updateUser(User user) {
        try (PreparedStatement statement = connection.prepareStatement("UPDATE users SET email = ?, password = ?, full_name = ?, role_id = ? WHERE id = ?")){
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullname());
            statement.setInt(4, user.getRole_id());
            statement.setLong(5, user.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
