package common.extensions;

import com.codeborne.selenide.Configuration;
import common.annotations.Browsers;
import config_lesson.Config;
import org.junit.jupiter.api.extension.ConditionEvaluationResult;
import org.junit.jupiter.api.extension.ExecutionCondition;
import org.junit.jupiter.api.extension.ExtensionContext;

import java.util.Arrays;

public class BrowserMatchExtension implements ExecutionCondition {
    @Override
    public ConditionEvaluationResult evaluateExecutionCondition(ExtensionContext extensionContext) {
        Browsers annotation = extensionContext.getElement()
                .map(el ->el.getAnnotation(Browsers.class))
                .orElse(null);
        if (annotation ==null){
            return  ConditionEvaluationResult.enabled("Нет ограничений к браузеру");
        }

        String currentBrowsers = Configuration.browser;

        boolean matches = Arrays.stream(annotation.value())
                .anyMatch(browser -> browser.equals(currentBrowsers));

        if (matches){
            return  ConditionEvaluationResult.enabled("Текущий браузер удовлетворяет условию: "
            + currentBrowsers);}
        { return  ConditionEvaluationResult.disabled("Тест пропущен , так как текущий браузер: "
                + currentBrowsers+" не находится в списке допустимых браузеров для теста: "+ Arrays.toString(annotation.value()));

        }
    }
}
