import java.util.*;
class KthElementOfTwoArrays{
    public static int kthElement(int[] a, int[] b, int k){
        int i = a.length - 1;
        int j = 0;
        while(i >= 0 && j < b.length){
            if(a[i] > b[j]){
                int temp = a[i];
                a[i] = b[j];
                b[j] = temp;
                i--;
                j++;
            }else{
                break;
            }
        }
        Arrays.sort(a);
        Arrays.sort(b);
        if(k > a.length) return b[k - b.length - 1];

        return a[k];
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
        int k = sc.nextInt();
        System.out.println(kthElement(a,b,k));
    }
}