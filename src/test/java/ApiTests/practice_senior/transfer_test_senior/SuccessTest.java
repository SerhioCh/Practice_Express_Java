package ApiTests.practice_senior.transfer_test_senior;

import ApiTests.practice_middle.BaseTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.CreateTransferRequest;
import practice_middle.models.CreateTransferResponse;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class SuccessTest extends BaseTest {
    @ValueSource(strings = {"0.01", "10000"})
    @ParameterizedTest
    public void successTransferForYourAccount(String amount) {
        CreateUserRequest request = AdminSteps.createConstantUser();
        String username = request.getUsername();
        String password = request.getPassword();
        long accountId1 = UserSteps.createAccountForUser(username, password).getId();
        UserSteps.addDepositForAccount(accountId1, new BigDecimal("5000"), username, password);
        UserSteps.addDepositForAccount(accountId1, new BigDecimal("5000"), username, password);
        long accountId2 = UserSteps.createAccountForUser(username, password).getId();

        CreateTransferRequest createTransferRequest = CreateTransferRequest.builder()
                .senderAccountId(accountId1)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        BigDecimal expected = new BigDecimal(amount);
        CreateTransferResponse createTransferResponse = new ValidatedCrudRequester<CreateTransferResponse>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.TRANSFER, ResponseSpecs.requestReturnsOK())
                .post(createTransferRequest);

        BigDecimal actualAmount = createTransferResponse.getAmount();

        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId2, transactionListType);


        Number amountNumber = (Number) transactions.get(0).getAmount();
        BigDecimal amountDeposit = BigDecimal.valueOf(amountNumber.doubleValue());


        softly.assertThat(actualAmount)
                .as("Проверка баланса после перевода")
                .isEqualByComparingTo(amountDeposit);
        softly.assertThat(actualAmount)
                .as("Проверка баланса с expected")
                .isEqualByComparingTo(expected);
        softly.assertAll();
    }
}
