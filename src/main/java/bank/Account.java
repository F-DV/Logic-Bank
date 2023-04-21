package bank;

import java.io.PrintStream;
import java.util.Date;


public class Account {

    private String number;
    private String userName;
    private Amount balance =Amount.amountOf(0);

    private Statement statement;


    public Account(Statement statement) {
        this.statement = statement;
    }

    //Deposito
    public void deposit(Amount value, Date date){

        recordTransaction(value,date,TypeTransaction.DEPOSIT);
    }

    //Retiro
    public void withdrawal(Amount value,Date date){

        recordTransaction(value, date,TypeTransaction.WITHDRAWAL);

    }

    //Transferencia
    public void transfer(Amount money,Date date, Account anotherAccount){
        anotherAccount.deposit(money,date);
        recordTransaction(money,date,TypeTransaction.TRANSFER);

    }

    //Imprime el estado de la cuenta
    public void printStatement(PrintStream printer){
        statement.printTo(printer);
    }

    //Guarda la transacción
    private void recordTransaction(Amount value, Date date, TypeTransaction typeTransaction){
        Transaction transaction = new Transaction(value,date,typeTransaction);

        Amount balanceAfterTransaction = transaction.balanceAfterTransaction(balance,typeTransaction);

        balance = balanceAfterTransaction;

        statement.addLineContaining(transaction, balanceAfterTransaction);
    }


}
