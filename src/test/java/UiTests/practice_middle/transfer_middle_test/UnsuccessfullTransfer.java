package UiTests.practice_middle.transfer_middle_test;

import UiTests.practice_middle.BaseUiTest;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.*;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.TransferPage;

import java.math.BigDecimal;

public class UnsuccessfullTransfer extends BaseUiTest {
    @Test
    public void transferToYourAccountWithInvalidAmount() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "-1";
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_AMOUNT_GREATER_THAN_ZERO_POINT_ONE);

        Transaction[] transaction = UserSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();

    }

    @Test
    public void transferToYourAccountWithAmountMoreTenThousand() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "10001";
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_AMOUNT_MORE_THAN_TEN_THOUSAND);

        Transaction[] transaction = UserSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();

    }

    @Test
    public void invalidTransferWithEmptyFields() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "5000";
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        new TransferPage().open().fillingInAllField(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .clearSelectAccount("-- Choose an account --")
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.TRANSFER_EMPTY_ALL_FIELDS)
                .selectAccount(account1)
                .clearRecipientAccount()
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.TRANSFER_EMPTY_ALL_FIELDS)
                .enterRecipientAccount(account2.getAccountNumber())
                .clearAmount()
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.TRANSFER_EMPTY_ALL_FIELDS)
                .enterAmount(DEPOSIT_AMOUNT)
                .setConfirmCheckBox(false)
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.TRANSFER_EMPTY_ALL_FIELDS);

        Transaction[] transaction = UserSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();
    }


    @Test
    public void transferToInvalidAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        new TransferPage().open().fillingInAllField(account1, account1, customer, DEPOSIT_AMOUNT, true)
                .enterRecipientAccount("ACC33")
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_INVALID_ACCOUNT_NUMBER);

    }

    @Test
    public void transferToYourAccountWithOverdraft() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = "6000";
        CreateUserRequest user = AdminSteps.createConstantUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());
        UserSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = UserSteps.createAccountForUser(user.getUsername(), user.getPassword());

        new TransferPage().open().addTransfer(account1,account2,customer,DEPOSIT_AMOUNT,true)
                        .checkAlertMessageAndAccept(softly,BankAlerts.INVALID_TRANSFER_OVERDRAFT);

        Transaction[] transaction = UserSteps.getAllTransaction(user,account2);
        softly.assertThat(transaction).isEmpty();
    }
}
