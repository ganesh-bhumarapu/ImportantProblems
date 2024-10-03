import java.util.*;
class MajorityVote{
    public static List<Integer> getMajority(List<Integer> nums){
        // Using BOYER - MOORE ALGORITHM
        // FINDING THE POSSIBLE CANDIDATES

        int n = nums.size();

        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;

        for(int num : nums){
            if(candidate1 == num){
                count1++;
            }else if(candidate2 == num){
                count2++;
            }else if(count1 == 0){
                candidate1 = num;
            }else if(count2 == 0){
                candidate2 = num;
            }else{
                count1--;
                count2--;
            }
        }
        //vadlidating the possible candidates
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(candidate1 == num){
                count1++;
            }else if(candidate2 == num){
                count2++;
            }
        }
        List<Integer> res = new ArrayList<>();
        if(count1 > n/3){
            res.add(candidate1);
        }else{
            res.add(candidate2);
        }
        if(res.isEmpty()){
            res.add(-1);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int ele = sc.nextInt();
            res.add(ele);
        }
        List<Integer> ans = getMajority(res);
        for(int ele : ans){
            System.out.print(ele + " ");
        }
    }
}