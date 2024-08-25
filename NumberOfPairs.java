import java.util.*;
class NumberOfPairs{
    public static long countPairs(int[] x, int[] y, int M, int N){
        long ans = 0;
        int n0 = 0, n1 = 0, n2 = 0, n3 = 0, n4 = 0;
        // count  the occurences of 0, 1, 2, 3 in y array
        for(int i = 0; i < N; i++){
            if(y[i] == 0) n0++;
            if(y[i] == 1) n1++;
            if(y[i] == 2) n2++;
            if(y[i] == 3) n3++;
            if(y[i] == 4) n4++;
        }
        Arrays.sort(y);
        for(int i = 0; i < M; i++){
            int index = getCeil(y, x[i], N);
            if(index < 0){
                index = N;
            }
            if(x[i] == 0){
                continue;
            }
            if(x[i] == 1){
                ans += n0;
            }
            if(x[i] == 2){
                ans += (N - index - 1) + n0 + n1 - n3 - n4;
            }
            if(x[i] == 3){
                ans += (N - index - 1) + n0 + n1 + n2;
            }
            else{
                ans += (N - index - 1) + n0 + n1;
            }
        }
        return ans;
    }
    public static int getCeil(int[] y, int x, int N){
        int ceil = -1;
        int low = 0;
        int high = N - 1;
        while(low <= high){
            int mid = low + (high - low)/ 2;
            if(y[mid] > x){
                ceil = mid;
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] x = new int[M];
        int[] y = new int[N];
        for(int i = 0; i < N; i++){
            y[i] = sc.nextInt();
        }
        for(int i = 0; i < M; i++){
            x[i] = sc.nextInt();
        }
        System.out.println(countPairs(x, y, M, N));
    }
}