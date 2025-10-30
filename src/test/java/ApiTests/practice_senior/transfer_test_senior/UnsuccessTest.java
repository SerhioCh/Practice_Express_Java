package ApiTests.practice_senior.transfer_test_senior;

import ApiTests.practice_middle.BaseTest;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.CreateTransferRequest;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class UnsuccessTest extends BaseTest {
    @ValueSource(strings = {"0", "-1"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccount(String amount) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();
        long accountId = UserSteps.createAccountForUser(username, password).getId();
        UserSteps.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = UserSteps.createAccountForUser(username, password).getId();

        CreateTransferRequest createTransferRequest = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        ValidatableResponse validatableResponse = new CrudRequester(RequestSpecs.userAuthSpec(username, password),
                Endpoint.TRANSFER, ResponseSpecs.requestReturnsBAD())
                .post(createTransferRequest);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();

        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId2, transactionListType);
        softly.assertThat(responseBody)
                .as("Проверка текста ошибки")
                .isEqualTo("Transfer amount must be at least 0.01");
        softly.assertThat(transactions)
                .as("Проверка, что аккаунт не получил трансфер")
                .isEmpty();
        softly.assertAll();

    }

    @ValueSource(strings = {"10000.01","10000.1", "500000"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccountMoreTenThousand(String amount) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();
        long accountId = UserSteps.createAccountForUser(username, password).getId();
        UserSteps.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = UserSteps.createAccountForUser(username, password).getId();

        CreateTransferRequest createTransferRequest = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        ValidatableResponse validatableResponse = new CrudRequester(RequestSpecs.userAuthSpec(username, password),
                Endpoint.TRANSFER, ResponseSpecs.requestReturnsBAD())
                .post(createTransferRequest);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();

        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId2, transactionListType);
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
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();
        long accountId = UserSteps.createAccountForUser(username, password).getId();
        UserSteps.addDepositForAccount(accountId, new BigDecimal("5000"), username, password);
        long accountId2 = UserSteps.createAccountForUser(username, password).getId();

        CreateTransferRequest createTransferRequest = CreateTransferRequest.builder()
                .senderAccountId(accountId)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal("5001"))
                .build();

        ValidatableResponse validatableResponse = new CrudRequester(RequestSpecs.userAuthSpec(username, password),
                Endpoint.TRANSFER, ResponseSpecs.requestReturnsBAD())
                .post(createTransferRequest);
        Response response = validatableResponse.extract().response();
        String responseBody = response.getBody().asString();

        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId2, transactionListType);
        softly.assertThat(responseBody)
                .as("Проверка текста ошибки")
                .isEqualTo("Invalid transfer: insufficient funds or invalid accounts");
        softly.assertThat(transactions)
                .as("Проверка, что аккаунт не получил трансфер")
                .isEmpty();
        softly.assertAll();

    }
}
