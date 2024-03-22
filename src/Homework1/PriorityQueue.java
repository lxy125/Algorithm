package Homework1;

import Test.Heap;

//实现优先队列
public class PriorityQueue {
    private Heap maxHeap;

    public static void main(String[] args) throws Exception {
       PriorityQueue pq = new PriorityQueue(10); // 创建一个最大容量为10的优先队列

        // 插入一些元素
        pq.insert(4);
        pq.insert(7);
        pq.insert(2);
        pq.insert(9);
        pq.insert(1);
        pq.insert(8);

        System.out.println("优先队列：");
        pq.print();

        System.out.println("Max: " + pq.peekMax()); // 显示最大元素但不移除
        System.out.println("Max: " + pq.extractMax()); // 显示最大元素但移除
        System.out.println("Max: " + pq.extractMax()); // 显示最大元素但移除
    }



    public PriorityQueue(int maxSize){
        this.maxHeap = new Heap(maxSize);
    }

    public void insert(int element){
        maxHeap.insert(element);
    }
    //移除并返回最大元素
    public int extractMax() throws Exception {
        if(maxHeap.size==0){
            throw new Exception("优先队列为空");
        }
       int max=maxHeap.Heap[0];
        maxHeap.swap(0,maxHeap.size-1);
        maxHeap.size--;
        maxHeap.maxHeapify(0);
        return max;
    }

    //不移除返回最大元素
    public int peekMax()throws Exception{
        if(maxHeap.size==0) {
            throw new Exception("优先队列为空");
        }
        return maxHeap.Heap[0];
    }

    public void print(){
        maxHeap.print();
    }




}
