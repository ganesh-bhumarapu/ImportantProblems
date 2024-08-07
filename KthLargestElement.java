import java.util.*;
class KthLargestElement{
    public static long kthlargest(int k, int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int[] arr = new int[n + m];
        System.arraycopy(arr1, 0, arr, 0, n);
        System.arraycopy(arr2, 0, arr, n, m);
        Arrays.sort(arr);
        int ans = arr[k - 1];
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(kthlargest(k, arr1, arr2));
    }
}