package ApiTests.practice_junior.helpers;

import io.restassured.http.ContentType;

import java.math.BigDecimal;

import static io.restassured.RestAssured.given;

public class AccountDeposit {
    public static void depositForAccount(String accountId, String balance, String token) {
        String bodyAccount = String.format("""
                {
                  "id": %s,
                  "balance": %s
                }
                """, accountId, balance);
        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .body(bodyAccount)
                .when()
                .post("http://localhost:4111/api/v1/accounts/deposit");

    }
}
