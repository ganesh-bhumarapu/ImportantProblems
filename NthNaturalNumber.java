/*
first let us take n = 84 -> 1st step : 84 % 9 -> rem = 3 store it in sb
then 2nd step -> decrease n value by  doing 84 / 9 and repeat the steps until n > 0 and store all the remainders
then reverse it we get the desired answer
 */
import java.util.*;
class NthNaturalNumber{
    public static long nthNumber(int n){
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            sb.append(n % 9);
            n /= 9;
        }
        return Long.valueOf(sb.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(nthNumber(n));
    }
}