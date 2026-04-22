package sims;

import java.io.Serializable;

public class Fee implements Serializable {
    double amount;
    String status = "Not Paid";

    public void payFee(double amt) {
        this.amount = amt;
        this.status = "Paid";
    }

    public void display() {
        System.out.println("Fee: " + amount + " | Status: " + status);
    }
}