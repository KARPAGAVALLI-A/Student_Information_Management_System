package com.sims.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Attendance {

    private int totalClass = 0;
    private int present = 0;

    // original logic
    public void markAttendance(int total, int present) {
        this.totalClass = total;
        this.present = present;
    }

    public double calcPercentage() {
        if (totalClass == 0) return 0;
        return (present * 100.0) / totalClass;
    }

    public void display() {
        System.out.println("Attendance: " + calcPercentage() + "%");
    }
}
