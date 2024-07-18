import java.util.*;
class LongestAlternatingSubsequence{
    public static int sequence(int[] arr){
        int inc = 1;
        int dec = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i - 1] > arr[i]){
                inc = dec + 1;
            }
            else if(arr[i -1] < arr[i]){
                dec = inc + 1;
            }
        }
        return Math.max(inc, dec);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sequence(arr));
    }
}