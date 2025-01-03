import java.util.*;
class CountSubarraysWithGivenXor{
    public static int countsubarrays(int[] arr, int k){
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int count = 0;
        for(int ele : arr){
            xor ^= ele;
            if(xor == k) count++;
            if(map.containsKey(xor ^ k)) count += map.get(xor ^ k);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        System.out.println(countsubarrays(arr, k));
    }
}