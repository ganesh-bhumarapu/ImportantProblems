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
class checkForBst{
    public static boolean isBst(Node root){
        return isBstHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    public static boolean isBstHelper(Node node, int min, int max){
        if(node == null){
            return true;
        }
        if(node.data <= min || node.data >= max){
            return false;
        }
        return (isBstHelper(node.left, min, node.data) && isBstHelper(node.right, node.data, max));
    }
    public static Node treeBuilder(Scanner sc){
        System.out.println("enter the root element");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left child of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        System.out.println(isBst(root));
    }
}