package common.extensions;

import common.annotations.UserSession;
import common.storage.SessionStorage;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import practice_api_senior.requests.steps.AdminSteps;
import practice_middle.models.CreateUserRequest;
import ui_middle.pages_middle.BasePage;

import java.util.LinkedList;
import java.util.List;

public class UserSessionExtension implements BeforeEachCallback, AfterEachCallback {

    public  void beforeEach (ExtensionContext extensionContext) throws Exception{
        UserSession annotation = extensionContext.getRequiredTestMethod().getAnnotation(UserSession.class);
        if (annotation != null){
            int userCount = annotation.value();
            SessionStorage.clear();

            List<CreateUserRequest> users = new LinkedList<>();

            for (int i =0; i<userCount;i++){
                CreateUserRequest user = AdminSteps.createTemporaryUser();
                users.add(user);
            }
SessionStorage.addUsers(users);
            int authAsUser = annotation.auth();
            BasePage.authUser(SessionStorage.getUser(authAsUser));
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        try {
            for (int i = 1; i <= SessionStorage.userCount(); i++) {
                var user = SessionStorage.getUser(i);
                var userSteps = SessionStorage.getSteps(i);

                userSteps.deleteAccounts(user);

                Long userId = AdminSteps.getUserInfoId(user.getUsername());
                if (userId != null) {
                    AdminSteps.deleteUser(userId);
                } else {
                    System.out.println("[afterEach] Пользователь не найден: " + user.getUsername());
                }
            }
        } catch (Exception e) {
            System.err.println("[afterEach] Ошибка при очистке: " + e.getMessage());
        } finally {
            SessionStorage.clear();
        }
    }
}
