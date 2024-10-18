import java.util.*;
class SingleNumber{
    public static int oddCount(int[] arr){
        // TC -> O(N) SC -> O(N)
        Map<Integer, Integer> mp = new HashMap<>();
        for(int num : arr){
            mp.put(num, mp.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(entry.getValue() % 2 != 0){
                return entry.getKey();
            }
        }
        return -1;
        //TC -> O(N) SC -> O(1) Bit Manipulation
//        int ans = 0
//        for(int num : arr){
//            ans ^= num;
//        }
//        return ans;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(oddCount(arr));
    }
}