package ApiTests.practice_middle.helpers;

import practice_middle.generator.RandomData;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.UserRoles;
import practice_middle.requests.AdminCreateUserRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class TestUserManager {
    private static String username;
    private static String password;

    public static String getUsername() {
        if (username == null) {
            createUser();
        }
        return username;
    }

    public static String getPassword() {
        if (password == null) {
            createUser();
        }
        return password;
    }

    private static void createUser() {
        username = RandomData.getUserName();
        password = RandomData.getUserPassword();

        CreateUserRequest userRequest = CreateUserRequest.builder()
                .username(username)
                .password(password)
                .role(UserRoles.USER.toString())
                .build();

        new AdminCreateUserRequester(RequestSpecs.adminAuthSpec(), ResponseSpecs.ignoreErrors())
                .post(userRequest);

    }

    public static CreateUserRequest createTemporaryUser() {
        String temporaryUsername = RandomData.getUserName();
        String temporaryPassword = RandomData.getUserPassword();

        CreateUserRequest userRequest = CreateUserRequest.builder()
                .username(temporaryUsername)
                .password(temporaryPassword)
                .role(UserRoles.USER.toString())
                .build();
        new AdminCreateUserRequester(RequestSpecs.adminAuthSpec(), ResponseSpecs.entityWasCreated())
                .post(userRequest);

        return userRequest;
    }
}
