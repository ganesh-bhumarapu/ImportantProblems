import java.util.*;
class MinimalCost{
    public static int minimizeCost(int[] arr, int k){
        int[] dp = new int[arr.length];
        dp[0] = 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i = 0; i < arr.length; i++){
            int j = i + 1;
            while(j <= i + k && j < arr.length){
                int cost = dp[i] + Math.abs(arr[i] - arr[j]);
                dp[j] = Math.min(dp[j], cost);
            }
        }
        return dp[arr.length - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(minimizeCost(arr, k));
    }
}