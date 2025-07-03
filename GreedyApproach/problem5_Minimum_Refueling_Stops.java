package GreedyApproach;
import java.util.*;

public class problem5_Minimum_Refueling_Stops {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: target and starting fuel
        System.out.print("Enter target and startFuel: ");
        int target = sc.nextInt();
        int startFuel = sc.nextInt();

        System.out.print("Enter number of stations: ");
        int n = sc.nextInt();
        int[][] stations = new int[n][2];

        System.out.println("Enter station distance and fuel:");
        for (int i = 0; i < n; i++) {
            stations[i][0] = sc.nextInt(); // distance
            stations[i][1] = sc.nextInt(); // fuel
        }

        // Max heap to store fuel amounts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int refuels = 0, fuel = startFuel, i = 0;

        while (fuel < target) {
            // Add all stations within current fuel range to maxHeap
            while (i < n && stations[i][0] <= fuel) {
                maxHeap.add(stations[i][1]);
                i++;
            }

            // No reachable stations left to refuel from
            if (maxHeap.isEmpty()) {
                System.out.println("-1"); // Not possible
                return;
            }

            // Refuel with the station providing most fuel
            fuel += maxHeap.poll();
            refuels++;
        }

        System.out.println(refuels);
    }
}
