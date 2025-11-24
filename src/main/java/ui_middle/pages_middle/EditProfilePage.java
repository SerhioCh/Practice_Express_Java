package ui_middle.pages_middle;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import common.utils.RetryUtils;
import ui_middle.pages_middle.ui_elements_senior.AcсountOption;

import java.util.List;

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
        enterName.shouldBe(visible, enabled);

        // Ввод с повтором пока значение не установится
        RetryUtils.retry(
                () -> {
                    enterName.clear();
                    enterName.setValue(accountName);
                    return enterName.getValue();
                },
                value -> accountName.equals(value),
                5,
                300
        );

        buttonSaveChanges.shouldBe(visible,enabled).click();
        return this;
    }

    public EditProfilePage setName(String accountName) {
        enterName.shouldBe(visible, enabled).clear();
        enterName.setValue(accountName);
        enterName.shouldHave(value(accountName));
        return this;
    }

    public EditProfilePage enterButton() {
        buttonSaveChanges.click();
        return this;
    }


}



