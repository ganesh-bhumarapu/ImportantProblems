import java.util.*;
class SumPairClosestToTarget{
    public static List<Integer> pair(int[] arr, int target){
        int i = 0;
        int j = arr.length - 1;
        List<Integer> res  = new ArrayList<>();
        int closedif = Integer.MAX_VALUE;
        while(i < j){
            int sum = arr[i] + arr[j];
            int diff = Math.abs(target - sum);
            if(diff < closedif){
                closedif = diff;
                res.clear();
                res.add(arr[i]);
                res.add(arr[j]);
            }
            if(sum > target) j--;
            else i++;
        }
        return  res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        List<Integer> ans = pair(arr, target);
        for(int ele : ans) System.out.print(ele + " ");
    }
}