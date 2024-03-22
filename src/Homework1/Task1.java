package Homework1;

import java.util.Arrays;

import static Test.QuickSort.quickSort;

//描述一个运行时间为（nlgn）的算法，给定n个整数的集合S和另一个整数x，该算法能
//确定S中是否存在两个其和刚好为x的元素。
public class Task1 {
    public static void main(String[] args) {
        int[] nums={2,3,44,56,23,657,323,3,55,2,1};
        int x=100;
        System.out.println(findNum(nums,x));
    }
   public static boolean findNum(int[] nums,int x){
     quickSort(nums,0,nums.length-1);
       int left = 0;
       int right = nums.length - 1;

       while (left < right) {
           int sum = nums[left] + nums[right];

           if (sum == x) {
               return true;
           } else if (sum < x) {
               left++;
           } else {
               right--;
           }
       }

       return false;
   }
}

