import java.util.*;
class LeftRotateMatrixKtimes{
    static int[][] rotateMatrix(int k, int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;

        k = k % cols;
        if(k == 0){
            return mat;
        }
        for(int i = 0; i < rows; i++){
            mat[i] = rotatingRowLeft(k, mat[i]);
        }
        return mat;
    }
    public static int[] rotatingRowLeft(int k, int[] row){
        int n = row.length;
        int[] rotatedRow = new int[n];
        for(int i = 0; i < n; i++){
            rotatedRow[i] = row[(i + k) % n];
        }
        return rotatedRow;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int k = sc.nextInt();

        int[][] mat = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = sc.nextInt();
            }
        }

        int[][] rotatedMatrix = rotateMatrix(k, mat);
        for(int i = 0; i < rotatedMatrix.length; i++){
            for(int j = 0; j < rotatedMatrix[i].length; j++){
                System.out.println(rotatedMatrix[i][j]);
            }
            System.out.println();
        }
    }
}