package sims;

import java.io.Serializable;

public class Marks implements Serializable {
    int internal;
    int external;

    public void setMarks(int i, int e) {
        internal = i;
        external = e;
    }

    public int getTotal() {
        return internal + external;
    }

    public void displayMarks() {
        System.out.println("Internal: " + internal);
        System.out.println("External: " + external);
        System.out.println("Total: " + getTotal());
    }
}