import java.util.*;
class LargestSquareFormedInAMatrix{
    public static int maxSide(int[][] mat){
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        int ans = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if (i == 0 || j == 0){
                    if(mat[i][j] == 1){
                        dp[i][j] = 1;
                    }
                }
                if(mat[i][j] == 0){
                    dp[i][j] = 0;
                }
                if(mat[i][j] == 1){
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] mat = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(maxSide(mat));
    }
}