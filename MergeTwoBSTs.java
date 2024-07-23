import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class MergeTwoBSTs {
    public static void inorder(Node root, List<Integer> bst) {
        if (root == null) {
            return;
        }
        inorder(root.left, bst);
        bst.add(root.data);
        inorder(root.right, bst);
    }

    public static List<Integer> merge(Node root1, Node root2) {
        List<Integer> bst1 = new ArrayList<>();
        List<Integer> bst2 = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        inorder(root1, bst1);
        inorder(root2, bst2);

        int i = 0;
        int j = 0;

        while (i < bst1.size() && j < bst2.size()) {
            if (bst1.get(i) < bst2.get(j)) {
                ans.add(bst1.get(i));
                i++;
            } else {
                ans.add(bst2.get(j));
                j++;
            }
        }

        while (i < bst1.size()) {
            ans.add(bst1.get(i));
            i++;
        }

        while (j < bst2.size()) {
            ans.add(bst2.get(j));
            j++;
        }

        return ans;
    }

    public static Node treeBuilder(Scanner sc) {
        System.out.println("Enter the root element");
        return treeBuilderHelper(sc);
    }

    public static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        Node root = new Node(data);
        System.out.println("Enter the left child of " + data + " :");
        root.left = treeBuilderHelper(sc);
        System.out.println("Enter the right child of " + data + " :");
        root.right = treeBuilderHelper(sc);
        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Build first BST");
        Node root1 = treeBuilder(sc);
        System.out.println("Build second BST");
        Node root2 = treeBuilder(sc);
        List<Integer> res = merge(root1, root2);
        System.out.println("Merged BST in sorted order:");
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
