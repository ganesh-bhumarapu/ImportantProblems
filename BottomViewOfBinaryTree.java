import java.util.*;
class Pair{
    Node node;
    int hd;
    Pair(Node node, int hd){
        this.node = node;
        this.hd = hd;
    }
}
class BottomViewOfBinaryTree {
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Pair> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair(root, 0));
        while (!q.isEmpty()) {
            Pair it = q.remove();
            Node temp = it.node;
            int hd = it.hd;

            map.put(hd, temp.data);

            if (temp.left != null) {
                q.add(new Pair(temp.left, hd - 1));
            }
            if (temp.right != null) {
                q.add(new Pair(temp.right, hd + 1));
            }
        }
        for (Integer val : map.values()) {
            ans.add(val);
        }
        return ans;
    }

    public static Node treeBuilder(Scanner sc) {
        System.out.println("Enter the root element");
        return treeBuildHelper(sc);
    }

    public static Node treeBuildHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter left child of " + data + ":");
        root.left = treeBuildHelper(sc);
        System.out.println("Enter right child of " + data + ":");
        root.right = treeBuildHelper(sc);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        ArrayList<Integer> res = bottomView(root);
        for(Integer val : res){
            System.out.println(val);
        }
    }
}