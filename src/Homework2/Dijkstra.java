package Homework2;


//             0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15
//          0  -  5  3  -  -  -  -  -  -  -  -  -  -  -  -  -
//          1  -  -  -  1  3  6  -  -  -w  -  -  -  -  -  -  -
//          2  -  -  -  -  -  -  8  7  6  -  -  -  -  -  -  -
//          3  -  -  -  -  -  -  -  -  6  8  -  -  -  -  -  -
//          4  -  -  -  -  -  -  -  -  3  5  -  -  -  -  -  -
//          5  -  -  -  -  -  -  -  -  -  -  3  3  -  -  -  -
//          6  -  -  -  -  -  -  -  -  -  -  -  8  4  -  -  -
//          7  -  -  -  -  -  -  -  -  -  -  -  -  2  2  -  -
//          8  -  -  -  -  -  -  -  -  -  -  -  -  -  1  2  -
//          9  -  -  -  -  -  -  -  -  -  -  -  -  -  3  3  -
//          10 -  -  -  -  -  -  -  -  -  -  -  -  -  -  3  5
//          11 -  -  -  -  -  -  -  -  -  -  -  -  -  -  5  2
//          12 -  -  -  -  -  -  -  -  -  -  -  -  -  -  6  6
//          13 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  4
//          14 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  3
//          15 -  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -

import java.util.Arrays;

public class Dijkstra {

    static final int INF = Integer.MAX_VALUE;
    static final int V = 16; // 图中的节点数

    public static void main(String[] args) {
        int[][] graph = new int[V][V];
        // 初始化图的所有边为无穷大
        for (int[] row : graph) {
            Arrays.fill(row, INF);
        }

        graph[0][1] = 5;
        graph[0][2] = 3;
        graph[1][3] = 1;
        graph[1][4] = 3;
        graph[1][5] = 6;
        graph[2][6] = 8;
        graph[2][7] = 7;
        graph[2][8] = 6;
        graph[3][8] = 6;
        graph[3][9] = 8;
        graph[4][8] = 3;
        graph[4][9] = 5;
        graph[5][10] = 3;
        graph[5][11] = 3;
        graph[6][12] = 8;
        graph[6][13] = 4;
        graph[7][13] = 2;
        graph[7][14] = 2;
        graph[8][13] = 1;
        graph[8][14] = 2;
        graph[9][14] = 3;
        graph[9][15] = 3;
        graph[10][15] = 5;
        graph[11][15] = 2;
        graph[12][15] = 6;
        graph[13][15] = 4;
        graph[14][15] = 3;



        dijkstra(graph, 0);
    }

    public static void dijkstra(int[][] graph, int src) {
        int[] dist = new int[V]; // 起点到各顶点的最短距离
        boolean[] state = new boolean[V]; // state[v]为true，表示已处理


        Arrays.fill(dist, INF);
        Arrays.fill(state, false);


        dist[src] = 0;

        // 找到所有顶点的最短路径
        for (int count = 0; count < V - 1; count++) {
            // 选择一个最小距离的顶点，从尚未处理的顶点集合中
            int u = minDistance(dist, state);


            state[u] = true;


            for (int v = 0; v < V; v++) {

                if (!state[v] && graph[u][v] != INF &&
                        dist[u] != INF && dist[u] + graph[u][v] < dist[v]) {//两点间有一条边且起点可达这个点
                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        // 打印计算出的最短距离
        printSolution(dist);
    }
    
    //找出未处理的节点中距离最小的节点
    public static int minDistance(int[] dist, boolean[] state) {
        int min = INF, min_index = -1;

        for (int v = 0; v < V; v++) {
            if (!state[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        }

        return min_index;
    }


    public static void printSolution(int[] dist) {
        System.out.println("节点编号 \t 最短距离");
        for (int i = 0; i < V; i++) {
            System.out.println(i + " \t\t\t " + dist[i]);
        }
    }
}

