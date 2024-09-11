import java.util.*;
class MinimumCostOfRopes{
    public static long minimumCost(long[] arr){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(long ele : arr){
            pq.add(ele);
        }
        long cost = 0;
        long minCost = 0;
        while(pq.size() != 1){
            long first = pq.poll();
            long second = pq.poll();
            cost = first + second;
            minCost += cost;
            pq.add(cost);
        }
        return minCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int)n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(minimumCost(arr));
    }
}