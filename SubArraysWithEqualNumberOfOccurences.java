import java.util.*;
class SubArraysWithEqualNumberOfOccurences{
    public static int totalSubArrays(int[] arr, int x, int y){

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int fx = 0, fy = 0, ans = 0;

        for(int ele : arr){
            if(ele == x) fx++;
            else if(ele == y) fy++;

            int dif = fx - fy;
            if(map.containsKey(dif)){
                ans += map.get(dif);
                map.put(dif, map.get(dif) + 1);
            }else{
                map.put(dif, 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int x = sc.nextInt();
        int y = sc.nextInt();
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(totalSubArrays(arr, x, y));
    }
}