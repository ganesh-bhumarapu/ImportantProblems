import java.util.*;
class KnapSackProblem {
    public static int knapsack(int n, int W, int[] val, int[] wt) {
        int[][] dp = new int[n + 1][W + 1];// stores the profit values
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (wt[i - 1] <= j) {// it compares the weight of the object with the capacity if it is with in the capacity then
                    dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];// returns the maxProfit
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int W = sc.nextInt();
        int[] val = new int[n];
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
            wt[i] = sc.nextInt();
        }
    }
}