import java.util.*;
class MaximizeTheCutSegment{
    public static int maxCutSegments(int n, int x, int y, int z){
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            if(i - x >= 0){
                dp[i] = Math.max(dp[i], dp[i - x] + 1);
            }
            if(i - y >= 0){
                dp[i] = Math.max(dp[i], dp[i - y] + 1);
            }
            if(i - z >= 0){
                dp[i] = Math.min(dp[i], dp[i - z] + 1);
            }
        }
        return dp[n] < 0 ? 0 : dp[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int z = sc.nextInt();
        System.out.println(maxCutSegments(n, x, y, z));
    }
}