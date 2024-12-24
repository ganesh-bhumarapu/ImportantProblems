import java.util.*;
class SearchInASortedMatrix{
    public static boolean searchMatrix(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        int l = 0;
        int h = n * m - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            int i = mid / m;
            int j = mid % m;
            if (mat[i][j] == x) return true;
            else if (mat[i][j] > x) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        int x = sc.nextInt();
        System.out.println(searchMatrix(mat, x));
    }
}