import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class RootToLeafPathsSum {

    public static int treePathSum(Node root) {
        return treePathSumHelper(root, 0);
    }

    private static int treePathSumHelper(Node root, int currentSum) {
        if (root == null) return 0;

        currentSum = currentSum * 10 + root.data;

        if (root.left == null && root.right == null) {
            return currentSum;
        }

        int leftSum = treePathSumHelper(root.left, currentSum);
        int rightSum = treePathSumHelper(root.right, currentSum);

        return leftSum + rightSum;
    }

    public static Node treeBuilder(Scanner sc) {
        System.out.print("Enter the root value: ");
        int rootValue = sc.nextInt();
        Node root = new Node(rootValue);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print("Enter the left child of " + current.data + " (or -1 for no child): ");
            int leftValue = sc.nextInt();
            if (leftValue != -1) {
                current.left = new Node(leftValue);
                queue.add(current.left);
            }

            System.out.print("Enter the right child of " + current.data + " (or -1 for no child): ");
            int rightValue = sc.nextInt();
            if (rightValue != -1) {
                current.right = new Node(rightValue);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = treeBuilder(sc);
        System.out.println("Sum of all root-to-leaf paths: " + treePathSum(root));
        sc.close();
    }
}
