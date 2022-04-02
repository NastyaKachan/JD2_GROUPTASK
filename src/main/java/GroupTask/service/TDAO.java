package GroupTask.service;

import java.io.Serializable;
import java.sql.SQLException;

public interface TDAO<T> {

    void save(T t);

    T get(Serializable id) throws SQLException;

    void update(T t) throws SQLException;

    int delete(Serializable id) throws SQLException;


}
