public class AirLinkRoute {
    static final int INF = 99999;

    public static void main(String[] args) {
        String[] airports = {"HYD", "DEL", "MUM", "BLR", "CHN"};
        int V = airports.length;

        int[][] graph = {
                {0, 4, 2, 0, 0},
                {4, 0, 1, 5, 0},
                {2, 1, 0, 7, 9},
                {0, 5, 7, 0, 2},
                {0, 0, 9, 2, 0}
        };

        System.out.println("AIRLINK ROUTE OPTIMIZATION SYSTEM");
        System.out.println("DIJKSTRA SHORTEST PATH ANALYSIS\n");

        System.out.println("Airport Network:");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " = " + airports[i]);
        }

        int[] dist = dijkstra(graph, 0);

        System.out.println("\nSHORTEST ROUTES FROM HYD\n");
        for (int i = 0; i < V; i++) {
            System.out.println("HYD -> " + airports[i] + " = " + dist[i] + " KM");
        }

        System.out.println("\nTime Complexity:");
        System.out.println("Dijkstra : O((V+E) log V)");
    }

    static int[] dijkstra(int[][] graph, int src) {
        int V = graph.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = INF;
        }
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, visited);
            visited[u] = true;

            for (int v = 0; v < V; v++) {
                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != INF &&
                        dist[u] + graph[u][v] < dist[v]) {
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }
        return dist;
    }

    static int minDistance(int[] dist, boolean[] visited) {
        int min = INF, index = -1;

        for (int i = 0; i < dist.length; i++) {
            if (!visited[i] && dist[i] < min) {
                min = dist[i];
                index = i;
            }
        }
        return index;
    }
}