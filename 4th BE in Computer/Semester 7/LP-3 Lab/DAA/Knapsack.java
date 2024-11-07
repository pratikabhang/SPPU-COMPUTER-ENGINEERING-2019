import java.util.Scanner;

public class Knapsack {

    public static int knapsackDP(int W, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int n = scanner.nextInt();

        int[] values = new int[n];
        int[] weights = new int[n];

        System.out.print("Enter the values of the items: ");
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
        }

        System.out.print("Enter the weights of the items: ");
        for (int i = 0; i < n; i++) {
            weights[i] = scanner.nextInt();
        }

        System.out.print("Enter the maximum capacity of the knapsack: ");
        int W = scanner.nextInt();

        int maxValue = knapsackDP(W, weights, values, n);

        System.out.println("The maximum value that can be obtained is: " + maxValue);

        scanner.close();
    }
}

/*
 * Enter the number of items: 4
 * Enter the values of the items: 60 100 120 30
 * Enter the weights of the items: 10 20 30 5
 * Enter the maximum capacity of the knapsack: 50
 * The maximum value that can be obtained is: 220
 */