package practice_api_senior.requests.steps;

import database.Condition;
import database.DBRequest;
import practice_middle.dao.AccountDao;
import practice_middle.dao.Table;
import practice_middle.dao.TransactionDao;
import practice_middle.dao.UserDao;

public class DataBaseSteps {

    public  static UserDao getUserByUserId(int userId){
        return  DBRequest.builder()
                .requestType(DBRequest.RequestType.SELECT)
                .table(Table.CUSTOMERS.getTable())
                .where(Condition.equalTo("id", userId))
                .build()
                .extractAs(UserDao.class);
    }

    public  static AccountDao getAccountByAccountNumber (String accountNumber){
        return DBRequest.builder()
                .requestType(DBRequest.RequestType.SELECT)
                .table(Table.ACCOUNTS.getTable())
                .where(Condition.equalTo("account_number", accountNumber))
                .build()
                .extractAs(AccountDao.class);
    }

    public  static TransactionDao getTransactionByAccountId(long accountId){
       return   DBRequest.builder()
                .requestType(DBRequest.RequestType.SELECT)
                .table(Table.ACCOUNTS.getTable())
                .where(Condition.equalTo("account_id", accountId))
                .build()
                .extractAs(TransactionDao.class);
    }
}
