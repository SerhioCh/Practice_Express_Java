package ApiTests.fraud_test;

import ApiTests.BaseTest;
import common.annotations.FraudCheckMock;
import common.storage.SessionStorage;
import org.junit.jupiter.api.Test;
import practice_api_senior.requests.steps.AdminSteps;
import practice_api_senior.requests.steps.UserSteps;
import practice_middle.generator.RandomData;
import practice_middle.models.*;

import java.math.BigDecimal;

public class TransferWithFraudCheck extends BaseTest {
    @Test
    @FraudCheckMock(
            status = "SUCCESS",
            decision = "APPROVED",
            riskScore = 0.2,
            reason = "Low risk transaction",
            requiresManualReview = false,
            additionalVerificationRequired = false
    )
    public void testTransferWithFraudCheck() {
        final String ACCOUNT_NAME = RandomData.getName();
        final String DEPOSIT_AMOUNT = RandomData.getDeposit();
        CreateUserRequest request = AdminSteps.createConstantUser();
        long accountId1 = UserSteps.createAccountForUser(request.getUsername(), request.getPassword()).getId();
        UserSteps.addDepositForAccount(accountId1, new BigDecimal("5000"), request.getUsername(), request.getPassword());
        long accountId2 = UserSteps.createAccountForUser(request.getUsername(), request.getPassword()).getId();

        TransferResponse transferResponse = UserSteps.transferWithFraudCheck(
                accountId1,
                accountId2,
                new BigDecimal("5000"),
                request
        );

        TransferResponse expectedResponse = TransferResponse.builder()
                .status("APPROVED")
                .message("Transfer approved and processed immediately")
                .amount(new BigDecimal("5000"))
                .senderAccountId(accountId1)
                .receiverAccountId(accountId2)
                .fraudRiskScore(0.2)
                .fraudReason("Low risk transaction")
                .requiresManualReview(false)
                .requiresVerification(false)
                .build();


        softly.assertThat(expectedResponse.getStatus()).isEqualTo("APPROVED");
        softly.assertThat(transferResponse.getAmount()).isEqualByComparingTo(expectedResponse.getAmount());
    }
}