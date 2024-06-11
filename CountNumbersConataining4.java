import java.util.*;
class CountNumbersConataining{
    public static boolean containsDigit4(int number){
        while(number > 0){
            if(number % 10 == 4){
                return true;
            }
            number/=10;
        }
        return false;
    }
    public static int countNumberscontaining4(int n){
        int count = 0;
        for(int i=1;i<=n;i++){
            if(containsDigit4(i)){
                count++;
            }
        }
        return count;
    }
//    public static int countNumberscontaining4(int n){
//        int count = 0;
//        for(int i=1;i<=n;i++){
//            if(Integer.toString(i).contains("4")){
//                count++;
//            }
//        }
//        return count;
//    }
public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int result = countNumberscontaining4(n);
    System.out.println(result);
}
}