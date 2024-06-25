import java.util.*;
class SummedMatrix {
    public static long summedMatrix(long n, long q) {
        long start = Math.max(1, q - n);
        long end = Math.min(n, q - 1);

        if (start > end) {
            return 0;
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long q = sc.nextLong();
        System.out.println(summedMatrix(n, q));
    }
}