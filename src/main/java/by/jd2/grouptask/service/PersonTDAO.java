package by.jd2.grouptask.service;

import by.jd2.grouptask.annotation.MyTable;
import by.jd2.grouptask.bean.Person;
import by.jd2.grouptask.util.JDBCConnection;
import by.jd2.grouptask.util.ReflectBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonTDAO implements TDAO<Person> {
    @Override
    public void save(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "INSERT INTO " + table + " (id,name,surname) values (?,?,?)";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setInt(1, ReflectBean.getFieldValue("id", person));
            statement.setString(2, ReflectBean.getFieldValue("name", person));
            statement.setString(3, ReflectBean.getFieldValue("surname", person));
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person selectById(int id) {
        String sql = "SELECT * FROM person WHERE id = ?";
        Person person = new Person();
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    person.setId(resultSet.getInt(1));
                    person.setName(resultSet.getString(2));
                    person.setSurname(resultSet.getString(3));
                }
            }
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return person;
    }

    @Override
    public void update(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "UPDATE " + table + " SET name = ? , surname = ? WHERE id =? ";
        try (Connection connection = JDBCConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            connection.setAutoCommit(false);

            statement.setString(1, ReflectBean.getFieldValue("name", person));
            statement.setString(2, ReflectBean.getFieldValue("surname", person));
            statement.setInt(3, ReflectBean.getFieldValue("id", person));
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "DELETE FROM " + table + " WHERE id = ?";
        try (Connection connection = JDBCConnection.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,ReflectBean.getFieldValue("id", person));
            statement.executeUpdate();
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
