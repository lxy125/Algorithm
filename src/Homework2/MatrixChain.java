package Homework2;



//     如果i=j，m[i,j]=0
//
//    如果i<j，m[i,j]=min{m[i,k]+m[k+1,j]+p(i-1)p(k)p(j)}  i<=k<j


import java.sql.SQLOutput;

public class MatrixChain {
    public static void main(String[] args) {
        int[] p = {3, 5, 2, 1, 10};
        chainOrder(p);

        int[] p2 = {2, 7, 3, 6, 10};
        chainOrder(p2);

        int[] p3 = {10, 3, 15, 12, 7, 2};
        chainOrder(p3);

        int[] p4 = {7, 2, 4, 15, 20, 5};
        chainOrder(p4);
    }

    static void chainOrder(int p[]){
        int n=p.length-1;//矩阵数量
        int[][] m =new int [n][n];//存储从i到j的最小乘法次数

        int [][]s = new int [n][n];//记录最优解的分割点

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) {
                    m[i][j]=0;
                } else if (i < j) {
                    m[i][j]=Integer.MAX_VALUE;
                }
            }
        }
        //l为链长
        for(int l=2;l<=n;l++){
            for(int i =0;i<n-l+1;i++){//从i开始的链长要大于1
                int j=i+l-1;//结束位置
                m[i][j]=Integer.MAX_VALUE;
                //q为分割点为k时的乘法次数
                for(int k=i;k<j;k++){
                    int q=m[i][k]+m[k+1][j]+p[i]*p[k+1]*p[j+1];
                    if(q<m[i][j]){
                        m[i][j]=q;
                        s[i][j]=k;
                    }
                }

            }
        }
        System.out.println("最少乘法次数: " + m[0][n-1]);
        System.out.print("最优乘法顺序: ");
        printOrder(s, 0, n-1);
        System.out.println();






    }

    public static void printOrder(int[][] s, int i, int j) {
        if(i == j) {
            System.out.print("A" + (i+1));
        } else {
            System.out.print("(");
            int k = s[i][j];
            if (k >= 0 && k < s.length) {
                printOrder(s, i, k);
                printOrder(s, k + 1, j);
            }
            System.out.print(")");
        }
    }


}
