package sims;

import java.io.Serializable;

public class Result implements Serializable {
    String status;

    public void generateResult(Marks marks) {
        if (marks.getTotal() >= 50) {
            status = "Pass";
        } else {
            status = "Fail";
        }
    }

    public void display() {
        System.out.println("Result: " + status);
    }
}