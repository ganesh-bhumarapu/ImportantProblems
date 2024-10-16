import java.util.*;
class TwoSwaps{
    public static boolean twoswaps(List<Integer> arr){
        int swap = 0;
        for(int i = 0; i < arr.size(); i++){
            while(i + 1 != arr.get(i)){
                swap++;
                if(swap > 2) return false;

                int temp = arr.get(arr.get(i) - 1);
                arr.set(arr.get(i) - 1, arr.get(i));
                arr.set(i, temp);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int ele = sc.nextInt();
            arr.add(ele);
        }
        System.out.println(twoswaps(arr));
    }
}