import java.util.*;
class TheCelebrityProblem{
    public static int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;
        // check for the celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }
        // verify the celebrity
        for (int i = 0; i < n; i++) {
            if (i != candidate && (mat[candidate][i] == 1 || mat[i][candidate] == 0)) {
                return -1;
            }
        }
        return candidate;
    }
//    public int celebrity(int mat[][]) {
//        int top = 0;
//        int bottom = mat.length - 1;
//
//        while (top < bottom) {
//            if (mat[top][bottom] == 1) {
//                top++;
//            } else {
//                bottom--;
//            }
//        }
//
//        int candidate = top;
//
//        for (int i = 0; i < mat.length; i++) {
//            if (i != candidate) {
//                if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
//                    return -1;
//                }
//            }
//        }
//        return candidate;
//    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        System.out.println(celebrity(mat));

    }
}