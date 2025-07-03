package GreedyApproach;
import java.util.*;

class Job {
    String id;
    int deadline;
    int profit;

    Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}

public class Problem3_JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of jobs
        System.out.print("Enter number of jobs: ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        Job[] jobs = new Job[n];

        System.out.println("Enter job details (id deadline profit):");
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().split(" ");
            String id = parts[0];
            int deadline = Integer.parseInt(parts[1]);
            int profit = Integer.parseInt(parts[2]);
            jobs[i] = new Job(id, deadline, profit);
        }

        // Sort jobs by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        // Find max deadline to define time slots
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline)
                maxDeadline = job.deadline;
        }

        boolean[] slots = new boolean[maxDeadline + 1]; // slot[0] is unused
        int totalProfit = 0;

        for (Job job : jobs) {
            // Try to schedule this job to latest available slot before deadline
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        System.out.println("Maximum total profit: " + totalProfit);
    }
}
