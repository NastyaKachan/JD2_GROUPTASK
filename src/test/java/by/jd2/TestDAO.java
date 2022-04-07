package by.jd2;

import by.jd2.grouptask.bean.Person;
import by.jd2.grouptask.service.PersonDAO;
import by.jd2.grouptask.util.JDBCConnection;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


public class TestDAO {
    JDBCConnection jdbcConnection = new JDBCConnection();
    PersonDAO personDAO = new PersonDAO(jdbcConnection);

    @Before
    public void createTable() {
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement("TRUNCATE TABLE PERSON")) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSavePerson() {
        Person expected = new Person(1, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual = personDAO.selectById(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testUpdatePerson() {
        Person expected = new Person(2, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual1 = personDAO.selectById(2);
        assertEquals(expected, actual1);
        Person personForUpdate = new Person(2, "Ирина", "Малышева");
        personDAO.update(personForUpdate);
        Person actual2 = personDAO.selectById(2);
        assertEquals(personForUpdate, actual2);
    }

    @Test
    public void testDeletePerson() {
        Person expected = new Person(3, "Елена", "Малышева");
        personDAO.save(expected);
        Person actual = personDAO.selectById(3);
        assertEquals(expected, actual);
        personDAO.delete(expected);
        Person actualNull = personDAO.selectById(3);
        assertNull(actualNull);
    }
}

