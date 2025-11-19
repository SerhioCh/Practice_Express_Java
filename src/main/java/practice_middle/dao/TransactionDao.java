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
public class TransactionDao implements ResultSetMapper<TransactionDao> {
    private Long id;
    private String type;
    private BigDecimal amount;
    private Long accountId;

    @Override
    public TransactionDao fromResultSet(ResultSet rs) throws SQLException {
        if (!rs.next()) return  null;
        return TransactionDao.builder()
                .id(rs.getLong("id"))
                .type(rs.getString("type"))
                .amount(rs.getBigDecimal("amount"))
                .accountId(rs.getLong("account_id"))
                .build();
    }
}
