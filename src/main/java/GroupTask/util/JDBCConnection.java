package GroupTask.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JDBCConnection {
    public static Connection getConnection() throws SQLException {
        ResourceBundle resource = ResourceBundle.getBundle("resources/database");
        String url = resource.getString("url");
        String user = resource.getString("user");
        String pass = resource.getString("password");
        return DriverManager.getConnection(url, user, pass);
    }
}
