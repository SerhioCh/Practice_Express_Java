package practice_api_senior.requests.steps;

import lesson_api_middle.models_lesson.CreateAccountResponse;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_middle.models.AccountUserResponse;
import practice_middle.models.AddDepositUserAccountRequest;
import practice_middle.requests.CreateAccountRequester;
import practice_middle.requests.UserAddDepositRequester;
import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;

public class UserSteps {
    public static AccountUserResponse createAccountForUser(String username, String password) {
        return new ValidatedCrudRequester<AccountUserResponse>(
                RequestSpecs.userAuthSpec(username, password),
                Endpoint.ACCOUNTS,
                ResponseSpecs.entityWasCreated()
        ).post(null);
    }

    public static void addDepositForAccount(long accountId, BigDecimal balance, String username, String password) {
        AddDepositUserAccountRequest addDep = AddDepositUserAccountRequest.builder()
                .id(accountId)
                .balance(balance)
                .build();
        new CrudRequester(RequestSpecs.userAuthSpec(username, password),Endpoint.DEPOSIT,ResponseSpecs.requestReturnsOK())
                .post(addDep);
    }

}
