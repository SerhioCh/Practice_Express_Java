package UiTests.practice_junior.deposit_junior_test;

import ApiTests.practice_middle.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.LoginUserRequest;
import practice_middle.models.Transaction;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;

public class UnsuccessDepositTest extends BaseTest {
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
    public void addInvalidDepositToAccount() {
        final String DEPOSIT_AMOUNT = "-1";
        CreateUserRequest user = AdminSteps.createConstantUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        AccountUserResponse account = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/deposit");

        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $$("button").findBy(text("Deposit")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Please enter a valid amount.");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }

    @Test
    public void addDepositToBlankAccount() {
        CreateUserRequest user = AdminSteps.createConstantUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/deposit");

        $$("button").findBy(text("Deposit")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Please select an account.");
        softly.assertAll();
        alert.accept();

    }
}
