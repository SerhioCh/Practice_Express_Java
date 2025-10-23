package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import practice_middle.models.CreateTransferRequest;

import static io.restassured.RestAssured.given;

public class UserCreateTransferRequester extends BaseRequest implements SupportsPost<CreateTransferRequest> {

    public UserCreateTransferRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse post(CreateTransferRequest model) {
        return
                given()
                        .spec(requestSpecification)
                        .body(model)
                        .post("/api/v1/accounts/transfer")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
