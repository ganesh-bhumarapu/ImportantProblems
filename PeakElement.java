import java.util.*;
class PeakElement{
    public static int peakElement(int[] arr) {
        for(int i = 1; i < arr.length; i++){
            if(i == arr.length - 1){
                if(arr[i] > arr[i - 1] && arr[i] > arr[0]) return i;
            }
            if(arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(peakElement(arr));
    }
}