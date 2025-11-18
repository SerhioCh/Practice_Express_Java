package UiTests.rename_senior_test;


import UiTests.BaseUiTestSenior;
import com.codeborne.selenide.SelenideElement;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import practice_middle.generator.RandomData;
import practice_middle.models.Customer;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.EditProfilePage;

@Execution(ExecutionMode.SAME_THREAD)
public class SuccessfullRenameTest extends BaseUiTestSenior {
    @Test
    @UserSession
    public void successRenameAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        new EditProfilePage().open().addName(ACCOUNT_NAME).
                checkAlertMessageAndAccept(softly, BankAlerts.SUCCESS_RENAME_PROFILE);

        Customer customerGet = userSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isEqualTo(ACCOUNT_NAME);
    }
}
