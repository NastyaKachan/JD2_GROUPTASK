package GroupTask.service;

import GroupTask.Annotation.MyTable;
import GroupTask.Bean.Person;
import GroupTask.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static GroupTask.util.ReflectBean.getFieldValue;

public class PersonTDAO implements TDAO<Person> {
    @Override
    public void save(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "INSERT INTO " + table + " (id,name,surname) values (?,?,?)";
        try {
            Connection connection = JDBCConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) getFieldValue("id", person));
            statement.setString(2, (String) getFieldValue("name", person));
            statement.setString(3, (String) getFieldValue("surname", person));
            statement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void select() {
        String sql = "SELECT * FROM person ORDER BY id";
        try (Connection connection = JDBCConnection.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println(resultSet.getInt(1) + " "
                            + resultSet.getString(2) + " " +
                            resultSet.getString(3));
                }
            }
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "UPDATE " + table + " SET name = ? , surname = ? WHERE id =? ";
        try (Connection connection = JDBCConnection.getConnection()) {
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String) getFieldValue("name", person));
            statement.setString(2, (String) getFieldValue("surname", person));
            statement.setInt(3, (Integer) getFieldValue("id", person));
            statement.executeUpdate();
            connection.commit();
            statement.close();
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
            statement.setInt(1, (Integer) getFieldValue("id", person));
            /*
            statement.setString(1, (String) ReflectBean.getFieldValue("name", person));
            statement.setString(1, (String) ReflectBean.getFieldValue("surname", person));
            */
            statement.executeUpdate();
            connection.commit();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
