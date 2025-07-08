package DP;
import java.util.*;

public class problem3_MinCostClimbingStairs {

    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("Enter number off stairs:");
    int n = sc.nextInt();
    int[] cost = new int[n];

    System.out.println("Enter the cost of each stair: ");
        for(int i =0; i<n; i++){
            cost[i]= sc.nextInt();
        }

        int prev2 =0;
        int prev1 = 0;

        for(int i =2; i<=n; i++){
            int curr = Math.min(prev1 + cost[i -1], prev2 + cost[i -2]);
            prev2 = prev1;
            prev1 = curr;
        }
        System.out.println(prev1);
    }
}
