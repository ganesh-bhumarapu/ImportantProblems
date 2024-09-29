import java.util.*;
class TotalCount {
    static int totalCount(int k, int[] arr) {
        // code here
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= k) {
                count++;
            } else {
                if (arr[i] % k != 0) {
                    count += (arr[i] / k) + 1;
                } else {
                    count += arr[i] / k;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(totalCount(k, arr));
    }
}
