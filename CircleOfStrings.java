import java.util.*;
class CircleOfStrings{
        public static int isCircle(String arr[]) {
            // count indegree and outdegree and form a directed graph
            int[] indegree = new int[26];
            int[] outdegree = new int[26];

            List<List<Integer>> graph = new ArrayList<>();
            for(int i = 0; i < 26; i++){
                graph.add(new ArrayList<>());
            }

            for(String str : arr){
                int first = str.charAt(0) - 'a';
                int last = str.charAt(str.length() - 1) - 'a';

                graph.get(first).add(last);
                outdegree[first]++;
                indegree[last]++;
            }
            // check whether the indegree and outdegree are same are not
            for(int i = 0; i < 26; i++){
                if(indegree[i] != outdegree[i]){
                    return 0;
                }
            }
            return isStronglyConnected(graph, arr[0].charAt(0) - 'a');
        }
        private static int isStronglyConnected(List<List<Integer>> graph, int start){
            boolean[] vis = new boolean[26];
            dfs(graph, start, vis);

            // check whether the all the nonzero vertices visited are not
            for(int i = 0; i < 26; i++){
                if(graph.get(i).size() > 0 && !vis[i]){
                    return 0;
                }
            }
            return 1;
        }
        private static void dfs(List<List<Integer>> graph, int node, boolean[] vis) {
            vis[node] = true;
            for (int it : graph.get(node)) {
                if (!vis[it]) {
                    dfs(graph, it, vis);
                }
            }
        }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }
        System.out.println(isCircle(arr));
    }
}