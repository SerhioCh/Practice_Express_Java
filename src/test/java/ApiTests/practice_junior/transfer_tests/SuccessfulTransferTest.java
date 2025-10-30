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

public class SuccessfulTransferTest {
    @BeforeAll
    public static void setUpRestAssured() {
        RestAssured.filters(
                List.of(new RequestLoggingFilter(),
                        new ResponseLoggingFilter()));
    }

    @ValueSource(strings = {"0.01", "10000"})
    @ParameterizedTest
    public void successTransferForYourAccount(String amount) {
        AccountInfo accountInfo = CreateNewAccount.newUserAccountWithTokenAndAccountIdUnique();
        AccountDeposit.depositForAccount(accountInfo.accountId, "5000", accountInfo.token);
        AccountDeposit.depositForAccount(accountInfo.accountId, "5000", accountInfo.token);
        AccountInfo accountInfo1 = CreateNewAccount.newUserAccountWithTokenUniqueAndAccountIdNonUnique();
        String bodyTransfer = String.format("""
                {
                  "senderAccountId": %s,
                  "receiverAccountId": %s,
                  "amount": %s
                }
                """, accountInfo.accountId, accountInfo1.accountId, amount);
        BigDecimal expected = new BigDecimal(amount);

        BigDecimal actualBalance = new BigDecimal(
                given()
                        .contentType(ContentType.JSON)
                        .accept(ContentType.JSON)
                        .body(bodyTransfer)
                        .header("Authorization", accountInfo.token)
                        .when()
                        .post("http://localhost:4111/api/v1/accounts/transfer")
                        .then()
                        .body("message", Matchers.equalTo("Transfer successful"))
                        .statusCode(HttpStatus.SC_OK)
                        .extract()
                        .path("amount").toString());


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
        Number amountNumber = (Number) transactions.get(0).get("amount");
        BigDecimal amountDeposit = BigDecimal.valueOf(amountNumber.doubleValue());

        assert expected.compareTo(actualBalance) == 0;
        assert actualBalance.compareTo(amountDeposit) == 0;
    }


}