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

public class UnsuccessfullRename extends BaseUiTestSenior {
    @Test
    @UserSession
    public void invalidRenameSameName() {
        final String ACCOUNT_NAME = RandomData.getName();
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        Customer customer = userSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        new EditProfilePage().open().addName(ACCOUNT_NAME)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_SAME_NAME);

        Customer customerGet = userSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isEqualTo(ACCOUNT_NAME);
    }

    @Test
    @UserSession
    public void invalidRenameOneWord() throws InterruptedException {
        final String ACCOUNT_NAME = RandomData.getInvalidName();
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();
        new EditProfilePage().open().addName(ACCOUNT_NAME)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_CONTAINS_ONE_WORD);
        Customer customerGet = userSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isNull();

    }

    @Test
    @UserSession
    public void invalidRenameEmptyField() {
        var user = SessionStorage.getUser();
        var userSteps = SessionStorage.getSteps();

        new EditProfilePage().open().enterButton()
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_EMPTY_FIELD);
        Customer customerGet = userSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isNull();

    }
}
