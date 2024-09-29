import java.util.*;
class AddBinaryStrings{
    public static String add(String A, String B){
        if(A.equals('0') && B.equals('0')) return "0";
        StringBuilder sb = new StringBuilder();
        int n = A.length();
        int m = B.length();
        int carry = 0;

        while(n > 0 || m > 0){
            int val1 = (n > 0) ? A.charAt(n - 1) - '0' : 0;
            int val2 = (m > 0) ? B.charAt(m - 1) - '0' : 0;

            int sum = val1 + val2 + carry;
            carry = sum/2;
            sb.append(sum % 2);
            n--;
            m--;
        }
        if(carry == 1) sb.append(carry);
        sb.reverse();
        while(sb.charAt(0) == '0') sb.deleteCharAt(0);// leading zero should be eliminated (ex 1100010 if we reverse it 0100011 which makes no sense of having zero atfirst)

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.nextLine();
        String B = sc.nextLine();

        System.out.println(add(A, B));
    }
}