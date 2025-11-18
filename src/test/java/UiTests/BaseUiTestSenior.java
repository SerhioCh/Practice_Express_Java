package UiTests;

import ApiTests.BaseTest;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import common.extensions.BrowserMatchExtension;
import common.extensions.TimingExtension;
import common.extensions.UserSessionExtension;
import config_lesson.Config;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.Isolated;

import java.sql.Time;
import java.util.Map;

import static com.codeborne.selenide.Selenide.open;
@ExtendWith(UserSessionExtension.class)
@ExtendWith(BrowserMatchExtension.class)
@ExtendWith({TimingExtension.class})
public class BaseUiTestSenior extends BaseTest {
    @BeforeAll
    public  static  void setupSelenoid(){
        Configuration.remote = Config.getProperty("uiRemote");
        Configuration.baseUrl = Config.getProperty("uiBaseUrl");
        Configuration.browser = Config.getProperty("browser");
        Configuration.browserSize = Config.getProperty("browserSize");
        Configuration.headless = true;

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.of("enableVNC",true,"enableLog",true));
    }
    @AfterAll
    static void tearDown() {
        Selenide.closeWebDriver();
    }



}
