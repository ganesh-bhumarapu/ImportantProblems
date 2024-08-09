import java.util.*;
class MaximizeArrayValueAfterRearrangement{
    public static int mod = 1000000007;
    public static int solve(int[] arr){
        Arrays.sort(arr);
        long ans = 0;// to handle large values properly
        for(int i = 0; i < arr.length; i++){
            ans = (ans + (long) i * arr[i] % mod) % mod;
        }
        return (int)ans;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(solve(arr));
    }
}