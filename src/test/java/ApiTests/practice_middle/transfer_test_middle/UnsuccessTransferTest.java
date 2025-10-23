package ApiTests.practice_middle.transfer_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.AccountHelper;
import ApiTests.practice_middle.helpers.TestUserManager;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.CreateTransferRequest;
import practice_middle.models.Transaction;
import practice_middle.requests.UserAccountTransactionsRequester;
import practice_middle.requests.UserCreateTransferRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;


public class UnsuccessTransferTest extends BaseTest {
    @ValueSource(strings = {"0", "-1"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccount(String amount) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();
        long accountId = AccountHelper.createAccountForUser(username, password).getId();
        AccountHelper.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = AccountHelper.createAccountForUser(username, password).getId();

        CreateTransferRequest request = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        ValidatableResponse validatableResponse = new UserCreateTransferRequester(RequestSpecs.userAuthSpec(username, password), ResponseSpecs.requestReturnsBAD())
                .post(request);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();

        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get(accountId2)
                .extract().as(new TypeRef<List<Transaction>>() {
                });
        softly.assertThat(responseBody)
                .as("Проверка текста ошибки")
                .isEqualTo("Transfer amount must be at least 0.01");
        softly.assertThat(transactions)
                .as("Проверка, что аккаунт не получил трансфер")
                .isEmpty();
        softly.assertAll();

    }

    @ValueSource(strings = {"10000.1", "500000"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccountMoreTenThousand(String amount) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();
        long accountId = AccountHelper.createAccountForUser(username, password).getId();
        AccountHelper.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = AccountHelper.createAccountForUser(username, password).getId();

        CreateTransferRequest request = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        ValidatableResponse validatableResponse = new UserCreateTransferRequester(RequestSpecs.userAuthSpec(username, password), ResponseSpecs.requestReturnsBAD())
                .post(request);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();

        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get(accountId2)
                .extract().as(new TypeRef<List<Transaction>>() {
                });
        softly.assertThat(responseBody)
                .as("Проверка текста ошибки")
                .isEqualTo("Transfer amount cannot exceed 10000");
        softly.assertThat(transactions)
                .as("Проверка, что аккаунт не получил трансфер")
                .isEmpty();
        softly.assertAll();
    }

    @Test
    public void unsuccessTransferForYourAccountMoreThanInTheAccount() {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();
        long accountId = AccountHelper.createAccountForUser(username, password).getId();
        AccountHelper.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = AccountHelper.createAccountForUser(username, password).getId();

        CreateTransferRequest request = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal("5001"))
                .build();

        ValidatableResponse validatableResponse = new UserCreateTransferRequester(RequestSpecs.userAuthSpec(username, password), ResponseSpecs.requestReturnsBAD())
                .post(request);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();


        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get(accountId2)
                .extract().as(new TypeRef<List<Transaction>>() {
                });
        softly.assertThat(responseBody)
                .as("Проверка текста ошибки")
                .isEqualTo("Invalid transfer: insufficient funds or invalid accounts");
        softly.assertThat(transactions)
                .as("Проверка, что аккаунт не получил трансфер")
                .isEmpty();
        softly.assertAll();

    }

}
