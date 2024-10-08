import java.util.*;
class LargestPairSum{
    public static int sumPair(int[] arr){
        int i = 0;
        int j = arr.length - 1;
        int sum = 0;
        while(i < j){
            if(arr[i] >= arr[j]){
                sum = Math.max(arr[i] + arr[j], sum);
                j--;
            }else{
                sum = Math.max(arr[i] + arr[j], sum);
                i++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sumPair(arr));
    }
}