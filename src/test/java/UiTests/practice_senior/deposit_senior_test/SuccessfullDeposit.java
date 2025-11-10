package UiTests.practice_senior.deposit_senior_test;

import UiTests.practice_senior.BaseUiTestSenior;
import common.annotations.Browsers;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import practice_middle.generator.RandomData;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.Transaction;
import ui_middle.pages_middle.DepositPage;
import ui_middle.pages_middle.ui_elements_senior.AcсountOption;
import static  org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

public class SuccessfullDeposit extends BaseUiTestSenior {


    @Test
    @DisplayName("Добавление депозита на свой аккаунт")
    @UserSession()
    @Browsers({"chrome"})
    public void addDepositToAccount() {
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        AccountUserResponse account = userSteps.createAccountForUser(user.getUsername(),user.getPassword());
        new DepositPage().open().addDeposit(account, DEPOSIT_AMOUNT)
                .checkAlertAndAccept(softly, "$" + DEPOSIT_AMOUNT, account.getAccountNumber());
        Transaction[] transaction = userSteps.getAllTransaction(user, account);
        BigDecimal amount = transaction[0].getAmount();
        softly.assertThat(0).isEqualTo(amount.compareTo(new BigDecimal(DEPOSIT_AMOUNT)));
    }

    @Test
    @DisplayName("Проверка отображения  аккаунта в селекте через AccountOption")
    @UserSession
    @Browsers("chrome")
    public  void getAccountInAccountsSelect(){
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        AccountUserResponse account1 = userSteps.createAccountForUser(user.getUsername(),user.getPassword());
        AccountUserResponse account2 = userSteps.createAccountForUser(user.getUsername(),user.getPassword());
        AccountUserResponse account3 = userSteps.createAccountForUser(user.getUsername(),user.getPassword());
        assertTrue(new DepositPage().open().getAllAccounts().stream()
              .anyMatch(l -> l.getLabel().contains(account1.getAccountNumber())));
    }

}
