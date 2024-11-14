import java.util.*;
class NearlySorted{
    public static void sort(int[] arr, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i <= k && i < arr.length; i++){
            pq.add(arr[i]);
        }
        int index = 0;
        for(int i = k + 1; i < arr.length; i++){
            arr[index++] = pq.poll();
            pq.add(arr[i]);
        }
        while(!pq.isEmpty()){
            arr[index++] = pq.poll();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        sort(arr, k);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}