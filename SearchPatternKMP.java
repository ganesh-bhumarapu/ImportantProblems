import java.util.*;
class SearchPatternKMP{
    public static ArrayList<Integer> search(String pat, String txt){
        ArrayList<Integer> res = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();
        for(int i = 0; i <= n -m; i++){
            if(txt.substring(i, i + m).equals(pat)){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pat = sc.nextLine();
        String txt = sc.nextLine();
        ArrayList<Integer> ans = search(pat, txt);
        for(int ele : ans)
            System.out.print(ele + " ");
    }
}