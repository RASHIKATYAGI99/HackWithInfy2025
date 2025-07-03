package GreedyApproach;
import java.util.*;

public class problem3_Minimum_Number_of_Coins {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter amount: ");
        int amount = sc.nextInt();
        sc.nextLine(); 

        System.out.println("Enter coin values (space-separated): ");
        String[] input = sc.nextLine().split(" ");
        int[] coins = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            coins[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(coins); // Ascending order
        int count = 0;

        for (int i = coins.length - 1; i >= 0; i--) {
            while (amount >= coins[i]) {
                amount -= coins[i];
                count++;
            }
        }

        
        System.out.println("Minimum number of coins: " + count);

    }
}
