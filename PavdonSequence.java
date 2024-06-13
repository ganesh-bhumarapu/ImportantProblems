import java.util.*;
class PavdonSequence{
    public static final int MOD = 1000000007;
    public static int pavdonSequence(int n){
        if( n <= 2){
            return 1;
        }
        int prev2 = 1;
        int prev3 = 1;
        int curr = 1;
        for(int i = 1; i <= n; i++){
            int temp = curr;
            curr = (prev2 + prev3) % MOD;
            prev3 = prev2;
            prev2 = temp;
        }
        return curr;
    }
// another possibly way is doing things same as dibnocci series


//User function Template for Java

//    class Solution
//    {
//        public static final int MOD = 1000000007;
//        public int padovanSequence(int n)
//        {
//            //code here.
//            if(n == 0){
//                return 1;
//            }
//            if(n == 1){
//                return 1;
//            }
//            if(n == 2){
//                return 1;
//            }
//            int[] pS = new int[n+1];
//            pS[0] = 1;
//            pS[1] = 1;
//            pS[2] = 1;
//
//            for(int i=3;i<= n;i++){
//                pS[i] = (pS[i-2]+pS[i-3]) % MOD;
//            }
//            return pS[n];
//        }
//
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        System.out.println(pavdonSequence(n));
    }
}