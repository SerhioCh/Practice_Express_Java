package practice_api_senior.requests.skelethon.requesters;

import io.restassured.common.mapper.TypeRef;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.HttpRequest;
import practice_api_senior.requests.skelethon.interfaces.CrudEndpointInterface;
import practice_middle.models.BaseModel;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CrudRequester extends HttpRequest implements CrudEndpointInterface {
    public CrudRequester(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
    }

    @Override
    public ValidatableResponse post(BaseModel baseModel) {
        var body = baseModel ==null ?"":baseModel;
        return
                given()
                        .spec(requestSpecification)
                        .body(body)
                        .post(endpoint.getUrl())
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }

    @Override
    public ValidatableResponse get(long id) {
        var  request = given().spec(requestSpecification);
        if (endpoint.getUrl().contains("{accountId}")){
            request.pathParams("accountId",id);
        }
      return   request
                .pathParam("accountId", id)
                .get(endpoint.getUrl())
                .then()
                .assertThat()
                .spec(responseSpecification);
    }
    public ValidatableResponse get() {
        return given()
                .spec(requestSpecification)
                .get(endpoint.getUrl())
                .then()
                .assertThat()
                .spec(responseSpecification);
    }
    @Override
    public ValidatableResponse update(BaseModel baseModel) {
        return
                given()
                        .spec(requestSpecification)
                        .body(baseModel)
                        .put(endpoint.getUrl())
                        .then()
                        .assertThat()
                        .spec(responseSpecification);
    }

    @Override
    public Object delete(long id) {
        return null;
    }

    public <T> List<T> getList(long id, TypeRef<List<T>> typeRef) {
        var request = given().spec(requestSpecification);
        if (endpoint.getUrl().contains("{accountId}")) {
            request.pathParam("accountId", id);
        }
        return request
                .get(endpoint.getUrl())
                .then()
                .assertThat()
                .spec(responseSpecification)
                .extract()
                .as(typeRef);
    }
}
