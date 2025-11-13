package practice_api_senior.requests.steps;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_middle.generator.RandomData;
import practice_middle.models.CreateUserRequest;
import practice_middle.models.CreateUserResponse;
import practice_middle.models.UserRoles;
import practice_middle.requests.AdminCreateUserRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.util.Arrays;
import java.util.List;

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

    public  static Long getUserInfoId(String name){
        List <CreateUserResponse> users = Arrays.asList( new CrudRequester(RequestSpecs.adminAuthSpec(),Endpoint.ADMIN_USER,
        ResponseSpecs.ignoreErrors())
                .get()
                .extract().as(CreateUserResponse[].class));
       return   users.stream()
               .filter(u -> u.getUsername().equals(name))
               .map(CreateUserResponse::getId)
               .findFirst()
               .orElse(null);
    }


    public  static void deleteUser (long userId){
        ValidatableResponse response = new CrudRequester(RequestSpecs.adminAuthSpec(),
                Endpoint.USER_DELETE,ResponseSpecs.requestReturnsOK())
                .delete(userId);
    }
}

