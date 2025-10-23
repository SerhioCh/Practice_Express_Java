package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public class GetUserProfileRequster extends BaseRequest implements SupportGet {
    public GetUserProfileRequster(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse get() {
        return
                given()
                        .spec(requestSpecification)
                        .get("/api/v1/customer/profile")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
