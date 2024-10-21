import java.util.*;
class SplitTheArray{
    public static int count(int[] arr){
        int n = arr.length;

        int xor = 0;
        for(int ele : arr){
            xor = xor ^ ele;
        }
        if(xor == 0){
            return (1 << (n - 1)) - 1;
        }
        return 0;
    }
    // (1 << (n - 1)) - 1 ==> Math.pow(2, (n - 1)) - 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(count(arr));
    }
}