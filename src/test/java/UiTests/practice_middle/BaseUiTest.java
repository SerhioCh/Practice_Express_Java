package UiTests.practice_middle;

import ApiTests.practice_middle.BaseTest;
import com.codeborne.selenide.Configuration;
import config_lesson.Config;
import org.junit.jupiter.api.BeforeAll;
import practice_middle.models.CreateUserRequest;
import practice_middle.specs.RequestSpecs;

import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.open;

public class BaseUiTest extends BaseTest {
    @BeforeAll
    public  static  void setupSelenoid(){
        Configuration.remote = Config.getProperty("uiRemote");
        Configuration.baseUrl = Config.getProperty("uiBaseUrl");
        Configuration.browser = Config.getProperty("browser");
        Configuration.browserSize = Config.getProperty("browserSize");

        Configuration.browserCapabilities.setCapability("selenoid:options",
                Map.of("enableVNC",true,"enableLog",true));
    }


    public  void authAsUser(String username,String password){
        open("/");
        executeJavaScript("localStorage.setItem('authToken', arguments[0]);",
                RequestSpecs.getUserAuthHeader(username,password));
    }

    public  void authUser (CreateUserRequest createUserRequest){
        authAsUser(createUserRequest.getUsername(),createUserRequest.getPassword());
    }
}
