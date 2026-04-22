package sims;

import java.io.Serializable;

public class Attendance implements Serializable {
    int totalClass;
    int present;

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