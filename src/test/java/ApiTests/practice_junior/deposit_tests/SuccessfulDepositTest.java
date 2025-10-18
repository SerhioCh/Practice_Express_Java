package ApiTests.practice_junior.deposit_tests;

import ApiTests.practice_junior.helpers.AccountInfo;
import ApiTests.practice_junior.helpers.CreateNewAccount;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class SuccessfulDepositTest {
    @BeforeAll
    public static void setUpRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0.01", "4999.9", "5000"})
    public void successDepositIntoYourAccount(String balance) {
        AccountInfo account = CreateNewAccount.newUserAccountWithTokenNonUnique();
        String accountId = account.accountId;
        String token = account.token;

        String bodyAccount = String.format("""
                {
                  "id": %s,
                  "balance": %s
                }
                """, accountId, balance);

        BigDecimal expected = new BigDecimal(balance);

        BigDecimal actualBalance = new BigDecimal(
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .header("Authorization", token)
                        .body(bodyAccount)
                        .when()
                        .post("http://localhost:4111/api/v1/accounts/deposit")
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .path("balance").toString()
        );

        assert expected.compareTo(actualBalance) == 0;
    }

}