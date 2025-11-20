package practice_api_senior.requests.skelethon;

import lombok.AllArgsConstructor;
import lombok.Getter;
import practice_middle.models.*;

@Getter
@AllArgsConstructor
public enum Endpoint {
    ADMIN_USER(
            "/admin/users",
            CreateUserRequest.class,
            CreateUserResponse.class
    ),
    USER_DELETE(
            "/admin/users/{id}",
            BaseModel.class,
            BaseModel.class
    ),
    LOGIN(
            "/auth/login",
            LoginUserRequest.class,
            LoginUserResponse.class
    ),
    ACCOUNTS(
            "/accounts",
            BaseModel.class,
            AccountUserResponse.class
    ),
    ACCOUNTS_DELETE(
            "/accounts/{accountId}",
            BaseModel.class,
            DeleteAccountResponse.class
    ),
    TRANSFER(
            "/accounts/transfer",
            CreateTransferRequest.class,
            CreateTransferResponse.class
    ),
    DEPOSIT(
            "/accounts/deposit",
            AddDepositUserAccountRequest.class,
            AccountUserResponse.class
    ),
    UPDATE_CUSTOMER(
            "/customer/profile",
            UpdateCustomerProfileRequest.class,
            UpdateCustomerProfileResponse.class
    ),
    GET_ACCOUNT_TRANSACTIONS(
            "/accounts/{accountId}/transactions",
            BaseModel.class,
            Transaction.class
    ),
    GET_CUSTOMER_PROFILE(
            "/customer/profile",
            BaseModel.class,
            Customer.class
    ),
    TRANSFER_WITH_FRAUD_CHECK(
            "/accounts/transfer-with-fraud-check",
            TransferRequest.class,
            TransferResponse.class
    );


    private final String url;
    private final Class<? extends BaseModel> requestModel;
    private final Class<? extends BaseModel> responseModel;

}
