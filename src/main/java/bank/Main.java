package bank;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


         Statement statement1 = new Statement();
         Account account1 = new Account(statement1);

         Amount cantidadADepositar = Amount.amountOf(1000);
         Amount cantidadARetirar = Amount.amountOf(500);
         Amount cantidadADepositar1 = Amount.amountOf(1000);
         Amount cantidadATransferir = Amount.amountOf(200);

         /*
         Date fechaDeAhora = new Date(123,3,10);
         Date fechaDeAhora2 = new Date(123,3,11);
         Date fechaDeAhora3 = new Date(123,3,12);
*/

         account1.deposit(cantidadADepositar,LocalDate.now());
         account1.withdrawal(cantidadARetirar,LocalDate.now());
         account1.deposit(cantidadADepositar1,LocalDate.now());

         Statement statement2 = new Statement();
         Account account2 = new Account(statement2);

         account1.transfer(cantidadATransferir,LocalDate.now(),account2);

         System.out.println("Estado de cuenta 1");
         account1.printStatement(System.out);

         System.out.println("");
         System.out.println("Estado de cuenta 2");
         account2.printStatement(System.out);


    }
}
