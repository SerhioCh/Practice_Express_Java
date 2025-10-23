package ApiTests.practice_middle.rename_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.TestUserManager;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.Customer;
import practice_middle.models.UpdateCustomerProfileRequest;
import practice_middle.requests.GetUserProfileRequster;
import practice_middle.requests.UserUpdateProfileRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class UnsuccessRename extends BaseTest {
    @ValueSource(strings = {"Jhon", "jhon 1smith", "jOn! sMi", "1 1", "$ ^"})
    @ParameterizedTest
    public void unsuccessRenameUser(String name) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();

        UpdateCustomerProfileRequest request = UpdateCustomerProfileRequest.builder()
                .name(name)
                .build();

        ValidatableResponse validatableResponse = new UserUpdateProfileRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsBAD())
                .put(request);
        Response response = validatableResponse.extract().response();
        String bodyResponse = response.getBody().asString();


        Customer customer = new GetUserProfileRequster(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get()
                .extract().as(Customer.class);


        softly.assertThat(bodyResponse).as("Проверка текста ошибки").isEqualTo("Name must contain two words with letters only");
        softly.assertThat(customer.getName()).as("Проверка, что Имя профиля не изменено").isNull();
        softly.assertAll();


    }
}