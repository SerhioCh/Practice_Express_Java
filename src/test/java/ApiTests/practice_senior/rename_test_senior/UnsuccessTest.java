package ApiTests.practice_senior.rename_test_senior;

import ApiTests.practice_middle.BaseTest;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import practice_middle.models.UpdateCustomerProfileRequest;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class UnsuccessTest extends BaseTest {
    @ValueSource(strings = {"Jhon", "jhon 1smith", "jOn! sMi", "1 1", "$ ^"})
    @ParameterizedTest
    public void unsuccessRenameUser(String name) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();

        UpdateCustomerProfileRequest updateCustomerProfileRequest = UpdateCustomerProfileRequest.builder()
                .name(name)
                .build();

        ValidatableResponse validatableResponse = new CrudRequester(RequestSpecs.userAuthSpec(username, password),
                Endpoint.UPDATE_CUSTOMER,
                ResponseSpecs.requestReturnsBAD())
                .update(updateCustomerProfileRequest);
        Response response = validatableResponse.extract().response();
        String bodyResponse = response.getBody().asString();


        Customer customer = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();


        softly.assertThat(bodyResponse).as("Проверка текста ошибки").isEqualTo("Name must contain two words with letters only");
        softly.assertThat(customer.getName()).as("Проверка, что Имя профиля не изменено").isNull();
        softly.assertAll();


    }
}
