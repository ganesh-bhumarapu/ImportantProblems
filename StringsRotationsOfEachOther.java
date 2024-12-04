import java.util.*;
class StringsRotationsOfEachOther{
    public static boolean solve(String s1, String s2){
        s1 = s1 + s1;
        return s1.lastIndexOf(s2) >= 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println(solve(s1, s2));
    }
}