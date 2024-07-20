import java.util.*;
class Node{
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class RemoveHalfNode{
    public static Node removeHalfNode(Node root) {
        if (root == null) {
            return null;
        }
        root.left = removeHalfNode(root.left);
        root.right = removeHalfNode(root.right);

        if (root.left == null && root.right == null) return root;

        if (root.left == null) return root.right;

        if (root.right == null) return root.left;

        return root;
    }
    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.println(root.data + " ");
        inorderTraversal(root.right);
    }
    public static Node treeBuilder(Scanner sc) {
        System.out.println("Enter root element ");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
         int data = sc.nextInt();
         if(data == -1) {
             return null;
         }
         Node root = new Node(data);
        System.out.println("enter left child of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter right chilf of "+ data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);

        root = removeHalfNode(root);
        inorderTraversal(root);
        System.out.println();
    }
}