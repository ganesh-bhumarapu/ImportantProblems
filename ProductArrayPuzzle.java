import java.util.*;
class ProductArrayPuzzle{
    public static long[] productArray(int[] nums){

        int n = nums.length;
        long[] res = new long[n];

        Arrays.fill(res, 1);
        long temp = 1;

        for(int i = 0; i < n; i++){
            res[i] = temp;
            temp = temp * nums[i];
        }
        temp = 1;
        for(int i = 0; i < n; i++){
            res[i] = res[i] * temp;
            temp = temp * nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        long[] res = productArray(nums);
        for(long i : res){
            System.out.print(i + " ");
        }
    }
}