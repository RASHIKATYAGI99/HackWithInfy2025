package DP;
import java.util.*;

public class problem1_FibonacciDP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of terms: "); // ✅ Added semicolon here
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.print("Please enter a number greater than 0.");
            return;
        }

        int[] dp = new int[n];

        dp[0] = 0;

        if (n > 1) {
            dp[1] = 1;
        }

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        System.out.print("Fibonacci series up to " + n + " terms: ");
        for (int i = 0; i < n; i++) {
            System.out.print(dp[i] + " ");
        }


    }
}
