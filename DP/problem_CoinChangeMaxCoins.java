package DP;
import java.util.*;

public class problem_CoinChangeMaxCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Initialize include and exclude
        int inc = 0;  // max sum including current element
        int exc = 0;  // max sum excluding current element

        for(int i = 0; i < n; i++) {
            int new_inc = exc + arr[i];           // Include current: previous exclude + current
            int new_exc = Math.max(inc, exc);     // Exclude current: max of previous inc or exc

            inc = new_inc;
            exc = new_exc;
        }

        // Output
        int result = Math.max(inc, exc);
        System.out.println("Maximum sum of non-adjacent elements: " + result);

        sc.close();
    }
}
