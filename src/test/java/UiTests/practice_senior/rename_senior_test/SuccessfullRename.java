package UiTests.practice_senior.rename_senior_test;

import UiTests.practice_middle.BaseUiTest;
import UiTests.practice_senior.BaseUiTestSenior;
import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.EditProfilePage;

public class SuccessfullRename extends BaseUiTestSenior {
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
