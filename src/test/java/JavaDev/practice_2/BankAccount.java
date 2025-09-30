package JavaDev.practice_2;

public class BankAccount {
    String owner;
    double balance;
    BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
    }
    String getOwner () {
        return  this.owner;
    }
    void setOwner(String owner){
        this.owner = owner;
    }

    double deposit(double dep){
        return balance+=dep;
    }
    double withdraw(double wd){
        return balance-=wd;
    }

    void printBalance(){
        System.out.println(balance);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("Lexa",2000);
        acc1.deposit(1500);
        acc1.printBalance();
        acc1.withdraw(500);
        acc1.printBalance();

    }
}
