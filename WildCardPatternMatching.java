import java.util.*;
class WildCardPatternMatching{
    public static int wildCard(String pattern, String str){
        int n = pattern.length();
        int m = str.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;// empty pattern matches with empty str
        // Handle patterns with '*' at the beginning
        for(int i = 1; i <= n; i++){
            if(pattern.charAt(i - 1) == '*'){
                dp[i][0] = dp[i - 1][0];
            }
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(pattern.charAt(i - 1) == '*'){
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                }
                else if(pattern.charAt(i - 1) == '?' || pattern.charAt(i - 1) == str.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m] ? 0 : 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        String str = sc.nextLine();
        System.out.println(wildCard(pattern, str));
    }
}