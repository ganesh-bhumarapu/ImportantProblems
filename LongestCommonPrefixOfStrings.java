import java.util.*;
class LongestCommonPrefixOfStrings{
    public static String checkForPrefix(String a, String b){
        int N = Math.min(a.length(), b.length());
        String res = "";
        int i = 0;
        while(i < N){
            if(a.charAt(i) != b.charAt(i)){
                break;
            }
            else {
                res += a.charAt(i);
                i++;
            }
        }
        return res;
    }
    public static String commonPrefix(String[] arr){
        int n = arr.length;
        String curr = arr[0];
        for(int i = 1; i < n; i++){
            curr = checkForPrefix(curr, arr[i]);
        }
        if(curr.length() == 0){
            return "-1";
        }
        return curr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLine();
        }
        System.out.println(commonPrefix(arr));
    }
}