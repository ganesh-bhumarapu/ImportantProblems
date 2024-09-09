import java.util.*;
class Sort0s1s2s{
    public static void sort(ArrayList<Integer> arr){
        int low = 0;
        int mid = 0;
        int high = arr.size() - 1;
        while(mid <= high){
            if(arr.get(mid) == 0) {
                swap(arr, low, mid);
            }else if(arr.get(mid) == 1){
                mid++;
            }else{
                swap(arr, high, mid);
                high--;
            }
        }
    }
    private static void swap(ArrayList<Integer> arr, int a, int b){
        int temp = arr.get(a);
        arr.set(a, arr.get(b));
        arr.set(b, temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 0; i < n; i++){
            arr.add(sc.nextInt());
        }
       sort(arr);
        for(int i = 0; i < n; i++){
            System.out.println(arr.get(i) + " ");
        }
    }
}