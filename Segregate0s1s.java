import java.util.*;
class Segregate0s1s{
   public static void segregate(int[] arr) {
//        int i = 0;
//        int j = arr.length - 1;
//        while(i < j) {
//            while (arr[i] == 0 && i < j) {
//                i++;
//            }
//            while (arr[j] == 1 && i < j) {
//                j--;
//            }
//            if (i < j) {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//                i++;
//                j--;
//            }
//        }
//    }
       int i = 0;
       int j = arr.length - 1;
       while (i < j) {
           if (arr[i] == 1 && arr[j] == 0) {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               i++;
               j--;
           } else if (arr[i] == 0) i++;
           else j--;
       }
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        segregate(arr);
        for(int i = 0; i < n; i++){
            System.out.print(arr[i] + " ");
        }
    }
}