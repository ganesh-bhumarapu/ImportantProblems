import java.util.*;
class AllocateMinimumPages {
    public static int findPages(int[] arr, int k) {
        if (arr.length == 0 || arr.length < k) return -1; // Handle edge cases

        int sum = 0;
        int max = 0; // To store the maximum single element in the array
        for (int ele : arr) {
            sum += ele;
            max = Math.max(max, ele);
        }

        int start = max; // The minimum value of maxPagesAllowed is the largest book size
        int end = sum;   // The maximum value is the sum of all pages
        int ans = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (isValid(arr, k, mid)) { // Check if the allocation is valid
                ans = mid; // Update answer
                end = mid - 1; // Search in the left search space for a smaller maximum
            } else {
                start = mid + 1; // Search in the right search space
            }
        }
        return ans;
    }

    private static boolean isValid(int[] arr, int k, int maxPagesAllowed) {
        int students = 1; // At least one student is required
        int pages = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxPagesAllowed) return false; // If a single book exceeds maxPagesAllowed
            if (pages + arr[i] <= maxPagesAllowed) {
                pages += arr[i];
            } else {
                students++;
                pages = arr[i];
                if (students > k) return false; // More students required than available
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(findPages(arr, k));
    }
}
