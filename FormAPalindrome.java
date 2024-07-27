import java.util.*;
class FormAPalindrome{
    public static int minCount(String str){
        int n = str.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int len = 2; len <= n; len++){
            for(int i = 0; i < n - len + 1; i++){
                int j = i + len - 1;
                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                }else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        int lpsLength = dp[0][n - 1];

        return n - lpsLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(minCount(str));
    }
}