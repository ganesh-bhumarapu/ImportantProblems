import java.util.*;
class kPangrams{
    public static boolean iskpangrams(String str, int k){
        String mystr = str.replaceAll(" ", "");
        if (mystr.length() < 26 ) return false;
        Set<Character> set = new LinkedHashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : mystr.toCharArray()){
            if(set.add(c)){
                sb.append(c);
            }
        }
        if((26 - sb.toString().length()) <= k) return true;
       return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int k = sc.nextInt();
        boolean res = iskpangrams(str, k);
        System.out.println(res);
    }
}