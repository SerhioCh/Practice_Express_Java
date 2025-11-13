package ui_middle.pages_middle.ui_elements_senior;

import com.codeborne.selenide.SelenideElement;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AcсountOption extends BaseElement {
    private String label;

    public AcсountOption(SelenideElement element) {
        super(element);
        this.label = element.getText();
    }
}