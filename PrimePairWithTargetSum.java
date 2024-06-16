/*
intution
1 -> get the list of prime numbers that exist lessthan or equal to the given number
2 -> then check the sum of i and j which equals the given number
 */


import java.util.*;
class PrimePairWithTargetSum{

    public static List<Integer> getPrimesUpTo(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for(int i = 2; i*i <= n; i++){
            if(isPrime[i]){
                for(int j = i*i; j <= n;j += i){
                    isPrime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= n; i++){
            if(isPrime[i]){
                primes.add(i);
            }
        }
        return primes;
    }
    public static ArrayList<Integer> getPrimes(int n){
        List<Integer> primes = getPrimesUpTo(n);
        int i =0;
        int j = primes.size() - 1;
        ArrayList<Integer> ans = new ArrayList<>();
        while(i < j){
            int sum = primes.get(i) + primes.get(j);
            if(sum == n){
                ans.add(primes.get(i));
                ans.add(primes.get(j));
                return ans;
            }else if(sum < n){
                i++;
            }else{
                j--;
            }
        }
        ans.add(-1);
        ans.add(-1);
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> finalRes = getPrimes(n);
        for(int i = 0;i< 2; i++){
            System.out.println(finalRes.get(i));
        }
    }
}