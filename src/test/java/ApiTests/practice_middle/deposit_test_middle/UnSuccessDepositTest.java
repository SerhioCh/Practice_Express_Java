package ApiTests.practice_middle.deposit_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.AccountHelper;
import ApiTests.practice_middle.helpers.TestUserManager;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.AddDepositUserAccountRequest;
import practice_middle.models.Transaction;
import practice_middle.requests.UserAccountTransactionsRequester;
import practice_middle.requests.UserAddDepositRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;


public class UnSuccessDepositTest extends BaseTest {
    private final static String ERROR_MESSAGE = "Deposit amount must be at least 0.011";

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-10.9"})
    public void unsuccessDepositIntoYourAccount(String balance) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();
        Long accountId = AccountHelper.createAccountForUser(username, password).getId();

        AddDepositUserAccountRequest addDeposit = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(new BigDecimal(balance))
                .build();

        String errorMessage = new UserAddDepositRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsBAD())
                .post(addDeposit).extract().asString();

        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get(accountId)
                .extract().as(new TypeRef<List<Transaction>>() {
                });


        softly.assertThat(errorMessage)
                .as("Проверка текста ошибка")
                .isEqualTo(ERROR_MESSAGE);
        softly.assertThat(transactions)
                .as("Проверка, что список транзакций пуст")
                .isEmpty();
        softly.assertAll();

    }
}
