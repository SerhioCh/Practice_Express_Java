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
public class CreateTransferResponse extends  BaseModel {
    private long senderAccountId;
    private long receiverAccountId;
    private BigDecimal amount;
    private String message;
}
