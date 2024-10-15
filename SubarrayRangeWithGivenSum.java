import java.util.*;
class SubarrayRangeWithGivenSum{
    public static int subarraycount(int[] arr, int tar){

        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        int count = 0;
        mp.put(0, 1);
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];

            if(mp.containsKey(sum - tar)){
                count += mp.get(sum - tar);
            }
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
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
        int tar = sc.nextInt();
        System.out.println(subarraycount(arr, tar));
    }
}