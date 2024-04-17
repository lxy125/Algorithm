package Homework3;
import java.util.Arrays;
import java.util.Comparator;


class Item {
    int value, weight;
    Item(int v, int w) { value = v; weight = w; }
}

public class Knapsack {


    public static double fractionalKnapsack(Item[] items, int capacity) {
        // 按照价值/重量比降序对物品进行排序
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare((double)b.value / b.weight, (double)a.value / a.weight);
            }
        });

        double totalValue = 0; // 总价值
        int currentWeight = 0; // 当前重量

        // 遍历排序后的物品数组
        for (Item item : items) {
            if (currentWeight + item.weight <= capacity) {
                // 如果当前物品可以完全装入背包，则全部装入
                currentWeight += item.weight;
                totalValue += item.value;
            } else {
                // 否则只装入部分物品，直到背包满
                int remainingCapacity = capacity - currentWeight;
                totalValue += ((double)item.value / item.weight) * remainingCapacity;
                break;
            }
        }
        return totalValue; // 返回能够装入背包的最大价值
    }

    // 解决0/1背包问题的方法
    public static int zeroOneKnapsack(Item[] items, int capacity) {
        int N = items.length; // 物品的数量
        int[][] dp = new int[N+1][capacity+1]; // 动态规划表，横坐标为容量

        // 填充动态规划表
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= capacity; w++) {
                // 不选择当前物品
                dp[i][w] = dp[i-1][w];
                // 如果当前物品可以加入背包，且加入后价值更大，则更新dp表
                if (items[i-1].weight <= w) {
                    dp[i][w] = Math.max(dp[i][w], items[i-1].value + dp[i-1][w - items[i-1].weight]);
                }
            }
        }
        return dp[N][capacity]; // 返回能够装入背包的最大价值
    }
    public static void main(String[] args) {
        // 创建物品数组
        Item[] items = {new Item(20, 10), new Item(30, 20), new Item(65, 30), new Item(40, 40), new Item(60, 50)};
        int capacity = 100; // 背包的容量

        // 计算分数背包问题的最大价值
        double fractionalValue = fractionalKnapsack(items, capacity);
        System.out.println("分数背包问题的最大价值 = " + fractionalValue);

        // 计算0/1背包问题的最大价值
        int zeroOneValue = zeroOneKnapsack(items, capacity);
        System.out.println("0/1背包问题的最大价值 = " + zeroOneValue);
    }
}