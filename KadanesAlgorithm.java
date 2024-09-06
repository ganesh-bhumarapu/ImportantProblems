import java.util.*;
class KadanesAlgorithm{
    public static long MaxSumSubArray(int[] arr){
        long sum = 0;
        long maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(sum < 0 ){
                sum = arr[i];
            }else{
                sum += arr[i];
            }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(MaxSumSubArray(arr));
    }
}