package by.jd2;

import by.jd2.grouptask.service.PersonDAO;
import by.jd2.grouptask.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TestBase {
    private static final String CREATE_TABLE_PERSON = "DROP TABLE IF EXISTS person;" +
            "create table person\n" +
            "(\n" +
            "    id       int not null,\n" +
            "    name     varchar(100),\n" +
            "    surname varchar(100),\n" +
            "    constraint PUBLIC.PERSON_PK\n" +
            "        primary key (id)\n" +
            ");";
    JDBCConnection jdbcConnection = new JDBCConnection();
    PersonDAO personDAO = new PersonDAO(jdbcConnection);

    public void createTestTable() {
        try (Connection connection = jdbcConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_TABLE_PERSON)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

