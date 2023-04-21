package bank;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Transaction {

    private static final String DATE_FORMAT = "dd-MM-yyyy";
    private static final String EMPTY_VALUE = "          ";

    private SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

    private Amount amount;
    private Date date;
    private TypeTransaction typeTransaction;


    public Transaction(Amount value,Date date) {
        this.amount = value;
        this.date = date;
    }

    public Transaction(Amount amount, Date date, TypeTransaction typeTransaction) {
        this.amount = amount;
        this.date = date;
        this.typeTransaction = typeTransaction;
    }

    //Balance despues de la transacción
    public Amount balanceAfterTransaction(Amount currentBalance, TypeTransaction typeTransaction){

        if(typeTransaction == TypeTransaction.DEPOSIT){
            return currentBalance.plus(this.amount);
        }

        return  currentBalance.minus(this.amount);
    }

    //Construye la transaccion en un string para imprimir
    public void printTo(PrintStream printer,Amount currentBalance){

        StringBuilder builder = new StringBuilder();

        addDateTo(builder); // añade la fecha
        addCurrentBalance(builder,currentBalance); // agrega el valor
        addTypeOfTransaction(builder,typeTransaction); //Agrega el tipo de transacción

        printer.println(builder);



    }

    //1) agrega la fecha a la transaccion
    private void addDateTo(StringBuilder builder){
        builder.append(sdf.format(date));
        builder.append(" |");
    }

    //2) agrega el valor
    private void addValueTo(StringBuilder builder){

        builder.append(valueToString())
                .append("|");

    }

    //convierte el valor a valor absoluto, luego lo convierte en representacion en dinero y lo retorna en un string
    private String valueToString(){
        String stringValue = " " + amount.absoluteValue().moneyRepresentation();

        return stringValue;
    }

    //Agrega el balance
    private void addCurrentBalance(StringBuilder builder, Amount currentBalance){
        builder.append("| ")
                .append(currentBalance.moneyRepresentation());
    }

    private void addTypeOfTransaction(StringBuilder builder,TypeTransaction typeTransaction){
        builder.append("   |  ")
                .append(typeTransaction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(sdf, that.sdf) && Objects.equals(amount, that.amount) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sdf, amount, date);
    }
}
