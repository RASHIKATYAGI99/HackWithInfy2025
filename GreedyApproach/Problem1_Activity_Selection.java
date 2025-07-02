package GreedyApproach;
import java.util.*;

class Activity{
    int start,end;
    Activity(int s, int e){
        this.start=s;
        this.end=e;
    }
}
public class Problem1_Activity_Selection {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of activities: ");
        int n= sc.nextInt();

        Activity[] activities= new Activity[n];

        System.out.println("Enter start and end times of each activity: ");
        for(int i=0; i<n; i++){
            int start=sc.nextInt();
            int end = sc.nextInt();
            activities[i] =new Activity(start, end);

        }
        Arrays.sort(activities, Comparator.comparingInt(a -> a.end));
        int count = 1; 
        int lastEnd = activities[0].end;

         for (int i = 1; i < n; i++) {
            if (activities[i].start >= lastEnd) {
                count++;
                lastEnd = activities[i].end;
            }
        }

        System.out.println("Maximum number of non-overlapping activities: " + count);
    

    }
}
