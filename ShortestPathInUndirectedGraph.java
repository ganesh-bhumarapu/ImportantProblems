import java.util.*;
class ShortestPathInUndirectedGraph{
    public static int[] shortestPath(int[][] edges, int n, int m, int src){
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        dist[src] = 0;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        // BFS helps in finding the shortest distance from source node to remaining nodes as it traverses in level wise
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int adjNode : adj.get(node)){
                if(dist[adjNode] == -1){
                    dist[adjNode] = dist[node] + 1;
                    q.add(adjNode);
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] edges = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                edges[i][j] = sc.nextInt();
            }
        }
        int src = sc.nextInt();
        System.out.println(shortestPath(edges, n, m, src));
    }
}