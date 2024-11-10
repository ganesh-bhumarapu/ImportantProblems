import java.util.*;
class UnionOfTwoSortedArraysWithDistinctElements {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                ans.add(a[i]);
                i++;
                j++;
            }else if(a[i] > b[j]){
                ans.add(b[j]);
                j++;
            }else{
                ans.add(a[i]);
                i++;
            }
        }
        while(i < a.length){
            ans.add(a[i]);
            i++;
        }
        while(j < b.length){
            ans.add(b[j]);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int m = sc.nextInt();
        int[] b = new int[m];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            b[i] = sc.nextInt();
        }
        ArrayList<Integer> res = findUnion(a,b);
        for(int ele : res){
            System.out.print(ele);
        }
    }
}