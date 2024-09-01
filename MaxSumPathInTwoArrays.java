import java.util.*;
class MaxSumPathInTwoArrays{
    public static int maxSumPath(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int ans = 0;
        int  sum1 = 0;
        int sum2 = 0;
        while(i < arr1.length && j < arr2.length){
            if(arr1[i] < arr2[j]){
                sum1 += arr1[i];
                i++;
            }else if(arr1[i] > arr1[j]){
                sum2 += arr2[j];
                j++;
            }else{
                sum1 += arr1[i];
                sum2 += arr2[j];
                ans = Math.max(sum1, sum2);
                sum1 = 0;
                sum2 = 0;
                i++;
                j++;
            }
        }
        while(i < arr1.length){
            sum1 += arr1[i];
        }
        while(j < arr2.length){
            sum2 += arr2[j];
        }
        ans = Math.max(sum1, sum2);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        for(int i = 0; i < n1; i++){
            arr1[i] = sc.nextInt();
        }
        for(int i = 0; i < n2; i++){
            arr2[i] = sc.nextInt();
        }
        System.out.println(maxSumPath(arr1, arr2));
    }
}