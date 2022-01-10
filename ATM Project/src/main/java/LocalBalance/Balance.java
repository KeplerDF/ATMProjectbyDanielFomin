package LocalBalance;

import java.util.Arrays;

public class Balance {

    private int balance;
    private int [] notes = new int [4];

    public Balance() {
        balance = 1500;
        notes[0] = 10;
        notes[1] = 30;
        notes[2] = 30;
        notes[3] = 20;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }

    public int[] getNotes() {
        return notes;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "balance=" + balance +
                ", notes=" + Arrays.toString(notes) +
                '}';
    }
}
