import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class ArrayToBST{
    public static Node sortedArrayToBst(int[] nums){
        return sortedArrayToBstHelper(nums, 0, nums.length - 1);
    }
    public static Node sortedArrayToBstHelper(int[] nums, int i, int j){
        if(i > j){
            return null;
        }
        int mid = i + (j - i)/2;
        Node current = new Node(nums[mid]);
        current.left = sortedArrayToBstHelper(nums, i, mid - 1);
        current.right = sortedArrayToBstHelper(nums, mid + 1, j);
        return current;
    }
    public static void inorderTraversal(Node root){
        if(root != null){
            inorderTraversal(root.left);
            System.out.println(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        Node root = sortedArrayToBst(nums);
        System.out.println("In-order traversal of the constructed BST:");
        inorderTraversal(root);
    }
}