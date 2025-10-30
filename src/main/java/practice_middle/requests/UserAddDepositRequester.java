package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import practice_middle.models.AddDepositUserAccountRequest;

import static io.restassured.RestAssured.given;

public class UserAddDepositRequester extends BaseRequest implements SupportsPost<AddDepositUserAccountRequest> {
    public UserAddDepositRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse post(AddDepositUserAccountRequest model) {
        return
                given()
                        .spec(requestSpecification)
                        .body(model)
                        .post("/api/v1/accounts/deposit")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
