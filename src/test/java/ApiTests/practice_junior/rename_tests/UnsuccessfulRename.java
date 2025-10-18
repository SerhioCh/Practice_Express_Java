package ApiTests.practice_junior.rename_tests;

import ApiTests.practice_junior.helpers.CreateNewUserToken;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UnsuccessfulRename {
    @BeforeAll
    public static void setUpRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    @ValueSource(strings = {"Jhon", "jhon 1smith", "jOn! sMi", "1 1", "$ ^"})
    @ParameterizedTest
    public void unsuccessRenameUser(String name) {
        String token = CreateNewUserToken.userAuthNonUnique();
        String bodyRename = String.format("""
                {
                  "name": "%s"
                }
                """, name);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body(bodyRename)
                .when()
                .put("http://localhost:4111/api/v1/customer/profile")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(Matchers.equalTo("Name must contain two words with letters only"));

    }


}
