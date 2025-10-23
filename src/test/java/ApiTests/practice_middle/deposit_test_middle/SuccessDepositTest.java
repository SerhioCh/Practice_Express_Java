package ApiTests.practice_middle.deposit_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.AccountHelper;
import ApiTests.practice_middle.helpers.TestUserManager;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.*;
import practice_middle.requests.UserAccountTransactionsRequester;
import practice_middle.requests.UserAddDepositRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class SuccessDepositTest extends BaseTest {

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "4999.9", "5000"})
    public void successDepositIntoYourAccount(String balance) {
        CreateUserRequest request = TestUserManager.createTemporaryUser();
        long accountId = AccountHelper.createAccountForUser(request.getUsername(), request.getPassword()).getId();

        AddDepositUserAccountRequest addDeposit = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(new BigDecimal(balance))
                .build();

        BigDecimal expected = new BigDecimal(balance);

        AccountUserResponse accountUserResponse = new UserAddDepositRequester(RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                ResponseSpecs.requestReturnsOK())
                .post(addDeposit).extract().as(AccountUserResponse.class);

        BigDecimal actualBalance = accountUserResponse.getBalance();

        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(request.getUsername(), request.getPassword()),
                ResponseSpecs.requestReturnsOK())
                .get(accountId)
                .extract().as(new TypeRef<List<Transaction>>() {
                });


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
