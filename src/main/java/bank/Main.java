package bank;

public class Main {

    public static void main(String[] args) {

        User felipe = new User("10366598452","Felipe");
        felipe.getAccount().deposit(1000);

        User andres = new User("1036650214","Andres");
        andres.getAccount().deposit(2000);


        System.out.println("Amount Felipe: " + felipe.getAccount().getAmount());
        System.out.println("Amount Andres: " + andres.getAccount().getAmount());

        System.out.println("Andres le hace una transferencia a felipe de 500");
        System.out.println(andres.getAccount().transfer(2500,felipe.getAccount()));

        System.out.println("Amount Felipe: " + felipe.getAccount().getAmount());
        System.out.println("Amount Andres: " + andres.getAccount().getAmount());

    }
}
