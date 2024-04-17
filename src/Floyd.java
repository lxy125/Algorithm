public class Floyd {

    static final int INF = 100000000; // 设置一个较大的无穷大值

    static void floydWarshall(int[][] graph) {
        int V = graph.length;
        int[][] dist = new int[V][V];

        // 初始化距离矩阵
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                dist[i][j] = graph[i][j] == 0 && i != j ? INF : graph[i][j];
            }
        }

        // 弗洛伊德算法核心：三重循环
        for (int k = 0; k < V; k++) { // 选择中间顶点
            for (int i = 0; i < V; i++) { // 选择起点
                for (int j = 0; j < V; j++) { // 选择终点
                    // 如果通过顶点k的路径比直接路径更短，则更新
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 检测负权重环
        for (int k = 0; k < V; k++) {
            if (dist[k][k] < 0) {
                System.out.println("存在负权重环");
                return;
            }
        }

        // 打印最终的所有点对的最短路径
        printSolution(dist);
    }

    static void printSolution(int[][] dist) {
        System.out.println("各顶点对之间的最短距离矩阵如下：");
        for (int i = 0; i < dist.length; ++i) {
            for (int j = 0; j < dist.length; ++j) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] graph = {
                {INF, -1, 3, INF, INF},
                {INF, INF, 3, 2, 2},
                {INF, INF, INF, INF, INF},
                {INF, 1, 5, INF, INF},
                {INF, INF, INF, -3, INF}
        };

        floydWarshall(graph);
    }
}
