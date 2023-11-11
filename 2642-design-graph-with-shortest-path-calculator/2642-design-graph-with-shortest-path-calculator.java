class Graph {
    int maxVal = 1000000000;
    int[][] graph = null;
    int n = -1;
    public Graph(int n, int[][] edges) {
        this.graph = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(graph[i], maxVal);
        }

        for(int i=0;i<n;i++){
            graph[i][i] = 0;
        }
        this.n = n;

        for(int[] edge: edges){
            graph[edge[0]][edge[1]] = edge[2];
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }
    
    public void addEdge(int[] edge) {
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j] = Math.min(graph[i][j], graph[i][edge[0]] + graph[edge[1]][j] + edge[2]);
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return graph[node1][node2] == maxVal?-1: graph[node1][node2];
    }
}