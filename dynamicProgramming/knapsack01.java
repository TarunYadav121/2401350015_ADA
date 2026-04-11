package codes.dynamicProgramming;

public class knapsack01 {

    public static void knapsack(int[] weights, int[] values, int n, int W) {

        int dp[][] = new int[n + 1][W + 1];

        // Fill DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (weights[i - 1] <= w)
                    dp[i][w] = Math.max(
                        values[i - 1] + dp[i - 1][w - weights[i - 1]],
                        dp[i - 1][w]
                    );
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        // Print max profit
        System.out.println("Maximum Profit = " + dp[n][W]);

        // Backtracking to find selected items
        int w = W;
        System.out.println("Selected Items (0/1 vector):");

        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.println("Item " + i + " = 1");
                w -= weights[i - 1];
            } else {
                System.out.println("Item " + i + " = 0");
            }
        }
    }

    public static void main(String[] args) {
        int values[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int W = 50;
        int n = values.length;

        knapsack(weights, values, n, W);
    }
}