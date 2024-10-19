import java.util.*;
class NearestMultipleOfTen{
    public static String multiple(String str){
        String ans = "";
        int n = str.length();
        if(str.charAt(n - 1) <= '5'){
            ans = str.substring(0, n - 1) + ans;
        }else{
            int i = n - 1;
            ans = "0";
            int carry = 1;
            i--;
            while(i >= 0){
                if(str.charAt(i) == '9' && carry == 1){
                    ans = "0" + ans;
                    carry = 1;
                }else{
                    ans = (char)(str.charAt(i) + carry) + ans;
                    carry = 0;
                }
                i--;
            }
            if(carry == 1){
                ans = "1" + ans;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(multiple(str));
    }
}