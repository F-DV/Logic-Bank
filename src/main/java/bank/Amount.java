package bank;

import java.text.DecimalFormat;

/**
 * Operaciones con la cantidad
 */
public class Amount {

    private DecimalFormat decimalFormat = new DecimalFormat("#.00");
    private int value;

    public Amount(int value) {
        this.value = value;
    }

    //Crea un nuevo objeto de Amount
    public static Amount amountOf(int value){
        return new Amount(value);
    }

    //Sumar al Amount
    public Amount plus(Amount otheAmount){
        return amountOf(this.value + otheAmount.value);
    }

    // Restar al Amount
    public Amount minus(Amount otherAmount){
        return amountOf(this.value - otherAmount.value);
    }

    //Retorna verdadero si el Amount es mas grande que el otherAmount ingresado
    public boolean isGreaterThan(Amount otherAmount){
        return this.value > otherAmount.value;
    }

    //retorna un nuevo objeto del Amount pero en valor absoluto
    public Amount absoluteValue(){
        return amountOf(Math.abs(value));
    }

    //Representa el valor en formato de dinero
    public String moneyRepresentation(){
        return decimalFormat.format(value);
    }

    //Retorna un nuevo objeto de Amount pero en negativo
    public Amount negative(){
        return amountOf(-value);
    }

}
