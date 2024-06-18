import java.util.*;
class NumberOfRectanglesInACircle {
    public static int noOfRectangles(int r) {
        int ans = 0;
        for (int i = 1; i < 2 * r; i++) {
            for (int j = 1; j < 2 * r; j++) {
                if (i * i + j * j <= 4 * r * r) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        System.out.println(noOfRectangles(r));
    }
}