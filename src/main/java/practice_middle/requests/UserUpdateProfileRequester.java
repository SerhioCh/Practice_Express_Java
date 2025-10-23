package practice_middle.requests;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import practice_middle.models.UpdateCustomerProfileRequest;

import static io.restassured.RestAssured.given;

public class UserUpdateProfileRequester extends BaseRequest implements SupportsPut<UpdateCustomerProfileRequest> {
    public UserUpdateProfileRequester(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        super(requestSpecification, responseSpecification);
    }

    @Override
    public ValidatableResponse put(UpdateCustomerProfileRequest model) {
        return
                given()
                        .spec(requestSpecification)
                        .body(model)
                        .put("/api/v1/customer/profile")
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }
}
