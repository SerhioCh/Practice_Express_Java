package ui_middle.pages_middle;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.Customer;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferPage extends BasePage<TransferPage> {

    SelenideElement recipientName = $(Selectors.byAttribute("placeholder", "Enter recipient name"));
    SelenideElement recipientAccountNumber = $(Selectors.byAttribute("placeholder", "Enter recipient account number"));
    SelenideElement confirmCheckBox = $("#confirmCheck");
    SelenideElement buttonTransfer = $$("button").findBy(text("Send Transfer"));


    @Override
    public String url() {
        return "/transfer";
    }

    public  TransferPage addTransfer  (AccountUserResponse account1,AccountUserResponse account2,
                                       Customer customer, String amount,boolean checkBox){
        selectAccount.selectOptionContainingText(account1.getAccountNumber());
        recipientName.setValue(customer.getName());
        recipientAccountNumber.setValue(account2.getAccountNumber());
        enterAmount.setValue(amount);
        confirmCheckBox.setSelected(checkBox);
        buttonTransfer.click();
        return this;
    }

    public  TransferPage fillingInAllField  (AccountUserResponse account1,AccountUserResponse account2,
                                       Customer customer, String amount,boolean checkBox){
        selectAccount.selectOptionContainingText(account1.getAccountNumber());
        recipientName.setValue(customer.getName());
        recipientAccountNumber.setValue(account2.getAccountNumber());
        enterAmount.setValue(amount);
        confirmCheckBox.setSelected(checkBox);
        return this;
    }

    public TransferPage selectAccount (AccountUserResponse accountFrom){
        selectAccount.selectOptionContainingText(accountFrom.getAccountNumber());
        return  this;
    }

    public  TransferPage clearSelectAccount(String accountId){
        selectAccount.selectOptionContainingText(accountId);
        return this;
    }
    public  TransferPage enterRecipientAccount(String accountId){
        recipientAccountNumber.setValue(accountId);
        return  this;
    }
    public  TransferPage clearRecipientAccount(){
        recipientAccountNumber.clear();
        return  this;
    }

    public  TransferPage enterAmount (String amount){
        enterAmount.setValue(amount);
        return  this;
    }
    public  TransferPage clearAmount (){
        enterAmount.clear();
        return  this;
    }

    public  TransferPage setConfirmCheckBox (boolean value){
        confirmCheckBox.setSelected(value);
        return  this;
    }
    public  TransferPage clickSend(){
        buttonTransfer.click();
        return  this;
    }
}
