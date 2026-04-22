package com.sims.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Result {

    @Column(name = "result_status")
    private String resultStatus = "Pending";

    // original logic
    public void generateResult(Marks marks) {
        if (marks.getTotal() >= 50) {
            resultStatus = "Pass";
        } else {
            resultStatus = "Fail";
        }
    }

    public String getStatus() {
        return resultStatus;
    }

    public void display() {
        System.out.println("Result: " + resultStatus);
    }
}
