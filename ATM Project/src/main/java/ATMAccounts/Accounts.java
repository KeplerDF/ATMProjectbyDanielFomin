package ATMAccounts;

public class Accounts {

    private int mybalance;
    private int name;
    private int pin;
    private int overdraft;

    public int getMybalance() {
        return mybalance;
    }

    public void setMybalance(int mybalance) {
        this.mybalance = mybalance;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(int overdraft) {
        this.overdraft = overdraft;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Accounts() {

    }

    public Accounts(int balance,int name, int pin, int overdraft){
        this.mybalance = balance;
        this.name = name;
        this.pin = pin;
        this.overdraft = overdraft;

    }

    @Override
    public String toString() {
        return "Accounts{" +
                "mybalance=" + mybalance +
                ", name=" + name +
                ", pin=" + pin +
                ", overdraft=" + overdraft +
                '}';
    }
}
