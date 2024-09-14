import java.util.*;
class LongestPrefixSufix{
    static int longestPrefixSufix(String str){
        int[] res = new int[str.length()];
        int i = 1;
        int j = 0;
        while(i < str.length()){
            if(str.charAt(i) == str.charAt(j)){
                res[i] = j + 1;
                j++;
                i++;
            }else{
                if(j == 0){
                    i++;
                }else{
                    j = res[j - 1];
                }
            }
        }
        return res[str.length() - 1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(longestPrefixSufix(str));
    }
}