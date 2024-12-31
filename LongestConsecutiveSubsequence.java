import java.util.*;
class LongestConsecutiveSubsequence{
    public static int longest(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int ele : arr) pq.add(ele);
        int maxLen = 1;
        int len = 1;
        int prev = pq.poll();
        while(!pq.isEmpty()){
            int curr = pq.poll();
            if(curr == prev) continue;//handing duplicates
            if(curr - prev == 1){
                len++;
                maxLen = Math.max(maxLen, len);
            }else{
                len = 1;
            }
            prev = curr;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(longest(arr));
    }
}