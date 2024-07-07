import java.util.*;
class AncestorsInABinaryTree{
    public static ArrayList<Integer> ancestors(Node root, int target){
        ArrayList<Integer> ans = new ArrayList<>();
        ancestorsHelper(root, target, ans);
        return ans;
    }
    public static boolean ancestorsHelper(Node root, int target, ArrayList<Integer> ans) {
        if (root == null) return false;

        if (root.data == target) return true;

        if (ancestorsHelper(root.left, target, ans) || ancestorsHelper(root.right, target, ans)) {
            ans.add(root.data);
            return true;
        }
        return false;
    }
    public static Node treeBuilder(Scanner sc){
        System.out.println("Enter the root node");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left child of "+ data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of "+ data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        int target = sc.nextInt();
        ArrayList<Integer> res = ancestors(root, target);
        for(int ele : res){
            System.out.println(ele);
        }
    }
}