package UiTests.transfer_senior_test;


import UiTests.BaseUiTestSenior;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import practice_middle.generator.RandomData;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.Customer;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.TransferPage;

import java.math.BigDecimal;

public class UnsuccessfullTransferTest extends BaseUiTestSenior {
    @Test
    @UserSession
    public void transferToYourAccountWithInvalidAmount() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "-1";
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        Customer customer = userSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        userSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_AMOUNT_GREATER_THAN_ZERO_POINT_ONE);

        Transaction[] transaction = userSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();

    }

    @Test
    @UserSession
    public void transferToYourAccountWithAmountMoreTenThousand() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "10001";
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        Customer customer = userSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        userSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        new TransferPage().open().addTransfer(account1, account2, customer, DEPOSIT_AMOUNT, true)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_AMOUNT_MORE_THAN_TEN_THOUSAND);

        Transaction[] transaction = userSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();

    }

    @Test
    @UserSession
    @Disabled("Не исправлен баг, при отсуствующем номере аккаунта можно отправить трансфер")
    public void invalidTransferWithEmptyFields() {
        final String ACCOUNT_NAME = RandomData.getName();;
        final String DEPOSIT_AMOUNT = "5000";
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        Customer customer = userSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        userSteps.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());

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

        Transaction[] transaction = userSteps.getAllTransaction(user, account2);
        softly.assertThat(transaction).isEmpty();
    }


    @Test
    @UserSession(value = 2,auth = 1)
    @Disabled("Баг,неверный аллерт, пишет что пользователя с таким именем не существует, вместо аккаунта")
    public void transferToInvalidAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        var user = SessionStorage.getUser(1);
        var user2 = SessionStorage.getUser(2);
        var userSteps1 = SessionStorage.getSteps(1);
        var userSteps2 = SessionStorage.getSteps(2);
        Customer customer = userSteps2.addNameForAccount(ACCOUNT_NAME, user2.getUsername(), user2.getPassword());
        AccountUserResponse account1 = userSteps1.createAccountForUser(user.getUsername(), user.getPassword());
        userSteps1.addDepositForAccount(account1.getId(), new BigDecimal(DEPOSIT_AMOUNT), user.getUsername(), user.getPassword());
        new TransferPage().open().fillingInAllField(account1, account1, customer, DEPOSIT_AMOUNT, true)
                .enterRecipientAccount("ACC33")
                .clickSend()
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_TRANSFER_INVALID_ACCOUNT_NUMBER);


    }

    @Test
    @UserSession
    public void transferToYourAccountWithOverdraft() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = "6000";
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        Customer customer = userSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        AccountUserResponse account1 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());
        userSteps.addDepositForAccount(account1.getId(), new BigDecimal("5000"), user.getUsername(), user.getPassword());
        AccountUserResponse account2 = userSteps.createAccountForUser(user.getUsername(), user.getPassword());

        new TransferPage().open().addTransfer(account1,account2,customer,DEPOSIT_AMOUNT,true)
                        .checkAlertMessageAndAccept(softly,BankAlerts.INVALID_TRANSFER_OVERDRAFT);

        Transaction[] transaction = userSteps.getAllTransaction(user,account2);
        softly.assertThat(transaction).isEmpty();
    }
}
