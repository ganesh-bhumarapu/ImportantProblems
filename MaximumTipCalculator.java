import java.util.*;
class MaximumTipCalculator{
    static class Pair implements Comparable<Pair>{
        int diff;
        int a;
        int b;
        Pair(int diff, int a, int b){
            this.diff = diff;
            this.a = a;
            this.b = b;
        }
        public int compareTo(Pair other){
            return Integer.compare(this.diff, other.diff);
        }
    }
    public static long maxTip(int n, int x, int y, int[] arr, int[] brr){
        List<Pair> res=new ArrayList<>();

        for(int i=0;i<arr.length;i++){
            res.add(new Pair(Math.abs(arr[i] - brr[i]), arr[i], brr[i]));
        }
        Collections.sort(res, Collections.reverseOrder());

        long ans = 0;
        for(Pair p : res){
            if(x == 0){
                ans+=p.b;
                y--;
            }else if(y == 0){
                ans+=p.a;
            }else{
                if(p.a > p.b){
                    ans+=p.a;
                    x--;
                }else{
                    ans+=p.b;
                    y--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements (n): ");
        int n = sc.nextInt();

        System.out.print("Enter the number of elements you can pick from the first array (x): ");
        int x = sc.nextInt();

        System.out.print("Enter the number of elements you can pick from the second array (y): ");
        int y = sc.nextInt();

        int[] arr = new int[n];
        int[] brr = new int[n];

        System.out.print("Enter elements of the first array: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter elements of the second array: ");
        for (int i = 0; i < n; i++) {
            brr[i] = sc.nextInt();
        }

        // Calculating the maximum tip
        long result = maxTip(n, x, y, arr, brr);
        System.out.println("Maximum tip: " + result);
    }
}
