import java.util.*;
class LongestValidParentheses{
    public static int longestvalid(String S){
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxLen = 0;
        for(int i = 0; i < S.length(); i++){
            char ch = S.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }else{
                    maxLen = Math.max(maxLen, i - st.peek());
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        System.out.println(longestvalid(S));
    }
}