import java.util.*;

class SplitArrayInThreeEqualSumSubarray {
    public static List<Integer> findSplit(int[] arr) {
        List<Integer> res = new ArrayList<>();

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        // If the total sum isn't divisible by 3, we can't split into three equal parts
        if (totalSum % 3 != 0) {
            res.add(-1);
            res.add(-1);
            return res;
        }

        int targetSum = totalSum / 3;
        int leftSum = 0, rightSum = 0;
        int leftIndex = -1, rightIndex = -1;

        // Find the left boundary for the first partition
        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i];
            if (leftSum == targetSum) {
                leftIndex = i;
                break;
            }
        }

        // Find the right boundary for the third partition
        for (int i = arr.length - 1; i > leftIndex; i--) {
            rightSum += arr[i];
            if (rightSum == targetSum) {
                rightIndex = i;
                break;
            }
        }

        // Validate the middle partition
        int middleSum = 0;
        for (int i = leftIndex + 1; i < rightIndex; i++) {
            middleSum += arr[i];
        }

        if (middleSum == targetSum && leftIndex != -1 && rightIndex != -1) {
            res.add(leftIndex);
            res.add(rightIndex);
        } else {
            res.add(-1);
            res.add(-1);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> ans = findSplit(arr);
        for(int ele : ans){
            System.out.print(ele + " ");
        }
    }
}
