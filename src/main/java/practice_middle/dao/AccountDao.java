package practice_middle.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountDao implements ResultSetMapper <AccountDao> {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private Long customerId;

    @Override
    public AccountDao fromResultSet(ResultSet rs) throws SQLException {
        if (!rs.next()) return  null;
            return AccountDao.builder()
                    .id(rs.getLong("id"))
                    .accountNumber(rs.getString("account_number"))
                    .balance(rs.getBigDecimal("balance"))
                    .customerId(rs.getLong("customer_id"))
                    .build();
        }
    }
