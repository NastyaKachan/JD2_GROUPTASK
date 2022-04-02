package GroupTask.service;

import GroupTask.Annotation.MyTable;
import GroupTask.Bean.Person;
import GroupTask.util.JDBCConnection;
import GroupTask.util.ReflectBean;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PersonTDAO implements TDAO<Person> {
    @Override
    public void save(Person person) {
        String table = person.getClass().getAnnotation(MyTable.class).value();
        String sql = "INSERT INTO " + table + " (id,name,surname) values (?,?,?)";
        try {
            Connection connection = JDBCConnection.getConnection();
            connection.setAutoCommit(false);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, (Integer) ReflectBean.getFieldValue("id",person));
            statement.setString(2, (String) ReflectBean.getFieldValue("name",person));
            statement.setString(3, (String) ReflectBean.getFieldValue("surname",person));
            statement.executeUpdate();
            connection.commit();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Person get(Serializable id) {
        return null;
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public int delete(Serializable id) {
        return 0;
    }

}
