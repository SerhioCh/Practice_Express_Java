package UiTests.practice_middle.deposit_middle_test;

import UiTests.practice_middle.BaseUiTest;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.DepositPage;

public class UnsuccessfullDeposit extends BaseUiTest {
    @Test
    public void addInvalidDepositToAccount() {
        final String DEPOSIT_AMOUNT = "-1";
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        AccountUserResponse account = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new DepositPage().open().addDeposit(account, DEPOSIT_AMOUNT).checkAlertMessageAndAccept(softly, BankAlerts.INVALID_AMOUNT_DEPOSIT);
        Transaction[] transaction = UserSteps.getAllTransaction(user, account);
        softly.assertThat(transaction).isEmpty();

    }

    @Test
    public void addDepositToBlankAccount() {
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        new DepositPage().open().addDepositWithoutAccount("100").checkAlertMessageAndAccept(softly, BankAlerts.ACCOUNT_NOT_SELECTED);
    }
}
