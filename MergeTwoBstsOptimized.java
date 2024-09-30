import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class MergeTwoBstsOptimized {

    // Function to merge two BSTs in sorted order
    public static List<Integer> mergeBSTSort(Node root1, Node root2) {
        List<Integer> res = new ArrayList<>();
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();

        Node curr1 = root1, curr2 = root2;

        while (curr1 != null || !st1.isEmpty() || curr2 != null || !st2.isEmpty()) {
            // Push all the left children of root1 to st1
            while (curr1 != null) {
                st1.push(curr1);
                curr1 = curr1.left;
            }
            // Push all the left children of root2 to st2
            while (curr2 != null) {
                st2.push(curr2);
                curr2 = curr2.left;
            }

            // Compare the top of the stacks and add the smaller value to the result
            if (st2.isEmpty() || (!st1.isEmpty() && st1.peek().data <= st2.peek().data)) {
                curr1 = st1.pop();
                res.add(curr1.data); // Add to the result
                curr1 = curr1.right; // Move to the right subtree
            } else {
                curr2 = st2.pop();
                res.add(curr2.data); // Add to the result
                curr2 = curr2.right; // Move to the right subtree
            }
        }

        return res;
    }

    // Helper method to build a binary tree based on user input
    public static Node treeBuilder(Scanner sc) {
        System.out.println("Enter the root element (-1 for null):");
        return treeBuilderHelper(sc);
    }

    // Recursive function to build the tree
    public static Node treeBuilderHelper(Scanner sc) {
        int data = sc.nextInt();
        if (data == -1) {
            return null; // Null node
        }

        Node node = new Node(data); // Create a new node

        // Recursively build the left and right children
        System.out.println("Enter the left child of " + data + " (-1 for null):");
        node.left = treeBuilderHelper(sc);

        System.out.println("Enter the right child of " + data + " (-1 for null):");
        node.right = treeBuilderHelper(sc);

        return node; // Return the constructed node
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Building the first tree
        System.out.println("Build the first BST:");
        Node root1 = treeBuilder(sc);

        // Building the second tree
        System.out.println("Build the second BST:");
        Node root2 = treeBuilder(sc);

        // Merging the two BSTs
        List<Integer> mergedResult = mergeBSTSort(root1, root2);

        // Printing the merged sorted list
        System.out.println("Merged BST in sorted order: " + mergedResult);
    }
}
