package ui_middle.pages_middle;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class EditProfilePage extends BasePage<EditProfilePage> {

    private SelenideElement enterName = $(Selectors.byAttribute("placeholder", "Enter new name"));
    private SelenideElement buttonSaveChanges = $$("button").findBy(text("Save Changes"));


    @Override
    public String url() {
        return "/edit-profile";
    }

    public EditProfilePage addName(String accountName) {
        enterName.shouldHave(visible,enabled).setValue(accountName).shouldHave(value(accountName));
        buttonSaveChanges.click();
        return this;
    }

    public EditProfilePage setName(String accountName) {
        enterName.setValue(accountName).shouldHave(visible,enabled).shouldHave(value(accountName));
        return this;
    }

    public EditProfilePage enterButton() {
        buttonSaveChanges.click();
        return this;
    }

}
