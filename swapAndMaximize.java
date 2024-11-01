import java.util.*;
class swapAndMaximize{
    public static long maxSum(Long[] arr) {
        Long[] res = new Long[arr.length];
        Arrays.sort(arr);
        int i = 0;
        int x = 0;
        int j = arr.length - 1;
        while(i <= j){
            if(x % 2 == 0){
                res[x++] = arr[i];
                i++;
            }else{
                res[x++] = arr[j];
                j--;
            }
        }
        long sum = 0;
        for(int y = 1; y < res.length; y++){
            sum += Math.abs(res[y] - res[y - 1]);
        }
        sum += Math.abs(res[arr.length - 1] - res[0]);

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long[] arr = new Long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }
        System.out.println(maxSum(arr));
    }
}