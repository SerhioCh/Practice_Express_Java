package ApiTests.practice_junior.helpers;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class CreateNewAccount {
    private static final String PASSWORD = "Serega1!34";

    public static AccountInfo newUserAccountWithTokenAndAccountIdUnique() {
        if (UserSession.accountId != null && UserSession.token != null) {
            return new AccountInfo(UserSession.accountId, UserSession.token);
        }
        String name = "Username123";
        String password = PASSWORD;
        String auth = CreateNewUserToken.userAuthUnique(name, password);
        Integer id = given()
                .header("Authorization", auth)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("http://localhost:4111/api/v1/accounts")
                .then()
                .extract()
                .path("id");
        String accountId = String.valueOf(id);
        UserSession.username = name;
        UserSession.password = password;
        UserSession.token = auth;
        UserSession.accountId = accountId;
        return new AccountInfo(accountId, auth);
    }

    public static AccountInfo newUserAccountWithTokenNonUnique() {
        String token = CreateNewUserToken.userAuthNonUnique();

        Integer id = given()
                .header("Authorization", token)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("http://localhost:4111/api/v1/accounts")
                .then()
                .extract()
                .path("id");
        String accountId = String.valueOf(id);
        return new AccountInfo(accountId, token);
    }

    public static AccountInfo newUserAccountWithTokenUniqueAndAccountIdNonUnique() {
        String name = "Username123";
        String password = PASSWORD;
        String auth = CreateNewUserToken.userAuthUnique(name, password);
        Integer id = given()
                .header("Authorization", auth)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .post("http://localhost:4111/api/v1/accounts")
                .then()
                .extract()
                .path("id");
        String accountId = String.valueOf(id);
        return new AccountInfo(accountId, auth);
    }

}
