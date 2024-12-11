import java.util.*;
class MergeWithoutExtraSpace{
    public static void merge(int[] a, int[] b){
        int n = a.length;
        int m = b.length;
        int i = n - 1;
        int j = 0;
        while(i >= 0 && j < m){
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            }else {
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        merge(a,b);
        for(int ele : a){
            System.out.print(ele + " ");
        }
        for(int ele : b){
            System.out.print(ele + " ");
        }
    }
}