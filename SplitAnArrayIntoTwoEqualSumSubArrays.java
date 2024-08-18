import java.util.*;
class SplitAnArrayIntoTwoEqualSumSubArrays{
    public static boolean canSplit(int[] arr){
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        int rightSum = 0;
        int leftSum = sum;
        for(int i = 0; i < n; i++){
            rightSum += arr[i];
            leftSum -= arr[i];

            if(rightSum == leftSum){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(canSplit(arr));
    }
}