package sims;

public class Marks {
    int internal;
    int external;
    int total;

    public void calcTotalMark() {
        total = internal + external;
    }

    public void displayMarks() {
        System.out.println("Internal: " + internal);
        System.out.println("External: " + external);
        
    }
}