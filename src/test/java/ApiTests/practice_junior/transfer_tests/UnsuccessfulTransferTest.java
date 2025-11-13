package ApiTests.practice_junior.transfer_tests;

import ApiTests.practice_junior.helpers.AccountDeposit;
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
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UnsuccessfulTransferTest {
    @BeforeAll
    public static void setUpRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    @ValueSource(strings = {"0", "-1"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccount(String amount) {
        AccountInfo accountInfo = CreateNewAccount.newUserAccountWithTokenAndAccountIdUnique();
        AccountDeposit.depositForAccount(accountInfo.accountId, "5000", accountInfo.token);
        AccountInfo accountInfo1 = CreateNewAccount.newUserAccountWithTokenUniqueAndAccountIdNonUnique();
        String bodyTransfer = String.format("""
                {
                  "senderAccountId": %s,
                  "receiverAccountId": %s,
                  "amount": %s
                }
                """, accountInfo.accountId, accountInfo1.accountId, amount);


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyTransfer)
                .header("Authorization", accountInfo.token)
                .when()
                .post("http://localhost:4111/api/v1/accounts/transfer")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(Matchers.equalTo("Transfer amount must be at least 0.01"));

        List<Map<String,Object>> transactions = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", accountInfo.token)
                .pathParams("accountId", accountInfo1.accountId)
                .when()
                .get("http://localhost:4111/api/v1/accounts/{accountId}/transactions")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(List.class);

        assert transactions.isEmpty();

    }

    @ValueSource(strings = {"10000.1", "500000"})
    @ParameterizedTest
    public void unsuccessTransferForYourAccountMoreTenThousand(String amount) {
        AccountInfo accountInfo = CreateNewAccount.newUserAccountWithTokenAndAccountIdUnique();
        AccountDeposit.depositForAccount(accountInfo.accountId, "5000", accountInfo.token);
        AccountInfo accountInfo1 = CreateNewAccount.newUserAccountWithTokenUniqueAndAccountIdNonUnique();
        String bodyTransfer = String.format("""
                {
                  "senderAccountId": %s,
                  "receiverAccountId": %s,
                  "amount": %s
                }
                """, accountInfo.accountId, accountInfo1.accountId, amount);


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyTransfer)
                .header("Authorization", accountInfo.token)
                .when()
                .post("http://localhost:4111/api/v1/accounts/transfer")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(Matchers.equalTo("Transfer amount cannot exceed 10000"));

        List<Map<String,Object>> transactions = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", accountInfo.token)
                .pathParams("accountId", accountInfo1.accountId)
                .when()
                .get("http://localhost:4111/api/v1/accounts/{accountId}/transactions")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(List.class);

        assert transactions.isEmpty();

    }

    @Test
    public void unsuccessTransferForYourAccountMoreThanInTheAccount() {
        AccountInfo accountInfo = CreateNewAccount.newUserAccountWithTokenUniqueAndAccountIdNonUnique();
        AccountDeposit.depositForAccount(accountInfo.accountId, "5000", accountInfo.token);
        AccountInfo accountInfo1 = CreateNewAccount.newUserAccountWithTokenUniqueAndAccountIdNonUnique();
        String bodyTransfer = String.format("""
                {
                  "senderAccountId": %s,
                  "receiverAccountId": %s,
                  "amount": 5001
                }
                """, accountInfo.accountId, accountInfo1.accountId);


        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(bodyTransfer)
                .header("Authorization", accountInfo.token)
                .when()
                .post("http://localhost:4111/api/v1/accounts/transfer")
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body(Matchers.equalTo("Invalid transfer: insufficient funds or invalid accounts"));

        List<Map<String,Object>> transactions = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", accountInfo.token)
                .pathParams("accountId", accountInfo1.accountId)
                .when()
                .get("http://localhost:4111/api/v1/accounts/{accountId}/transactions")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .as(List.class);

        assert transactions.isEmpty();

    }

}
