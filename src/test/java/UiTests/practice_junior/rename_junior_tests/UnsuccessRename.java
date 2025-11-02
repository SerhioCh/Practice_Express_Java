package UiTests.practice_junior.rename_junior_tests;

import ApiTests.practice_middle.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import practice_middle.models.LoginUserRequest;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class UnsuccessRename extends BaseTest {
    @BeforeAll
    public static void setupSelenoid() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.baseUrl = "http://192.168.1.120:3000";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.of("enableVNC", true, "enableLog", true));
    }

    @Test
    public void invalidRenameSameName() {
        final String ACCOUNT_NAME = "Jhon Smith";
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/edit-profile");


        $(Selectors.byAttribute("placeholder", "Enter new name")).shouldBe(visible, enabled)
                .setValue(ACCOUNT_NAME).shouldHave(value(ACCOUNT_NAME));
        $$("button").findBy(text("Save Changes")).click();


        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("⚠\uFE0F New name is the same as the current one.");
        alert.accept();

        Customer customerGet = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();

        softly.assertThat(customerGet.getName()).isEqualTo(ACCOUNT_NAME);
        softly.assertAll();
    }

    @Test
    public void invalidRenameOneWord() {
        final String ACCOUNT_NAME = "car";
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/edit-profile");


        $(Selectors.byAttribute("placeholder", "Enter new name")).shouldBe(visible, enabled)
                .setValue(ACCOUNT_NAME).shouldHave(value(ACCOUNT_NAME));
        $$("button").findBy(text("Save Changes")).click();


        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("Name must contain two words with letters only");
        alert.accept();

        Customer customerGet = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();

        softly.assertThat(customerGet.getName()).isNull();
        softly.assertAll();
    }

    @Test
    public void invalidRenameEmptyField() {
        final String ACCOUNT_NAME = "car";
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/edit-profile");


        $$("button").findBy(text("Save Changes")).click();


        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Please enter a valid name.");
        alert.accept();

        Customer customerGet = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();

        softly.assertThat(customerGet.getName()).isNull();
        softly.assertAll();
    }
}
