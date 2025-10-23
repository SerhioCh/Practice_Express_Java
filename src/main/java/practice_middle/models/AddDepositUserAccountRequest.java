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
public class AddDepositUserAccountRequest  extends  BaseModel {
    private  long id;
    private BigDecimal balance;
}
