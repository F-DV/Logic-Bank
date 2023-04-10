package bank;

public class User {

    private String id;
    private String name;
    private Account account;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        this.account = new Account(createNumberAccount(),name,0.0);

    }

    private String createNumberAccount(){

        String aleatoryAccounNumber = "";

        for(int i=0; i < 4; i++){
            int aleatoryNumber = (int) (Math.random()*(99-10+1)+10);

            aleatoryAccounNumber = aleatoryAccounNumber.concat(String.valueOf(aleatoryNumber));
        }

        return aleatoryAccounNumber;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
