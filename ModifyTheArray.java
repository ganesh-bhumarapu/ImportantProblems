import java.util.*;
class ModifyTheArray{
    static ArrayList<Integer> modifyAndRearrangeArr(int arr[]) {
        // Complete the function
        int i = 0;
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < n - 1){
            if(arr[i] != 0 && arr[i] == arr[i + 1]){
                arr[i] = 2 * arr[i];
                arr[i + 1] = 0;
                i = i + 2;
            }else{
                i++;
            }
        }
        int count = 0;
        for(int ele : arr){
            if(ele == 0){
                count++;
            }else{
                ans.add(ele);
            }
        }
        while(count > 0){
            ans.add(0);
            count--;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        ArrayList<Integer> res = modifyAndRearrangeArr(arr);
        for(int ele : res){
            System.out.print(ele + " ");
        }
    }
}