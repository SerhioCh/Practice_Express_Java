package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lesson_api_middle.models_lesson.CreateUserRequestLesson;
import practice_middle.models.BaseModel;
import practice_middle.models.CreateUserRequest;

import static io.restassured.RestAssured.given;

public class CreateAccountRequester extends BaseRequest implements SupportsPost {
    public CreateAccountRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }


    @Override
    public ValidatableResponse post(BaseModel model) {
        return
                given()
                        .spec(requestSpecification)
                        .post("/api/v1/accounts")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
