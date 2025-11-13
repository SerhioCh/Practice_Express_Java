package ui_middle.pages_middle.ui_elements_senior;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

@Getter
public class AcсountOption extends BaseElement {
    private String label;

    public AcсountOption(SelenideElement element) {
        super(element);
        this.label = element.getText();
    }
}