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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UnsuccessfulDepositTest {
    @BeforeAll
    public static void setUpRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    private final static String ERROR_MESSAGE = "Deposit amount must be at least 0.01";

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "-10.9"})
    public void successDepositIntoYourAccount(String balance) {
        AccountInfo account = CreateNewAccount.newUserAccountWithTokenAndAccountIdUnique();
        String accountId = account.accountId;
        String token = account.token;

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
                .post("http://localhost:4111/api/v1/accounts/deposit")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(Matchers.equalTo(ERROR_MESSAGE));

        List<Map<String,Object>> transactions = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", token)
                .pathParams("accountId", accountId)
                .when()
                .get("http://localhost:4111/api/v1/accounts/{accountId}/transactions")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(List.class);

        assert transactions.isEmpty();


    }


}
