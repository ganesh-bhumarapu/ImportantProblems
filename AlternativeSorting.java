import java.util.*;
class AlternativeSorting {
    public static ArrayList<Integer> alternateSort(int[] arr) {

        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i <= j) {
            if (i == j) {
                ans.add(arr[i]);
                break;
            } else {
                ans.add(arr[j]);
                j--;
                ans.add(arr[i]);
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> res = alternateSort(arr);
        for(int ele : res){
            System.out.print(ele);
        }
    }
}