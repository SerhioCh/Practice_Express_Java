package ApiTests.deposit_test_senior;

import ApiTests.BaseTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.AddDepositUserAccountRequest;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class UnsuccessTest extends BaseTest {
    private final static String ERROR_MESSAGE = "Deposit amount must be at least 0.01";

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-10.9"})
    public void unsuccessDepositIntoYourAccount(String balance) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();
        Long accountId = UserSteps.createAccountForUser(username, password).getId();

        AddDepositUserAccountRequest addDeposit = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(new BigDecimal(balance))
                .build();

        String errorMessage = new CrudRequester(RequestSpecs.userAuthSpec(username, password), Endpoint.DEPOSIT,
                ResponseSpecs.requestReturnsBAD())
                .post(addDeposit).extract().asString();

        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId, transactionListType);

        softly.assertThat(errorMessage)
                .as("Проверка текста ошибка")
                .isEqualTo(ERROR_MESSAGE);
        softly.assertThat(transactions)
                .as("Проверка, что список транзакций пуст")
                .isEmpty();
        softly.assertAll();

    }
}
