package Test;

//(1) How many comparisons will Quicksort do on a list of n elements that all have the same value?
//在最糟糕的情况下，如果每次都选择到了列表的最末尾或最前面的元素作为基准元素，
// 那么算法的时间复杂度会降到O(n^2)，因为每次划分只能将列表分为1和n-1的两个部分，这就需要进行大约n^2/2次比较。

//(2) What are the maximum and minimum number of comparisons will Quicksort do on a list of n elements,
// give an instance for maximum and minimum case respectively.

//在最坏情况下，快速排序的最大比较次数发生在输入数组已经完全有序或完全逆序时。
// 此时，每次划分只能将数组划分为一个元素和剩下的n-1个元素，需要进行(n-1) + (n-2) + ... + 1次比较。
// 总比较次数为n*(n-1)/2。

//在最优情况下，快速排序可以每次都能将数组均匀地划分成两个子数组，即每个子数组的大小都是n/2。
// 这样的划分只需要O(log n)层递归深度，而每一层递归中的比较次数为n。
// 总比较次数接近2nlogn。
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {19, 2, 33, 45, 29, 39, 3, 94, 8, 28, 33};
        quickSort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

    }

    public static void quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return;
        }
        i = low;
        j = high;

        temp = arr[low];

        while (i < j) {
            while (temp <= arr[j] && i < j) {
                j--;
            }
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //交换
            if (i < j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }


        arr[low] = arr[i];
        arr[i] = temp;
        quickSort(arr, low, j - 1);
        quickSort(arr, j + 1, high);
    }


}
