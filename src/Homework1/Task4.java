package Homework1;

import java.util.Arrays;

public class Task4 {
    public static int findK(int[] A,int m,int[] B,int n,int k){
        //基准情况
        if(m>n)
            return findK(B,n,A,m,k);
        if(m==0)
            return B[k-1];
        if(k==1)
            return Math.min(A[0],B[0]);

        int i=Math.min(m,k/2),j=Math.min(n,k/2);//防止越界
        if(A[i-1]<B[j-1]){
            return findK(Arrays.copyOfRange(A,i,m),m-i,B,n,k-i);
        }else{
            return findK(A,m,Arrays.copyOfRange(B,j,n),n-j,k-j);
        }

    }

    public static void main(String[] args) {

            int[] A = {2, 3, 6, 7, 9,12};
            int[] B = {1, 4, 8, 10};
            int k = 10;
            System.out.println("第 " + k + "大的数字是 " + findK(A, A.length, B, B.length, k));

    }
}
//2 3 6 7 9
//1 4 7 10      5

// 6 7 9
//1 4 7 10      3

// 6 7 9
// 4 7 10       2

//6 7 9
//4 7 10