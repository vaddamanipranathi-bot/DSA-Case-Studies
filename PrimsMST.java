public class PrimsMST {

    static final int V = 5;

    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    void primMST(int graph[][]) {

        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {

            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 &&
                    !mstSet[v] &&
                    graph[u][v] < key[v]) {

                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        int totalCost = 0;

        System.out.println("Selected Connections:");

        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i +
                    "  Cost: " + graph[i][parent[i]]);
            totalCost += graph[i][parent[i]];
        }

        System.out.println("Total Cable Cost = " + totalCost);
    }

    public static void main(String[] args) {

        int graph[][] = {
            {0, 5, 0, 0, 8},
            {5, 0, 4, 0, 9},
            {0, 4, 0, 7, 0},
            {0, 0, 7, 0, 6},
            {8, 9, 0, 6, 0}
        };

        PrimsMST p = new PrimsMST();
        p.primMST(graph);
    }
}