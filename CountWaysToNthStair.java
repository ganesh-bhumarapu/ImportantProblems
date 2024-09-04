/*
if given number is even let us take n = 6
then divide it by two we get the set as {2, 2, 2} -> 1
now divide one of the 2 in the set into 1,1 as {1, 1, 2, 2} -> 2
now divide another one till the last as {1, 1, 1, 1, 2} -> 3
and last 2 will be divided as {1, 1, 1, 1, 1, 1} ->4

same applies for the odd number too

from above we can conclude that number of steps = 1 + n/2
 */
import java.util.*;
class CountWaysToNthStair{
    public static int noOfSteps(int n) {
        //dp approach
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + 1;
        }
        return dp[n];
    }
    // mathematical approch
    // return 1 + n / 2;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(noOfSteps(n));
    }
}