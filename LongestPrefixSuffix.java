import java.util.*;
class LongestPrefixSuffix{
    public static int longestPrefixSuffix(String str){
        int[] res = new int[str.length()];
        int i = 1;
        int j = 0;
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(j)){
                res[i] = j + 1;
                i++;
                j++;
            }else {
                if (j == 0) {
                    i++;
                } else {
                    j = res[j - 1];
                }
            }
        }
        return res[str.length() - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestPrefixSuffix(str));
    }
}