package service;

import model.Coin;
import model.Note;

public class Payment {
    private double totalPayment;

    public Payment() {
        this.totalPayment = 0.0;
    }

    void addCoin(Coin coin) {
        totalPayment += coin.getValue();
    }

    void addNote(Note note) {
        totalPayment += note.getValue();
    }

    void resetPayment() {
        this.totalPayment = 0.0;
    }

    public double getTotalPayment() {
        return totalPayment;
    }
}
