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

public class UnsuccessfullRename extends BaseUiTest {
    @Test
    public void invalidRenameSameName() {
        final String ACCOUNT_NAME = RandomData.getName();
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        authUser(user);
        Customer customer = UserSteps.addNameForAccount(ACCOUNT_NAME, user.getUsername(), user.getPassword());
        new EditProfilePage().open().addName(ACCOUNT_NAME)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_SAME_NAME);

        Customer customerGet = UserSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isEqualTo(ACCOUNT_NAME);
    }

    @Test
    public void invalidRenameOneWord() throws InterruptedException {
        final String ACCOUNT_NAME = RandomData.getInvalidName();
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        authUser(user);
        new EditProfilePage().open().addName(ACCOUNT_NAME)
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_CONTAINS_ONE_WORD);
        Customer customerGet = UserSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isNull();

    }

    @Test
    public void invalidRenameEmptyField() {
        CreateUserRequest user = AdminSteps.createTemporaryUser();
        authUser(user);

        new EditProfilePage().open().enterButton()
                .checkAlertMessageAndAccept(softly, BankAlerts.INVALID_RENAME_EMPTY_FIELD);
        Customer customerGet = UserSteps.getCustomerProfile(user);
        softly.assertThat(customerGet.getName()).isNull();

    }
}
