package UiTests.deposit_senior_test;

import UiTests.BaseUiTestSenior;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.DepositPage;

public class UnsuccessfullDepositTest extends BaseUiTestSenior {
    @Test
    @UserSession
    public void addInvalidDepositToAccount() {
        final String DEPOSIT_AMOUNT = "-1";
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        AccountUserResponse account = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new DepositPage().open().addDeposit(account, DEPOSIT_AMOUNT).checkAlertMessageAndAccept(softly, BankAlerts.INVALID_AMOUNT_DEPOSIT);
        Transaction[] transaction = UserSteps.getAllTransaction(user, account);
        softly.assertThat(transaction).isEmpty();
    }

    @Test
    @UserSession
    public void addDepositToBlankAccount() {
        new DepositPage().open().addDepositWithoutAccount("100").checkAlertMessageAndAccept(softly, BankAlerts.ACCOUNT_NOT_SELECTED);
    }
}
