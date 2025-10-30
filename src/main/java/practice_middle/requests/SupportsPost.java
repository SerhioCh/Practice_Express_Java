package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import practice_middle.models.BaseModel;

public interface SupportsPost<T extends BaseModel> {
    public ValidatableResponse post(T model);
}
