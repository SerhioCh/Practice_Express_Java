package practice_middle.dao;

import lombok.Getter;

@Getter
public enum Table {
    CUSTOMERS("customers"),
    ACCOUNTS("accounts"),
    TRANSACTIONS("transactions");

    Table(String table) {
        this.table = table;
    }

    private final String table;
}
