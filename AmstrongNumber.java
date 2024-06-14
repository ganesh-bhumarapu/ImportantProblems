import java.util.*;
class AmstrongNumber{
    public static void amstrongNumber(int n){
        int rem = 0;
        int sum = 0;
        int num = n;
        while(num > 0){
            rem = num % 10;
            sum += Math.pow(rem,3);
            num /= 10;
        }
        if(sum == n){
            System.out.println("amstrong number");
        }
        else{
            System.out.println("not amstrong number");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        amstrongNumber(n);
    }
}