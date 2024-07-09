import java.util.*;
class ClosestThreeSum{
    public static int threeSumClosest(int[] arr, int target){
        Arrays.sort(arr);

        int resSum = arr[0] + arr[1] + arr[2];
        int minDiff = Math.abs(resSum - target);

        for(int i = 0; i < arr.length; i++){
            int left = i + 1;
            int right = arr.length -1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                int diffToTarget = Math.abs(sum - target);

                if(diffToTarget < minDiff || (diffToTarget == minDiff && sum > resSum)){
                    resSum = sum;
                    minDiff = diffToTarget;
                }
                if(sum < target){
                    left++;
                }else{
                    right--;
                }
            }
        }
        return resSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(threeSumClosest(arr, target));
    }
}