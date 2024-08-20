import java.util.*;
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
class BurningATree{
    public static void createAdjacencyList(Node root, ArrayList<ArrayList<Integer>> adj){
        if(root == null){
            return;
        }
        if(root.left != null){
            adj.get(root.data).add(root.left.data);
            adj.get(root.left.data).add(root.data);
            createAdjacencyList(root.left, adj);
        }
        if(root.right != null){
            adj.get(root.data).add(root.right.data);
            adj.get(root.right.data).add(root.data);
            createAdjacencyList(root.right, adj);
        }
    }
    public static int getMaxDist(Node root){
        if(root == null){
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(getMaxDist(root.left), getMaxDist(root.right)));
    }
    public static void dfs(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adj, int dist, int[] maxDist){
        vis[node] = true;
        maxDist[0] = Math.max(maxDist[0], dist);
        for(Integer it : adj.get(node)){
            if(vis[it] == false){
                dfs(it, vis, adj, dist + 1, maxDist);
            }
        }
    }
    public static int minTime(Node root, int target){
        int n = getMaxDist(root) + 1;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        createAdjacencyList(root, adj);
        boolean[] vis = new boolean[n];
        int dist = 0;
        int[] maxDist = new int[1];
        dfs(target, vis, adj, dist, maxDist);

        return maxDist[0];
    }

    public static Node buildTree(Scanner sc) {
        System.out.println("Enter the root node value:");
        int rootValue = sc.nextInt();
        Node root = new Node(rootValue);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.println("Enter the left child of " + current.data + " (enter -1 for no child):");
            int leftValue = sc.nextInt();
            if (leftValue != -1) {
                current.left = new Node(leftValue);
                queue.add(current.left);
            }

            System.out.println("Enter the right child of " + current.data + " (enter -1 for no child):");
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

        Node root = buildTree(sc);

        System.out.println("Enter the target node value:");
        int target = sc.nextInt();

        int result = minTime(root, target);
        System.out.println("Minimum time to burn the tree from target node " + target + " is: " + result);

        sc.close();
    }
}