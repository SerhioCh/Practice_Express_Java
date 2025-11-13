package UiTests.practice_senior.transfer_senior_test;

import UiTests.practice_senior.BaseUiTestSenior;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.TransferPage;

import java.math.BigDecimal;

public class SuccessfullTransfer extends BaseUiTestSenior {
    @Test
    @UserSession
    public void transferToYourAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        var user = SessionStorage.getUser();
        var userSetps = SessionStorage.getSteps();
        Customer customer = userSetps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = userSetps.createAccountForUser(user.getUsername(), user.getPassword());
        userSetps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = userSetps.createAccountForUser(user.getUsername(), user.getPassword());

        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account2.getAccountNumber());

        Transaction[] transaction = userSetps.getAllTransaction(user, account2);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();


    }

    @Test
    @UserSession(value = 2)
    public void transferToAnotherUser() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        var user1 = SessionStorage.getUser(1);
        var user2 = SessionStorage.getUser(2);
        var userSteps1 = SessionStorage.getSteps(1);
        var userSteps2 = SessionStorage.getSteps(2);
        Customer customer = userSteps2.addNameForAccount(ACCOUNT_NAME, user2.getUsername(), user2.getPassword());
        AccountUserResponse account1 = userSteps1.createAccountForUser(user1.getUsername(), user1.getPassword());
        userSteps1.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user1.getUsername(), user1.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user2.getUsername(), user2.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account2.getAccountNumber());

        Transaction[] transaction = userSteps2.getAllTransaction(user2, account2);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();
    }

}
