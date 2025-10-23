package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import practice_middle.models.BaseModel;

public interface SupportsPut<T extends BaseModel> {
    public ValidatableResponse put(T model);
}
