/*
1-> store the num along with frequency in a hashmap
create a arraylist store all the array elements
sort the arraylist by using lambda expression
if values are same i.e frequency then check the for keys which is smaller appears first

tc -> O(n logn)
sc -> O(n)
 */
import java.util.*;
class SortingElementByFrequency{
    public static ArrayList<Integer> sortByFrequency(int[] arr){
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num : arr){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(int num : arr){
            res.add(num);
        }
        res.sort((a,b) -> {
            int freqCompare = freqMap.get(b).compareTo(freqMap.get(a));
            if (freqCompare == 0) {
                return a.compareTo(b);
            }
            return freqCompare;
        });
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(sortByFrequency(arr));
    }
}