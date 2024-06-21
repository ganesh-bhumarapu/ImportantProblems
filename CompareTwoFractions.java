import java.util.*;
class CompareTwoFractions{
    static String compareFrac(String str){
        String newStr[] = str.replaceAll(" ", "").split(",");
        String first[] = newStr[0].split("/");
        String second[] = newStr[1].split("/");

        double a = Integer.parseInt(first[0]);
        double b = Integer.parseInt(first[1]);
        double c = Integer.parseInt(second[0]);
        double d = Integer.parseInt(second[1]);

        if(a/b == c/d){
            return "equal";
        }
        else if(a/b > c/b){
            return newStr[0];
        }
        else{
            return newStr[1];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String res = compareFrac(str);
        System.out.println(res);
    }
}