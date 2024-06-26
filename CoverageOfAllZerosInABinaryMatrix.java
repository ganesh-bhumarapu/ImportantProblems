import java.util.*;
class CoverageOfAllZerosInABinaryMatrix{
    public static int findCoverage(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int ans = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) continue;
                // left neighbor
                if (j - 1 >= 0 && matrix[i][j - 1] == 1) ans++;
                // right neighbor
                if (j + 1 < cols && matrix[i][j + 1] == 1) ans++;
                // top neighbor
                if (i - 1 >= 0 && matrix[i - 1][j] == 1) ans++;
                // bottom neighbor
                if (i + 1 < rows && matrix[i + 1][j] == 1) ans++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        System.out.println(findCoverage(matrix));
    }
}