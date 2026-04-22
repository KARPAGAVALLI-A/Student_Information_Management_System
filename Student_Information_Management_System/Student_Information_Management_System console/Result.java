package sims;

public class Result {
    int resultId;
    String status;

    public void generateResult(Marks marks) {
        if (marks.total >= 50) {
            status = "Pass";
        } else {
            status = "Fail";
        }

        System.out.println("Total Marks: " + marks.total);
        System.out.println("Result: " + status);
    }
}