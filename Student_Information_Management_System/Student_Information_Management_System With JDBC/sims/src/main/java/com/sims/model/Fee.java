package com.sims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Fee {

    private double amount = 0.0;

    @Column(name = "fee_status")
    private String feeStatus = "Not Paid";

    // original logic
    public void payFee(double amt) {
        this.amount = amt;
        this.feeStatus = "Paid";
    }

    public String getStatus() {
        return feeStatus;
    }

    public void display() {
        System.out.println("Fee: " + amount + " | Status: " + feeStatus);
    }
}
