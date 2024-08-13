import java.util.*;
class SquareRootOfAnElement {
    static long floorSqrt(long n) {
        // Your code here
        if (n < 2) {
            return n;
        }
        long i = 0;
        long res = 0;
        long ans = 0;
        while (i < n) {
            if (i * i <= n) {
                if (i * i > res) {
                    res = i * i;
                    ans = i;
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(floorSqrt(n));
    }
}