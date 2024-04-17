package Homework3;

import java.util.Arrays;

public class BellmanFord {


    static final int INF = Integer.MAX_VALUE;


    static void bellmanFord(int[][] graph, int src) {
        int V = graph.length; // 顶点的数量
        int[] dist = new int[V]; // 存储从源到每个顶点的距离

        // 初始化距离数组，除了源点到自己的距离为0，到其他所有点的距离为无穷大
        Arrays.fill(dist, INF);
        dist[src] = 0;

        // 进行V-1次遍历来“松弛”所有边，这可以保证找到最短路径（如果存在的话）
        for (int i = 0; i < V - 1; ++i) {
            // 内层双重循环遍历所有边
            for (int j = 0; j < V; ++j) {
                for (int k = 0; k < V; ++k) {
                    // 如果从j到k存在边，并且从源到j的距离不是无穷大
                    // 并且如果通过j到k可以使得源到k的距离更短，则进行松弛操作
                    if (graph[j][k] != INF && dist[j] != INF && dist[j] + graph[j][k] < dist[k]) {
                        dist[k] = dist[j] + graph[j][k];
                    }
                }
            }
        }

        // 检测图中是否存在负权重环路
        for (int j = 0; j < V; ++j) {//第v次松弛仍能更新路径说明负环
            for (int k = 0; k < V; ++k) {
                if (graph[j][k] != INF && dist[j] != INF && dist[j] + graph[j][k] < dist[k]) {
                    System.out.println("负环");
                    return;
                }
            }
        }

        // 打印从源到各顶点的最短路径长度
        printArr(dist, V);
    }


    static void printArr(int[] dist, int V) {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; ++i)
            System.out.println((char)('A' + i) + "\t\t" + (dist[i] == INF ? "INF" : dist[i]));
    }


    public static void main(String[] args) {
        // 邻接矩阵表示图，其中INF表示没有直接连接的边
        int[][] graph = {
                {INF, -1, 3, INF, INF},
                {INF, INF, 3, 2, 2},
                {INF, INF, INF, INF, INF},
                {INF, 1, 5, INF, INF},
                {INF, INF, INF, -3, INF}
        };

        // 以顶点A为源点，执行贝尔曼-福特算法
        bellmanFord(graph, 0); // 0代表顶点A
    }
}
