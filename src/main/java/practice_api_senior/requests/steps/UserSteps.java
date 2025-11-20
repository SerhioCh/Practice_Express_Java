package practice_api_senior.requests.steps;


import io.restassured.response.ValidatableResponse;
import practice_api_senior.requests.skelethon.Endpoint;
import practice_api_senior.requests.skelethon.requesters.CrudRequester;
import practice_api_senior.requests.skelethon.requesters.ValidatedCrudRequester;
import practice_middle.models.*;

import practice_middle.specs.RequestSpecs;
import practice_middle.specs.ResponseSpecs;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


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
                .accountId(accountId)
                .amount(balance)
                .build();
        new CrudRequester(RequestSpecs.userAuthSpec(username, password), Endpoint.DEPOSIT, ResponseSpecs.requestReturnsOK())
                .post(addDep);
    }

    public static Customer addNameForAccount(String name, String username, String password) {
        UpdateCustomerProfileRequest updateCustomerProfileRequest = UpdateCustomerProfileRequest.builder()
                .name(name)
                .build();

        UpdateCustomerProfileResponse updateCustomerProfileResponse = new ValidatedCrudRequester<UpdateCustomerProfileResponse>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.UPDATE_CUSTOMER, ResponseSpecs.requestReturnsOK())
                .update(updateCustomerProfileRequest);

        Customer customer = new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(username, password),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();

        return customer;
    }

    public static Transaction[] getAllTransaction(CreateUserRequest user, AccountUserResponse account) {
        return new CrudRequester(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_ACCOUNT_TRANSACTIONS, ResponseSpecs.requestReturnsOK())
                .get(account.getId())
                .extract().as(Transaction[].class);
    }

    public static Customer getCustomerProfile(CreateUserRequest user) {
        return new ValidatedCrudRequester<Customer>(RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                Endpoint.GET_CUSTOMER_PROFILE,
                ResponseSpecs.requestReturnsOK())
                .get();
    }

    public static void deleteAccounts(AccountUserResponse accountUserResponse, CreateUserRequest user) {
        List<CreateUserResponse> users = Arrays.asList(new CrudRequester(RequestSpecs.adminAuthSpec(), Endpoint.ADMIN_USER,
                ResponseSpecs.ignoreErrors())
                .get()
                .extract().as(CreateUserResponse[].class));

        List<Long> userAccountIds = users.stream()
                .filter(u -> u.getUsername().equals(user.getUsername()))
                .flatMap(u -> u.getAccounts().stream())
                .map(Account::getId)
                .collect(Collectors.toList());


        if (!userAccountIds.isEmpty()) {
            for (Long getId : userAccountIds) {
                new CrudRequester(
                        RequestSpecs.userAuthSpec(user.getUsername(), user.getPassword()),
                        Endpoint.ACCOUNTS_DELETE,
                        ResponseSpecs.requestReturnsOK()
                ).delete(getId);
            }
        }
    }
    public static TransferResponse transferWithFraudCheck(Long senderAccountId, Long receiverAccountId, BigDecimal amount, CreateUserRequest user) {

            TransferRequest transferRequest = TransferRequest.builder()
                    .senderAccountId(senderAccountId)
                    .receiverAccountId(receiverAccountId)
                    .amount(amount)
                    .description("Test transfer with fraud check")
                    .build();

            return new ValidatedCrudRequester<TransferResponse>(
                    RequestSpecs.userAuthSpec(user.getUsername(),user.getPassword()),
                    Endpoint.TRANSFER_WITH_FRAUD_CHECK,
                    ResponseSpecs.requestReturnsOK()).post(transferRequest);

    }
}
