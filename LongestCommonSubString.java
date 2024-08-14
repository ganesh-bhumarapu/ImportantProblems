import java.util.*;
class LongestCommonSubString{
    public static int longestCommonsubstr(String str1, String str2){
        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];
        int res = 0;
        for(int i = 1; i <= n ; i++){
            for(int j = 1; j <= m; j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        System.out.println(longestCommonsubstr(str1, str2));
    }
}