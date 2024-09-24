import java.util.*;
class SmallestWindowInaStringContainingAllTheCharactersOfAnotherString{
    public static String solve(String s, String p){
        if(p == "") return "-1";

        if(s.equals(p)) return p;

        if(p.length() > s.length()) return "-1";

        Map<Character, Integer> pat = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < p.length(); i++){
            pat.put(p.charAt(i), pat.getOrDefault(p.charAt(i), 0) + 1);
        }
        String res = "-1";
        int resLen = Integer.MIN_VALUE;

        int currLen = 0;
        int totalLen = pat.size();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if(pat.containsKey(c) && pat.get(c) == map.get(c)){
                currLen += 1;
            }
            while(currLen == totalLen){
                if((right - left + 1) < resLen){
                    res = s.substring(left, right + 1);
                    resLen = right - left + 1;
                }
                char t = s.charAt(left);
                map.put(t, map.get(t) - 1);
                if(pat.containsKey(t) && map.get(t) < pat.get(t)){
                    currLen -= 1;
                }
                left += 1;
            }
            right += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String p = sc.nextLine();
        String res = solve(s, p);
        System.out.println(res);
    }
}