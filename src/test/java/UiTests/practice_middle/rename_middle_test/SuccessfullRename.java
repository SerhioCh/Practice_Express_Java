package UiTests.practice_middle.rename_middle_test;

import UiTests.practice_middle.BaseUiTest;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.Customer;
import ui_middle.pages_middle.BankAlerts;
import ui_middle.pages_middle.EditProfilePage;

public class SuccessfullRename extends BaseUiTest {
    @Test
    public void successRenameAccount() {
        final String ACCOUNT_NAME = RandomData.getName();
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        authUser(user);
        new EditProfilePage().open().addName(ACCOUNT_NAME).
                checkAlertMessageAndAccept(softly, BankAlerts.SUCCESS_RENAME_PROFILE);
        Customer customerGet = UserSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isEqualTo(ACCOUNT_NAME);
    }
}
