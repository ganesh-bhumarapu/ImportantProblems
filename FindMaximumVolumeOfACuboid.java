import java.util.*;
class FindMaximumVolumeOfACuboid{
    public static double solve(double perimeter, double area){
        double l = (perimeter - Math.sqrt(perimeter * perimeter - 24 * area))/12;
        double b = l;
        double h = (perimeter / 4) - 2 * l;
        double volume = l * b * h;
        return Math.round(volume * 100.0)/100.0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double perimeter = sc.nextDouble();
        double area = sc.nextDouble();
        System.out.println(solve(perimeter,area));
    }
}