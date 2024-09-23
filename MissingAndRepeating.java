// 1-> iterate over the array and mark all the index values as negative according to the iteration
// 2-> find out the one which is double negative and this is the one that is repeating twicw
// 3 -> iterate again and search for the positive element and make sure it is not equal to repeating number

import java.util.*;
class MissingAndRepeating{
    public static int[] twoElements(int[] arr) {
        int n = arr.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (arr[Math.abs(arr[i]) - 1] < 0) {
                res[0] = Math.abs(arr[i]);
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0 && i + 1 != res[0]) {
                res[1] = i + 1;
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int[] res = twoElements(arr);
        for(int i = 0; i < 2; i++){
            System.out.print(res[i] + " c");
        }
    }
}