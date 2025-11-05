package UiTests.practice_junior.transactions_junior_test;

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
import practice_middle.models.*;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.Map;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.switchTo;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessTransfer extends BaseTest {
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
    public void transferToYourAccount() {
        final String ACCOUNT_NAME = "Jhon Smith";
        final String DEPOSIT_AMOUNT = "5000";
        CreateUserRequest user = AdminSteps.createConstantUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/transfer");

        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account1.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter recipient name")).shouldBe(visible, enabled)
                .setValue(customer.getName());
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .setValue(account2.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $("#confirmCheck").setSelected(true);
        $$("button").findBy(text("Send Transfer")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).as("Transfer is incorrect in alert").contains("$" + DEPOSIT_AMOUNT);
        softly.assertThat(alert.getText()).as("Account is incorrect in alert").contains(account2.getAccountNumber());
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);


        BigDecimal amount = transaction[0].getAmount();

        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();


    }

    @Test
    public void transferToAnotherUser() {
        final String ACCOUNT_NAME = "Jhon Smith";
        final String DEPOSIT_AMOUNT = "5000";
        CreateUserRequest user1 = AdminSteps.createConstantUser();
        CreateUserRequest user2 = AdminSteps.createTemporaryUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user1.getUsername())
                        .password(user1.getPassword())
                        .build())
                .extract()
                .header("Authorization");
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user2.getUsername(), user2.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user1.getUsername(), user1.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user1.getUsername(), user1.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user2.getUsername(), user2.getPassword());

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/transfer");

        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account1.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter recipient name")).shouldBe(visible, enabled)
                .setValue(customer.getName());
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .setValue(account2.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $("#confirmCheck").setSelected(true);
        $$("button").findBy(text("Send Transfer")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).as("Transfer is incorrect in alert").contains("$" + DEPOSIT_AMOUNT);
        softly.assertThat(alert.getText()).as("Account is incorrect in alert").contains(account2.getAccountNumber());
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user2.getUsername(), user2.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);


        BigDecimal amount = transaction[0].getAmount();

        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();
    }
}
