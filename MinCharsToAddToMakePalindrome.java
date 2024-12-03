import java.util.*;
class MinCharsToAddToMakePalindrome{
    public static int minChar(String s){
        int i = 0;
        int j = s.length() - 1;
        int k = j;
        int res = 0;
        while(i < j){
            if(s.charAt(i) == s.charAt(j)){
                i++;
                j--;
            }else{
                res++;
                i = 0;
                j = --k;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(minChar(s));
    }
}