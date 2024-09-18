import java.util.*;
class ParenthesisChecker{
    public static boolean isPar(String str){
        Stack<Character> st = new Stack<>();
        for(int i = 0;i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '{' || ch == '(' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                if(ch == '}' && st.peek() == '{' ){
                    st.pop();
                }else if(ch == ']' && st.peek() == '['){
                    st.pop();
                }else if(ch == ')' && st.peek() == '('){
                    st.pop();
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str);
    }
}