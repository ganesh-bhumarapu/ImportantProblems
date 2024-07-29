import java.util.*;
class RowWithMax1s{
    public static int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m - 1;
        int maxRow = -1;
        while( i < n && j >= 0){
            if(arr[i][j] == 1){
                maxRow = i;
                j--;
            }
            else{
                i++;
            }
        }
        return maxRow;
    }
//    public int rowWithMax1s(int arr[][]) {
//        // code here
//        int n = arr.length;
//        int m = arr[0].length;
//        int maxRow = -1;
//        int maxCount = 0;
//        for(int i = 0; i < n; i++){
//            int count = 0;
//            for(int j = 0; j  < m; j++){
//                if(arr[i][j] == 1){
//                    count = m - j + 1;
//                    j = m -1;
//                }
//                if(maxCount < count){
//                    maxCount = count;
//                    maxRow = i;
//                }
//            }
//        }
//        return maxRow;
//    }
//}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] arr = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(rowWithMax1s(arr));
    }
}
