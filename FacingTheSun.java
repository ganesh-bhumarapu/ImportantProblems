import java.util.*;
class FacingTheSun{
    public static int getCount(int[] heights) {
        int count = 1;
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            if (max < heights[i]) {
                max = heights[i];
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] heights = new int[n];
        for(int i = 0; i < n; i++){
            heights[i] = sc.nextInt();
        }
        System.out.println(getCount(heights));
    }
}