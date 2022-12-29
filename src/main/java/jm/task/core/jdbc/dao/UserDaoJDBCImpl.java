package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private static final Connection connection = Util.getConnection();

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS`mydbtest`.`Dimu` (\n" +
                " `id` INT NOT NULL AUTO_INCREMENT,\n" +
                " `name` VARCHAR(45) NOT NULL,\n" +
                " `lastname` VARCHAR(45) NOT NULL,\n" +
                " `age` INT NOT NULL,\n" +
                " PRIMARY KEY (`id`))\n" +
                "ENGINE = InnoDB;\n";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS mydbtest.dimu";
        try ( PreparedStatement ps = connection.prepareStatement(sql)){
           ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql =  "INSERT INTO mydbtest.dimu (name, lastName, age)VALUES ('" + name + "', '" + lastName + "'," + age + ")";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM mydbtest.dimu WHERE ID = id";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        String getAllUsers = "SELECT * FROM mydbtest.dimu";
        try (PreparedStatement preparedStatement = connection.prepareStatement(getAllUsers)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String lastName = resultSet.getString("lastName");
                Byte age = resultSet.getByte("age");
                User user = new User(name, lastName, age);
                user.setId(id);
                userList.add(user);
            }
        } catch (SQLException e) {
            System.out.println("Cannot get all users");
        }
        return userList;
    }

    public void cleanUsersTable() {
        String sql = "DELETE FROM mydbtest.dimu";
        try (PreparedStatement ps = connection.prepareStatement(sql)){
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
