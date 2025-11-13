package ui_middle.pages_middle;

import lombok.Getter;

@Getter
public enum BankAlerts {
    INVALID_AMOUNT_DEPOSIT("❌ Please enter a valid amount."),
    ACCOUNT_NOT_SELECTED("❌ Please select an account."),
    INVALID_TRANSFER_AMOUNT_GREATER_THAN_ZERO_POINT_ONE("❌ Error: Transfer amount must be at least 0.01"),
    INVALID_TRANSFER_AMOUNT_MORE_THAN_TEN_THOUSAND("❌ Error: Transfer amount cannot exceed 10000"),
    TRANSFER_EMPTY_ALL_FIELDS("❌ Please fill all fields and confirm."),
    INVALID_TRANSFER_INVALID_ACCOUNT_NUMBER("❌ No user found with this account number."),
    INVALID_TRANSFER_OVERDRAFT("❌ Error: Invalid transfer: insufficient funds or invalid accounts"),
    SUCCESS_RENAME_PROFILE("✅ Name updated successfully!"),
    INVALID_RENAME_SAME_NAME("⚠\uFE0F New name is the same as the current one."),
    INVALID_RENAME_CONTAINS_ONE_WORD("Name must contain two words with letters only"),
    INVALID_RENAME_EMPTY_FIELD("❌ Please enter a valid name.");

    private  final String message;
    BankAlerts(String message) {
        this.message = message;
    }
}
