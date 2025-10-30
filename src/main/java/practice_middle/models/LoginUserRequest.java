package practice_middle.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import practice_middle.requests.BaseRequest;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginUserRequest extends BaseModel {
    private  String username;
    private  String password;
}
