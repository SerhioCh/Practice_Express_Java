package UiTests.practice_junior.transactions_junior_test;

import ApiTests.practice_middle.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
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

public class UnsuccessTransfer extends BaseTest {
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
    public void transferToYourAccountWithInvalidAmount() {
        final String ACCOUNT_NAME = "Jhon Smith";
        final String DEPOSIT_AMOUNT = "-1";
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
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
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
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Transfer amount must be at least 0.01");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }

    @Test
    public void transferToYourAccountWithAmountMoreTenThousand() {
        final String ACCOUNT_NAME = "Jhon Smith";
        final String DEPOSIT_AMOUNT = "10001";
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
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
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
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Transfer amount cannot exceed 10000");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }

    @Test
    public void invalidTransferWithEmptyFields() {
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
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
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
        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText("-- Choose an account --");
        $$("button").findBy(text("Send Transfer")).click();
        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Please fill all fields and confirm.");
        alert.accept();
        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account1.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .clear();
        $$("button").findBy(text("Send Transfer")).click();
        alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Please fill all fields and confirm.");
        alert.accept();
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .setValue(account2.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .clear();
        $$("button").findBy(text("Send Transfer")).click();
        alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Please fill all fields and confirm.");
        alert.accept();
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $("#confirmCheck").setSelected(false);
        $$("button").findBy(text("Send Transfer")).click();
        alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Please fill all fields and confirm.");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }


    @Test
    @Disabled("Нет алерта на невалидное имя пользователя")
    public void transferToInvalidUser() {
        final String ACCOUNT_NAME = "invalidUser";
        final String DEPOSIT_AMOUNT = "5000";
        CreateUserRequest user = AdminSteps.createConstantUser();
        String userAuthHeader = new CrudRequester(RequestSpecs.unAuthUserSpec(), Endpoint.LOGIN, ResponseSpecs.requestReturnsOK())
                .post(LoginUserRequest.builder()
                        .username(user.getUsername())
                        .password(user.getPassword())
                        .build())
                .extract()
                .header("Authorization");

        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/transfer");

        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account1.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter recipient name")).shouldBe(visible, enabled)
                .setValue(ACCOUNT_NAME);
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .setValue(account2.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $("#confirmCheck").setSelected(true);
        $$("button").findBy(text("Send Transfer")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Нет алерта");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }

    @Test
    public void transferToInvalidAccount() {
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
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());

        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);", userAuthHeader);
        open("/transfer");

        $("select.form-control.account-selector").shouldBe(visible, enabled)
                .selectOptionContainingText(account1.getAccountNumber());
        $(Selectors.byAttribute("placeholder", "Enter recipient name")).shouldBe(visible, enabled)
                .setValue(customer.getName());
        $(Selectors.byAttribute("placeholder", "Enter recipient account number")).shouldBe(visible, enabled)
                .setValue("ACC303");
        $(Selectors.byAttribute("placeholder", "Enter amount")).shouldBe(visible, enabled)
                .setValue(DEPOSIT_AMOUNT);
        $("#confirmCheck").setSelected(true);
        $$("button").findBy(text("Send Transfer")).click();

        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: No user found with this account number.");
        alert.accept();

    }

    @Test
    public void transferToYourAccountWithOverdraft() {
        final String ACCOUNT_NAME = "Jhon Smith";
        final String DEPOSIT_AMOUNT = "6000";
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
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
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
        softly.assertThat(alert.getText()).isEqualTo("❌ Error: Invalid transfer: insufficient funds or invalid accounts.");
        alert.accept();

        Transaction[] transaction = new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account2.getId())
                .extract().as(Transaction[].class);

        softly.assertThat(transaction).isEmpty();
        softly.assertAll();
    }

}
