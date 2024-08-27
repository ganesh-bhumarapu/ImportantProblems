import java.util.*;
class MaximumDifference{
    public static int maxDifference(int[] arr, int n) {
        int[] ls = new int[n]; // which stores the left nearest smallest elements
        int[] rs = new int[n]; // which stores the right nearest smallest elements
       /*
        for(int i = 0; i < n; i++){
            int j = i -1;
            while(j >= 0 && arr[j] >= arr[i]){
                j--;
            }
            ls[i] = (j >= 0) ? arr[i] : 0;
        }

        for(int i = 0; i < n; i++){
            int j = i + 1;
            while(j < n && arr[j] >= arr[i]){
                j++;
            }
            rs[i] = (j < n) ? arr[i] : 0;
        }
   */
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            ls[i] = !st.isEmpty() ? 0 : arr[i];
        }
        st.clear();//  make sure to clear the stack before moving to other
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            rs[i] = !st.isEmpty() ? 0 : arr[i];
        }
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(ls[i] - rs[i]));
        }
        return maxDiff;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(maxDifference(arr, n));
    }
}