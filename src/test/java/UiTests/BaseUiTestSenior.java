package UiTests;

import ApiTests.BaseTest;
import com.codeborne.selenide.Configuration;
import common.extensions.BrowserMatchExtension;
import common.extensions.UserSessionExtension;
import config_lesson.Config;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
@ExtendWith(UserSessionExtension.class)
@ExtendWith(BrowserMatchExtension.class)
public class BaseUiTestSenior extends BaseTest {
    @BeforeAll
    public  static  void setupSelenoid(){
        Configuration.remote = Config.getProperty("uiRemote");
        Configuration.baseUrl = Config.getProperty("uiBaseUrl");
        Configuration.browser = Config.getProperty("browser");
        Configuration.browserSize = Config.getProperty("browserSize");

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.of("enableVNC",true,"enableLog",true));
    }


}
