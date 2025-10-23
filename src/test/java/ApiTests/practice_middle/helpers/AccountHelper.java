package ApiTests.practice_middle.helpers;

import practice_middle.models.AccountUserResponse;
import practice_middle.models.AddDepositUserAccountRequest;
import practice_middle.requests.CreateAccountRequester;
import practice_middle.requests.UserAddDepositRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;

public class AccountHelper {

    public static AccountUserResponse createAccountForUser(String username, String password) {
        return new CreateAccountRequester(
                RequestSpecs.userAuthSpec(username, password),
                ResponseSpecs.entityWasCreated()
        ).post(null).extract().as(AccountUserResponse.class);
    }

    public static void addDepositForAccount(long accountId, BigDecimal balance, String username, String password) {
        AddDepositUserAccountRequest addDep = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(balance)
                .build();
        new UserAddDepositRequester(RequestSpecs.userAuthSpec(username, password), ResponseSpecs.requestReturnsOK())
                .post(addDep);
    }


}
