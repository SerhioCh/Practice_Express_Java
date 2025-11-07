package UiTests.practice_middle.transfer_middle_test;

import UiTests.practice_middle.BaseUiTest;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.*;
import ui_middle.pages_middle.TransferPage;

import java.math.BigDecimal;

public class SuccessfullTransfer extends BaseUiTest {
    @Test
    public void transferToYourAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account2.getAccountNumber());

        Transaction[] transaction = UserSteps.getAllTransaction(user, account2);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();


    }

    @Test
    public void transferToAnotherUser() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        CreateUserRequest user1 = AdminSteps.createConstantUser();
        CreateUserRequest user2 = AdminSteps.createTemporaryUser();
        authUser(user1);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user2.getUsername(), user2.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user1.getUsername(), user1.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user1.getUsername(), user1.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user2.getUsername(), user2.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account2.getAccountNumber());

        Transaction[] transaction = UserSteps.getAllTransaction(user2, account2);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
        softly.assertAll();
    }

}
