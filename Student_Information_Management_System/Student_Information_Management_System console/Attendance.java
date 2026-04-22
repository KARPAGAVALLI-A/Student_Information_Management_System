package sims;

public class Attendance {
    int attendId;
    int totalClass;
    int present;

    public void markAttendance(int total, int present) {
        this.totalClass = total;
        this.present = present;
    }

    public double calcPercentage() {
        return (present * 100.0) / totalClass;
    }
}