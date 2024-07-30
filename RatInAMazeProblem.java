import java.util.*;
class RatInAMazeProblem{
    public static ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.length;
        if(mat[0][0] == 0 || mat[n - 1][n - 1] == 0){
            ans.add("-1");
            return ans;
        }
        boolean[][] vis = new boolean[n][n];
        String path = "";
        dfs(0, 0, mat, ans, vis, n, path);

        return ans;
    }
    public static void dfs(int i, int j, int[][] mat,ArrayList<String> ans, boolean[][] vis, int n, String path){
        if(i < 0 || i >= n || j < 0 || j >= n){
            return;
        }
        if(mat[i][j] == 0 || vis[i][j] == true){
            return;
        }
        if(i == n - 1 && j == n - 1){
            ans.add(path);
            return;
        }
        vis[i][j] = true;
        dfs(i + 1, j, mat, ans, vis, n, path + "D");
        dfs(i - 1, j, mat, ans, vis, n, path + "U");
        dfs(i, j + 1, mat, ans, vis, n, path + "R");
        dfs(i, j - 1, mat, ans, vis, n, path + "L");
        vis[i][j] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        ArrayList<String> res = findPath(grid);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
}
