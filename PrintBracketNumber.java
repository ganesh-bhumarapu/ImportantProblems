import java.util.*;
class PrintBracketNumber {
    public static ArrayList<Integer> bracketNumber(String str) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
                st.push(count);
                ans.add(count);
            } else if (str.charAt(i) == ')') {
                ans.add(st.pop());
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        ArrayList<Integer> res = bracketNumber(str);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}