package com.sims.model;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class Marks {

    private int internal = 0;
    private int external = 0;

    // original logic
    public void setMarks(int i, int e) {
        this.internal = i;
        this.external = e;
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
