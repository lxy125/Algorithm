package Test;

public class Heap {
    public int[] Heap;
    public int size;
    private int maxsize;

    public Heap(int maxsize) {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new int[this.maxsize];
    }


    public static void main(String[] args) {
        System.out.println("The Max Heap is ");
        Heap maxHeap = new Heap(15);
        maxHeap.insert(5);
        maxHeap.insert(3);
        maxHeap.insert(17);
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();
        maxHeap.heapSort();
        System.out.println("The sorted array is ");
        for (int i = 0; i < maxHeap.size; i++) {
            System.out.print(maxHeap.Heap[i] + " ");
        }
    }


    public int parent(int i) {
        // i为根结点
        if (i == 0) {
            return -1;
        }
        return (i - 1) / 2;
    }

    public int left(int i) {
        return (i + 1) * 2 - 1;
    }

    public int right(int i) {
        return (i + 1) * 2;
    }

    public void swap(int fpos, int spos) {
        int tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    public void insert(int element) {
        if (size >= maxsize) {
            return;
        }
        Heap[size] = element;
        int current = size;
        size++;
        while ( current > 0&&Heap[current] > Heap[parent(current)] ) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    //保证当前节点的子树满足最大堆性质
    public void maxHeapify(int pos) {
        int largest = pos; // 初始化为当前节点
        int left = left(pos);
        int right = right(pos);

        // 检查左子节点是否存在且是否大于当前节点
        if (left < size && Heap[left] > Heap[largest]) {
            largest = left;
        }

        // 检查右子节点是否存在且是否大于当前节点
        if (right < size && Heap[right] > Heap[largest]) {
            largest = right;
        }

        if (largest != pos) {
            swap(pos, largest);
            maxHeapify(largest); // 递归地修正下移的节点
        }
    }

    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }

    public void heapSort() {
        int tempSize = size;
        for (int i = size / 2 - 1; i >= 0; i--) {
            maxHeapify(i);
        }

        for (int i = size - 1; i > 0; i--) {
            swap(0, i);
            size--;
            maxHeapify(0);

        }
        size = tempSize;
    }

    public void print() {
        for (int i = 0; i < size / 2; i++) {
            System.out.print(" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i + 1] +
                    " RIGHT CHILD :" + Heap[2 * i + 2]);
            System.out.println();
        }
    }

}





