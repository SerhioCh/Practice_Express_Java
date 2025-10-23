package practice_middle.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private long id;
    private BigDecimal amount;
    private String  type;
    private String timestamp;
    private int relatedAccountId;
}
