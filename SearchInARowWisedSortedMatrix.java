import java.util.*;
class SearchInARowWisedSortedMatrix {
    public static boolean searchRowMatrix(int[][] mat, int x) {
        int row = mat.length;
        for(int i = 0; i < row; i++){
            if(binarySearch(mat[i], x)) return true;
        }
        return false;
    }
    private static boolean binarySearch(int[] row, int x){
        int low = 0;
        int high = row.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(row[mid] == x) return true;
            else if(row[mid] > x) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i =0; i < n; i++){
            for(int j =0; j < m; j++){
                mat[i][j]=sc.nextInt();
            }
        }
        int x = sc.nextInt();
        System.out.println(searchRowMatrix(mat, x));
    }
}