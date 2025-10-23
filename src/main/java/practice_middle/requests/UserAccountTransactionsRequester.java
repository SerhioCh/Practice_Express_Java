package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class UserAccountTransactionsRequester extends BaseRequest implements SupportGet {
    public UserAccountTransactionsRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse get() {
        throw new UnsupportedOperationException("Use get(long accountId) instead.");
    }

    public ValidatableResponse get(long accountId) {
        return
                given()
                        .spec(requestSpecification)
                        .pathParam("accountId", accountId)
                        .get("/api/v1/accounts/{accountId}/transactions")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
