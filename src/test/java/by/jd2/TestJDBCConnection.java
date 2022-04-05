package by.jd2;

import by.jd2.grouptask.util.JDBCConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class TestJDBCConnection{

    @Test
    public void when_mainDBConnection_then_returnConnection() throws SQLException {
        Connection connection = new JDBCConnection().getConnection();
        assertNotNull(connection);
        assertFalse(connection.isClosed());
        String expected = connection.getMetaData().getURL();
        String actual = "jdbc:h2:mem:test";
        assertEquals(expected, actual);
        connection.close();
        assertTrue(connection.isClosed());
    }
}
