package GroupTask.service;

import java.sql.SQLException;

public interface TDAO<T> {

    void save(T t);

    void select() throws SQLException;

    void update(T t) throws SQLException;

    void delete(T t) throws SQLException;

}
