import java.util.*;
class SearchInRotatedSortedArray{
    static int search(int[] arr, int key) {
        int i = 0;
        int j = arr.length - 1;
        while(i < j){
            if(arr[i] == key) return i;
            else if(arr[j] == key) return j;
            else if(arr[i] != key) i++;
            else{
                j--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        System.out.println(search(arr, key));
    }
}