package practice_middle.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ResultSetMapper <T>{
    T fromResultSet(ResultSet rs) throws SQLException;
}
