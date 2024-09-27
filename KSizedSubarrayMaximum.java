import java.util.*;
class KSizedSubarrayMaximum{
    public static ArrayList<Integer> subarrayMax(int[] arr, int k){
        ArrayList<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();

        for(int i = 0; i < arr.length; i++){
            if(!deque.isEmpty() && deque.peekFirst() == i - k){ // Remove elements out of the current window (i - k)
                deque.pollFirst();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]){ // Remove elements smaller than the current element from the deque
                deque.pollLast();
            }
            deque.offerLast(i); // Add current element index to the deque

            if(i >= k - 1){ // If we have processed at least k elements, add the maximum to result
                res.add(arr[deque.peekFirst()]); // The element at the front of the deque is the maximum for this window
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> ans = subarrayMax(arr, k);
        for(int ele : ans){
            System.out.print(ele);
        }
    }
}