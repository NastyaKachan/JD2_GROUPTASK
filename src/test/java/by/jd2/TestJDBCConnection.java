package by.jd2;

import by.jd2.grouptask.util.JDBCConnection;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.assertNotNull;

public class TestJDBCConnection {
    @Test
    public void connection() throws SQLException {
        Connection result = JDBCConnection.getConnection();
        assertNotNull(result);
    }
}
