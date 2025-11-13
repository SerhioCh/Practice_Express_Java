package ui_middle.pages_middle;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.Alert;
import practice_middle.models.CreateUserRequest;
import practice_middle.specs.RequestSpecs;
import ui_middle.pages_middle.ui_elements_senior.BaseElement;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static org.assertj.core.api.Assertions.assertThat;

public abstract class BasePage<T extends BasePage> {
    protected SelenideElement selectAccount = $("select.form-control.account-selector");
    protected SelenideElement enterAmount = $(Selectors.byAttribute("placeholder", "Enter amount"));

    public abstract String url();

    public T open() {
        return Selenide.open(url(), (Class<T>) this.getClass());
    }

    public <T extends BasePage> T getPage(Class<T> pageClass) {
        return Selenide.page(pageClass);
    }


    public T checkAlertMessageAndAccept(SoftAssertions softly, BankAlerts alertText) {
        Alert alert = switchTo().alert();
        softly.assertThat(alert.getText())
                .as("Alert message check")
                .contains(alertText.getMessage());
        alert.accept();
        return (T) this;
    }

    public T checkAlertAndAccept(SoftAssertions softly, String... expectedTexts) {
        Alert alert = switchTo().alert();
        for (String text : expectedTexts) {
            softly.assertThat(alert.getText()).contains(text);
        }
        alert.accept();
        return (T) this;
    }

    public  static void authAsUser(String username,String password){
       Selenide.open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);",
                RequestSpecs.getUserAuthHeader(username,password));
    }

    public  static void authUser (CreateUserRequest createUserRequest){
        authAsUser(createUserRequest.getUsername(),createUserRequest.getPassword());
    }

    protected <T extends BaseElement> List<T> generatePageElements(ElementsCollection elementsCollection, Function<SelenideElement,T> constructor){
        return  elementsCollection.stream().map(constructor).collect(Collectors.toList());
    }


}
