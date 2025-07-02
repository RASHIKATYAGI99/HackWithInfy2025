package GreedyApproach;
import java.util.*;

class Item {
    int value, weight;

    Item(int v, int w) {
        value = v;
        weight = w;
    }
}

public class problem2_Fractional_Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input: number of items and knapsack capacity
        int n = sc.nextInt();
        int capacity = sc.nextInt();

        Item[] items = new Item[n];

        // Read item values and weights
        for (int i = 0; i < n; i++) {
            int value = sc.nextInt();
            int weight = sc.nextInt();
            items[i] = new Item(value, weight);
        }

        // Sort items by value/weight ratio in descending order
        Arrays.sort(items, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));

        double totalValue = 0.0;

        for (Item item : items) {
            if (capacity >= item.weight) {
                capacity -= item.weight;
                totalValue += item.value;
            } else {
                totalValue += item.value * ((double) capacity / item.weight);
                break;
            }
        }

        // Print the result rounded to 2 decimal places
        System.out.printf("%.2f\n", totalValue);
    }
}
