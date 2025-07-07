package DP;

import java.util.*;

public class problem_CoinChangeMinCoins {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User Input
        System.out.print("Enter the number of coin types: ");
        int m = sc.nextInt();  // Number of different coins

        int[] coins = new int[m];
        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < m; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter the amount you want to make (n): ");
        int n = sc.nextInt();  // Total amount to form

        // Arrays to store results
        int[] C = new int[n + 1]; // Minimum number of coins to make each amount
        int[] S = new int[n + 1]; // Last coin used to make the amount

        Arrays.fill(C, Integer.MAX_VALUE); // Initially all values are unreachable
        C[0] = 0; // 0 coins to make amount 0

        // DP approach
        for (int p = 1; p <= n; p++) {
            for (int coin : coins) {
                if (coin <= p && C[p - coin] != Integer.MAX_VALUE) {
                    if (C[p] > C[p - coin] + 1) {
                        C[p] = C[p - coin] + 1;
                        S[p] = coin;
                    }
                }
            }
        }

        // Final Result
        if (C[n] == Integer.MAX_VALUE) {
            System.out.println("No solution possible to make amount " + n);
        } else {
            System.out.println("Minimum number of coins to make amount " + n + ": " + C[n]);
            System.out.print("Coins used: ");
            int temp = n;
            while (temp > 0) {
                System.out.print(S[temp] + " ");
                temp -= S[temp];
            }
            System.out.println();
        }

        sc.close();
    }
}
