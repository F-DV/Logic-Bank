package bank;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Account {

    private String number;
    private String userName;
    private Double Amount;
    private LinkedList<Transaction> transactions = new LinkedList<>();

    public Account(String number, String userName, Double amount) {
        this.number = number;
        this.userName = userName;
        Amount = amount;
    }

    //Deposito
    public Double deposit(double amount){
        this.Amount = this.Amount + amount;

        return this.Amount;
    }
    //Retiro
    public Double withdrawal(double amount){
        if (amount > this.Amount){
            return null;
        }
        return this.Amount = this.Amount - amount;
    }
    //Transferencia
    public Boolean transfer(double money, Account account){
        if(money > this.Amount){
            return false;
        }
        this.Amount = this.Amount - money;
        account.deposit(money);
        return true;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getAmount() {
        return Amount;
    }

    public void setAmount(Double amount) {
        Amount = amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "number='" + number + '\'' +
                ", userName='" + userName + '\'' +
                ", Amount=" + Amount +
                '}';
    }
}
