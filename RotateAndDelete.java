import java.util.*;
class RotateAndDelete{
    public static int rotateDelete(ArrayList<Integer> arr){
        int n = arr.size();
        int i = 1;
        while(i < (n/2) + 1){// after i reaching half of the size of list we get the result even if we continue to last we left with the same element
            int temp = arr.get(arr.size() - 1);
            arr.add(0, temp);
            arr.remove(arr.size() - i);
            i++;
        }
        return arr.get(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            int ele = sc.nextInt();
            arr.add(ele);
        }
        System.out.println(rotateDelete(arr));
    }
}