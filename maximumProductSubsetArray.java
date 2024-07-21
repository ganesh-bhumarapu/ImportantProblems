/*
case 1 : if numZero == len(arr)  return 0 as the total arr contains 0s
case 2 : if numNegative count is odd then check
            numNegative == 1 && numNegative + numZero == arr.size() then return 0
            else return product / Math.abs(maximumNegative number) by doing soo we get the maximum product
 */
import java.util.*;
class maximumProductSubsetArray{
    public static long findMaximumProduct(List<Integer> arr){
        int numZero = 0;
        int numNegative = 0;
        long product = 1;
        Integer maxNegative = null;
        long MOD = 1000000007;
        for(int num : arr){
            if(num == 0){
                numZero++;
                continue;
            }
            if(num < 0){
                numNegative++;
                if(maxNegative == null || num > maxNegative){
                    maxNegative = num;
                }
            }
            product = (product * Math.abs(num)) % MOD;
        }
        if(numZero == arr.size()){
            return 0;
        }
        if(numNegative % 2 != 0){
            if(numNegative == 1 && numNegative + numZero == arr.size()){
                return 0;
            }
            if(maxNegative != null){
                product = (product / Math.abs(maxNegative)) % MOD;
            }
        }
        return product % MOD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
        System.out.println(findMaximumProduct(arr));
    }
}