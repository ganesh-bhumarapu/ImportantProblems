
// To solve this problem
// 1 -> Build the graph based on given dictionary
// 2 -> perform toposort on the graph using dfs
// 3 -> convert the array which we got from toposort to form an required ordered string


import java.util.*;

class AlienDictionary {
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[node] = true;
        for (int it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis, st);
            }
        }
        st.push(node);
    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int x = 0; x < V; x++) {
            if (!vis[x]) {
                dfs(x, adj, vis, st);
            }
        }
        int[] arr = new int[V];
        for (int i = 0; i < V; i++) {
            arr[i] = st.pop();
        }
        return arr;
    }

    public static String findOrder(String[] dict, int n, int k) {
        // Form a graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int x = 0; x < k; x++) {
            adj.add(new ArrayList<>());
        }

        for (int x = 0; x < n - 1; x++) {
            String s1 = dict[x];
            String s2 = dict[x + 1];
            int len = Math.min(s1.length(), s2.length());

            for (int y = 0; y < len; y++) {
                if (s1.charAt(y) != s2.charAt(y)) {
                    adj.get(s1.charAt(y) - 'a').add(s2.charAt(y) - 'a');
                    break;  // Found the first differing character, break the loop
                }
            }
        }

        // Perform topological sort
        int[] ans = topoSort(k, adj);

        // Convert the array to the required ordered string
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < k; i++) {
            s.append((char) ('a' + ans[i]));
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine(); // Consume the remaining newline after nextInt()
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) {
            dict[i] = sc.nextLine();
        }
        String str = findOrder(dict, n, k);
        System.out.println(str);
    }
}
