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

public class ValidatedCrudRequester  <T extends BaseModel> extends HttpRequest implements CrudEndpointInterface {
    private CrudRequester crudRequester;
    public ValidatedCrudRequester(RequestSpecification requestSpecification, Endpoint endpoint, ResponseSpecification responseSpecification) {
        super(requestSpecification, endpoint, responseSpecification);
        this.crudRequester = new CrudRequester(requestSpecification,endpoint,responseSpecification);
    }

    @Override
    public T post(BaseModel baseModel) {
        return (T)crudRequester.post(baseModel).extract().as(endpoint.getResponseModel());
    }

    @Override
    public T get(long id) {
        return (T)crudRequester.get(id).extract().as(endpoint.getResponseModel());
    }

    @Override
    public T get() {
        return (T)crudRequester.get().extract().as(endpoint.getResponseModel());
    }

    @Override
    public T update(BaseModel baseModel) {
        return (T)crudRequester.update(baseModel).extract().as(endpoint.getResponseModel());
    }

    @Override
    public Object delete(long id) {
        return null;
    }


    public List<T> getList(long id, TypeRef<List<T>> typeRef) {
        return crudRequester.getList(id, typeRef);
    }
}
