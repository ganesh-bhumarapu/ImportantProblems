import java.util.*;
class AlternativePositiveAndNegative {
    static void rearrange(ArrayList<Integer> arr) {
        // code here
        int[] pos = new int[arr.size()];
        int[] neg = new int[arr.size()];

        int a = 0;
        int b = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) >= 0) {
                pos[a++] = arr.get(i);
            } else {
                neg[b++] = arr.get(i);
            }
        }
        int i = 0, x = 0, y = 0;
        while (i < arr.size() && x < a && y < b) {
            if (i % 2 == 0) {
                arr.set(i, pos[x++]);
            } else {
                arr.set(i, neg[y++]);
            }
            i++;
        }
        while (x < a) {
            arr.set(i++, pos[x++]);
        }
        while (y < b) {
            arr.set(i++, neg[y++]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        while(sc.hasNextInt()){
            arr.add(sc.nextInt());
        }
         rearrange(arr);
        for(int ele : arr){
            System.out.print(ele + " ");
        }
    }
}