/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package poly.cafe.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import poly.cafe.dao.UserDAO;
import poly.cafe.entity.User;
import static poly.cafe.util.XJdbc.openConnection;

public class UserDAOImpl implements UserDAO {

    String createSql = "INSERT INTO Users (Username, Password, Enabled, Fullname, Photo, Manager) VALUES (?, ?, ?, ?, ?, ?)";
    String updateSql = "UPDATE Users SET Password = ?, Enabled = ?, Fullname = ?, Photo = ?, Manager = ? WHERE Username = ?";
    String deleteSql = "DELETE FROM Users WHERE Username = ?";
    String findAllSql = "SELECT * FROM Users";
    String findByIdSql = "SELECT * FROM Users WHERE Username = ?";

    private Connection getConnection() throws SQLException {

        return openConnection();
    }

    @Override
    public User create(User entity) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(createSql)) {

            stmt.setString(1, entity.getUsername());
            stmt.setString(2, entity.getPassword());
            stmt.setBoolean(3, entity.isEnabled());
            stmt.setString(4, entity.getFullname());
            stmt.setString(5, entity.getPhoto());
            stmt.setBoolean(6, entity.isManager());

            stmt.executeUpdate();
            return entity;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(User entity) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(updateSql)) {

            stmt.setString(1, entity.getPassword());
            stmt.setBoolean(2, entity.isEnabled());
            stmt.setString(3, entity.getFullname());
            stmt.setString(4, entity.getPhoto());
            stmt.setBoolean(5, entity.isManager());
            stmt.setString(6, entity.getUsername());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(deleteSql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(findAllSql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                User user = new User(
                        rs.getString("Username"),
                        rs.getString("Password"),
                        rs.getBoolean("Enabled"),
                        rs.getString("Fullname"),
                        rs.getString("Photo"),
                        rs.getBoolean("Manager")
                );
                users.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public User findById(String id) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(findByIdSql)) {

            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new User(
                            rs.getString("Username"),
                            rs.getString("Password"),
                            rs.getBoolean("Enabled"),
                            rs.getString("Fullname"),
                            rs.getString("Photo"),
                            rs.getBoolean("Manager")
                    );
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}