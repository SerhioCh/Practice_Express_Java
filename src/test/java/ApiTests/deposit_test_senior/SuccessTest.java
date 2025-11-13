package ApiTests.deposit_test_senior;

import ApiTests.BaseTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.AddDepositUserAccountRequest;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class SuccessTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"0.01", "4999.9", "5000"})
    public void successDepositIntoYourAccount(String balance) {
        CreateUserRequest request = AdminSteps.createTemporaryUser();
        long accountId = UserSteps.createAccountForUser(request.getUsername(), request.getPassword()).getId();

        AddDepositUserAccountRequest addDeposit = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(new BigDecimal(balance))
                .build();

        BigDecimal expected = new BigDecimal(balance);

        AccountUserResponse accountUserResponse = new ValidatedCrudRequester<AccountUserResponse>(RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                Endpoint.DEPOSIT, ResponseSpecs.requestReturnsOK())
                .post(addDeposit);


        BigDecimal actualBalance = accountUserResponse.getBalance();
        TypeRef<List<Transaction>> transactionListType = new TypeRef<>() {
        };
        ValidatedCrudRequester<Transaction> requester =
                new ValidatedCrudRequester<>(
                        RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                        Endpoint.GET_ACCOUNT_TRANSACTIONS,
                        ResponseSpecs.requestReturnsOK()
                );
        List<Transaction> transactions = requester.getList(accountId, transactionListType);


        Number amountNumber = (Number) transactions.get(0).getAmount();
        BigDecimal amountDeposit = BigDecimal.valueOf(amountNumber.doubleValue());


        softly.assertThat(actualBalance)
                .as("Проверка баланса после депозита")
                .isEqualByComparingTo(amountDeposit);
        softly.assertThat(actualBalance)
                .as("Проверка баланса с expected")
                .isEqualByComparingTo(expected);
        softly.assertAll();

    }
}
