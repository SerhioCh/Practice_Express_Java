package ui_middle.pages_middle;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import common.utils.RetryUtils;
import org.assertj.core.api.SoftAssertions;
import practice_middle.models.AccountUserResponse;
import ui_middle.pages_middle.ui_elements_senior.AcсountOption;

import java.util.List;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DepositPage extends BasePage<DepositPage> {


    private SelenideElement buttonDeposit = $$("button").findBy(text("Deposit"));


    @Override

    public String url() {
        return "/deposit";
    }

    public  DepositPage addDeposit(AccountUserResponse account, String amount){
        selectAccount.selectOptionContainingText(account.getAccountNumber());
        enterAmount.setValue(amount);
        buttonDeposit.click();
        return  this;
    }
    public  DepositPage addDepositWithoutAccount(String amount){
        enterAmount.setValue(amount);
        buttonDeposit.click();
        return  this;
    }

    public List<AcсountOption> getAllAccounts(){
         ElementsCollection elementsCollection = $("select.form-control.account-selector").$$("option");
        return generatePageElements(elementsCollection,AcсountOption::new);
    }

    public AcсountOption  findAccountInSelect (String accountName){
     return RetryUtils.retry(
                () -> getAllAccounts().stream().filter(it -> it.getLabel().contains(accountName)).findAny().orElse(null),
                result -> result !=null,
                3,
                1000);

    }


}
