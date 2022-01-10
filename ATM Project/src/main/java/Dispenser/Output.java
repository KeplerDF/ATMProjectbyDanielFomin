package Dispenser;

import java.util.Arrays;

public class Output {

    private int todispense;
    private int [] notes = new int[4];
    private boolean pinchecker;
    private int baseamount = 0;

    public boolean getChecker() {
        return pinchecker;
    }

    public void setChecker(boolean pinchecker) {
        this.pinchecker = pinchecker;
    }



    public int[] getNotes() {
        return notes;
    }

    public void setNotes(int[] notes) {
        this.notes = notes;
    }

    public int getTodispense() {
        return todispense;
    }

    public void setTodispense(int todispense) {
        this.todispense = todispense;
    }

    public Output() {
    }

    public Output(int todispense) {
        this.todispense = todispense;

    }

    public int getBaseamount() {
        return baseamount;
    }

    public void setBaseamount(int baseamount) {
        this.baseamount = baseamount;
    }

    @Override
    public String toString() {
        return "Output{" +
                "todispense=" + todispense +
                ", notes=" + Arrays.toString(notes) +
                ", pinchecker=" + pinchecker +
                ", baseamount=" + baseamount +
                '}';
    }
}
