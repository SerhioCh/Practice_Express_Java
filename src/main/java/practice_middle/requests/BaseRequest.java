package practice_middle.requests;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseRequest {
    protected RequestSpecification requestSpecification;
    protected ResponseSpecification responseSpecification;

    BaseRequest(RequestSpecification requestSpecification, ResponseSpecification responseSpecification) {
        this.requestSpecification = requestSpecification;
        this.responseSpecification = responseSpecification;
    }

}
