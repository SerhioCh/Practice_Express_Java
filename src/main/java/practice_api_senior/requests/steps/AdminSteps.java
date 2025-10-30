package practice_api_senior.requests.steps;

import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_middle.generator.RandomData;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.UserRoles;
import practice_middle.requests.AdminCreateUserRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

public class AdminSteps {
    private static CreateUserRequest constantUser;

    public static CreateUserRequest createConstantUser() {
        if (constantUser == null) {
            String username = RandomData.getUserName();
            String password = RandomData.getUserPassword();

            constantUser = CreateUserRequest.builder()
                    .username(username)
                    .password(password)
                    .role(UserRoles.USER.toString())
                    .build();

            new CrudRequester(RequestSpecs.adminAuthSpec(), Endpoint.ADMIN_USER,ResponseSpecs.ignoreErrors())
                    .post(constantUser);
        }
        return constantUser;
    }

    public static CreateUserRequest createTemporaryUser() {
        String temporaryUsername = RandomData.getUserName();
        String temporaryPassword = RandomData.getUserPassword();

        CreateUserRequest userRequest = CreateUserRequest.builder()
                .username(temporaryUsername)
                .password(temporaryPassword)
                .role(UserRoles.USER.toString())
                .build();
        new CrudRequester(RequestSpecs.adminAuthSpec(), Endpoint.ADMIN_USER,ResponseSpecs.ignoreErrors())
                .post(userRequest);

        return userRequest;
    }
}

