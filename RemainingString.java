import java.util.*;
class RemainingString{
    public static String printTheString(String str, char ch, int count){
        int n = str.length();
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            if(str.charAt(i) == ch) c++;
            if(c == count){
                for(int j = i + 1; j < n; j++){
                    sb.append(str.charAt(j));
                }
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char ch = sc.next().charAt(0);
        int count = sc.nextInt();
        String s = printTheString(str, ch, count);
        System.out.println(s);
    }
}