package sims;

public class Fee {
    int feeId;
    double amount;
    String status;

    public void payFee(double amt) {
        this.amount = amt;
        this.status = "Paid";
    }

    public void viewFee() {
        System.out.println("Amount: " + amount + ", Status: " + status);
    }
}