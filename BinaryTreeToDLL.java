import java.util.*;
class Node{
    int data;
    Node left,right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class BinaryTreeToDLL{
    static Node head = null;
    static Node prev = null;
    public static Node bToDLL(Node root) {
        if (root == null) {
            return null;
        }//inorder traversal
        bToDLL(root.left);
        if (prev == null) {// initial state
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        bToDLL(root.right);
        return head;
    }
    public static Node treeBuilder(Scanner sc){
        System.out.println("Enter the root element ");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
        int data = sc.nextInt();
        if(data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of" + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("Eneter the right child of" + data + " :");
        root.right = treeBuilderHelper(sc);

        return root;
    }
    public static void printDLL(Node head){
        Node curr = head;
        System.out.println("Doubly Linked List: ");
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.right;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        Node dllHead = bToDLL(root);

        printDLL(dllHead);
    }
}