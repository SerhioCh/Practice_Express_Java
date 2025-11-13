package ApiTests.practice_middle.rename_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.TestUserManager;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.Customer;
import practice_middle.models.UpdateCustomerProfileRequest;
import practice_middle.models.UpdateCustomerProfileResponse;
import practice_middle.requests.GetUserProfileRequster;
import practice_middle.requests.UserUpdateProfileRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class SuccessRename extends BaseTest {
    @ValueSource(strings = {"Jhon Smith", "jhon smith", "jOn sMi"})
    @ParameterizedTest
    public void successRenameUser(String name) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();

        UpdateCustomerProfileRequest request = UpdateCustomerProfileRequest.builder()
                .name(name)
                .build();

        UpdateCustomerProfileResponse updateCustomerProfileResponse = new UserUpdateProfileRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .put(request)
                .extract().as(UpdateCustomerProfileResponse.class);

        Customer customer = new GetUserProfileRequster(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get()
                .extract().as(Customer.class);


        softly.assertThat(name).as("Проверка изменения имени").isEqualTo(updateCustomerProfileResponse.getCustomer().getName());
        softly.assertThat(updateCustomerProfileResponse.getMessage()).as("Проверка текста успешного сообщения").isEqualTo("Profile updated successfully");
        softly.assertThat(customer.getName()).as("Проверка профиля пользователя").isEqualTo(updateCustomerProfileResponse.getCustomer().getName());
        softly.assertAll();


    }
}