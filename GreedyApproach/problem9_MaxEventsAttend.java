package GreedyApproach;
import java.util.*;

public class problem9_MaxEventsAttend {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

    int n = sc.nextInt();
    int[][] events = new int[n][2];

    for(int i=0; i<n; i++){

        events[i][0] = sc.nextInt();
        events[i][1] = sc.nextInt();
    }
    Arrays.sort(events, Comparator.comparingInt(a -> a[0]));

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int day = 1, i = 0, attended = 0;
        int maxDay = 100000;

        while (day <= maxDay) {
            // Add all events starting today
            while (i < n && events[i][0] == day) {
                minHeap.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend one event ending the soonest
            if (!minHeap.isEmpty()) {
                minHeap.poll();
                attended++;
            }

            // If no more events and heap empty, stop early
            if (i >= n && minHeap.isEmpty()) break;

            day++;
        }

        System.out.println(attended);
    }
}

