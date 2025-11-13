package UiTests.practice_middle.deposit_middle_test;

import UiTests.practice_middle.BaseUiTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.DepositPage;

import java.math.BigDecimal;

public class SuccessfullDeposit extends BaseUiTest {


    @Test
    @DisplayName("Добавление депозита на свой аккаунт")
    public void addDepositToAccount() {
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        AccountUserResponse account = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new DepositPage().open().addDeposit(account, DEPOSIT_AMOUNT)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account.getAccountNumber());
        Transaction[] transaction = UserSteps.getAllTransaction(user, account);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));

    }

}
