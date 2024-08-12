import java.util.*;
class MedianOfTwoSortedArrays{
    public static int sumofMiddleElements(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;
        List<Integer> merged = new ArrayList<>();
        while(i < n && j < m){
            if(arr1[i] <= arr2[j]){
                merged.add(arr1[i]);
                i++;
            }else{
                merged.add(arr2[j]);
                j++;
            }
        }
        while(i < n){
            merged.add(arr1[i]);
            i++;
        }
        while(j < m){
            merged.add(arr2[j]);
            j++;
        }
        int size = merged.size();
        if(size % 2 == 1){
            return merged.get(size / 2);
        }else{
            int mid = size / 2;
            return merged.get(mid - 1) + merged.get(mid);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[m];
        for(int i = 0; i < n; i++){
            arr1[i] = sc.nextInt();
        }
        for(int j = 0; j < m; j++){
            arr2[j] = sc.nextInt();
        }
        System.out.println(sumofMiddleElements(arr1, arr2));
    }
}