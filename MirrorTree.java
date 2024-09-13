import java.util.*;
class Node{
    int data;
    Node left, right;
    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class MirrorTree{
    static void mirror(Node node){
        if(node == null) {
            return;
        }
        mirror(node.left);
        mirror(node.right);

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
    /*
    if(node == null){
        return;
    }
    Queue<Node> q = new LinkedList<>();
    q.add(node);
    while(!q.isEmpty()){
        Node curr = q.poll();
        Node temp = curr.left;
        curr.left = curr.right;
        curr.right = temp;

        if(curr.left != null){
            q.add(curr.left);
        }
        if(curr.right != null){
            q.add(curr.right);
        }
    }
     */
    public static Node treeBuilder(Scanner sc){
        System.out.println("Enter the root element: ");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("enter the left chilf of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);

        return root;
    }
   static void printInOrder(Node node) {
        if (node == null) {
            return;
        }

        // Recur on the left child
        printInOrder(node.left);

        // Print the node value
        System.out.print(node.data + " ");

        // Recur on the right child
        printInOrder(node.right);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        mirror(root);
        printInOrder(root);
    }
}