import java.util.*;
class ToeplitzMatrix{
    public static boolean isToeplitzMatrix(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        for(int row = 0; row < rows; row++){
            int ans = mat[row][0];
            int i = row;
            int j = 0;
            while(i < rows && j < cols){
                if(mat[i][j] != ans) return false;
                i++;
                j++;
            }
        }
        for(int col = 0; col < cols; col++){
            int ans = mat[0][col];
            int i = 0;
            int j = col;
            while( i < rows && j < cols){
                if(mat[i][j] != ans) return false;
                i++;
                j++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] mat = new int[rows][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                mat[i][j] = sc.nextInt();
            }
        }
        boolean result = isToeplitzMatrix(mat);
        System.out.println(result);
    }
}