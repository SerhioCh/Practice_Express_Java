package practice_middle.dao;

import JavaDevComplexTask.Taks_2.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDao implements ResultSetMapper<UserDao> {
    private Long id;
    private String username;
    private String password;
    private String role;
    private String name;

    @Override
    public UserDao fromResultSet(ResultSet rs) throws SQLException {
        if (!rs.next()) return  null;
            return UserDao.builder()
                    .id(rs.getLong("id"))
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .role(rs.getString("role"))
                    .name(rs.getString("name"))
                    .build();
        }
    }
