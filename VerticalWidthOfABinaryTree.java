import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node (int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
class VerticalWidthOfABinaryTree{
    public static int verticalWidth(Node root){
        if(root == null) return 0;

        Map<Node, Integer> mp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        mp.put(root, 0);
        while(!q.isEmpty()){
            Node current = q.poll();
            int count = mp.get(root);
            if(current.left != null){
                q.add(current.left);
                mp.put(current.left, count);
            }
            if(current.right != null){
                q.add(current.right);
                mp.put(current.right, count);
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int val : mp.values()){
            if(val < min){
                min = val;
            }
            if(val > max){
                max = val;
            }
        }
        return Math.abs(min) + max + 1;
    }
    public static Node treeBuilder(Scanner sc){
        System.out.println("Enter the root element");
        return treeBuilderHelper(sc);
    }
    public static Node treeBuilderHelper(Scanner sc){
        int data = sc.nextInt();
        if(data == -1){
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of "+ data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("Enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        System.out.println(verticalWidth(root));
    }
}