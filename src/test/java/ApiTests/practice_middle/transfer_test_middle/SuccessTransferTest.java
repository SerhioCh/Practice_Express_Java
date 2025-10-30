package ApiTests.practice_middle.transfer_test_middle;

import ApiTests.practice_middle.BaseTest;
import ApiTests.practice_middle.helpers.AccountHelper;
import ApiTests.practice_middle.helpers.TestUserManager;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import practice_middle.models.CreateTransferRequest;
import practice_middle.models.CreateTransferResponse;
import practice_middle.models.Transaction;
import practice_middle.requests.UserAccountTransactionsRequester;
import practice_middle.requests.UserCreateTransferRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.List;

public class SuccessTransferTest extends BaseTest {
    @ValueSource(strings = {"0.01","9999.99","10000"})
    @ParameterizedTest
    public void successTransferForYourAccount(String amount) {
        String username = TestUserManager.getUsername();
        String password = TestUserManager.getPassword();
        long accountId1 = AccountHelper.createAccountForUser(username, password).getId();
        AccountHelper.addDepositForAccount(accountId1, new BigDecimal("5000"), username, password);
        AccountHelper.addDepositForAccount(accountId1, new BigDecimal("5000"), username, password);
        long accountId2 = AccountHelper.createAccountForUser(username, password).getId();

        CreateTransferRequest request = CreateTransferRequest.builder()
                .senderAccountId(accountId1)
                .receiverAccountId(accountId2)
                .amount(new BigDecimal(amount))
                .build();

        BigDecimal expected = new BigDecimal(amount);
        CreateTransferResponse createTransferResponse = new UserCreateTransferRequester(RequestSpecs.userAuthSpec(username, password), ResponseSpecs.requestReturnsOK())
                .post(request).extract().as(CreateTransferResponse.class);

        BigDecimal actualAmount = createTransferResponse.getAmount();

        List<Transaction> transactions = new UserAccountTransactionsRequester(RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.requestReturnsOK())
                .get(accountId2)
                .extract().as(new TypeRef<List<Transaction>>() {
                });


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
