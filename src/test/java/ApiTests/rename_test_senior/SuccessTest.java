package ApiTests.rename_test_senior;

import ApiTests.BaseTest;
import database.Condition;
import database.DBRequest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.DataBaseSteps;
import practice_middle.dao.Table;
import practice_middle.dao.UserDao;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import practice_middle.models.UpdateCustomerProfileRequest;
import practice_middle.models.UpdateCustomerProfileResponse;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class SuccessTest extends BaseTest {
    @ValueSource(strings = {"Jhon Smith", "jhon smith", "jOn sMi"})
    @ParameterizedTest
    public void successRenameUser(String name) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();

        UpdateCustomerProfileRequest updateCustomerProfileRequest = UpdateCustomerProfileRequest.builder()
                .name(name)
                .build();

        UpdateCustomerProfileResponse updateCustomerProfileResponse = new ValidatedCrudRequester<UpdateCustomerProfileResponse>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.UPDATE_CUSTOMER, ResponseSpecs.requestReturnsOK())
                .update(updateCustomerProfileRequest);

        Customer customer = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();

        UserDao userDao = DataBaseSteps.getUserByUserId(customer.getId());

        softly.assertThat(name).as("Проверка изменения имени").isEqualTo(updateCustomerProfileResponse.getCustomer().getName());
        softly.assertThat(updateCustomerProfileResponse.getMessage()).as("Проверка текста успешного сообщения").isEqualTo("Profile updated successfully");
        softly.assertThat(customer.getName()).as("Проверка профиля пользователя").isEqualTo(updateCustomerProfileResponse.getCustomer().getName());
        softly.assertThat(customer.getName()).as("Проверка имени в базе данных ").isEqualTo(userDao.getName());
        softly.assertAll();






    }
}
