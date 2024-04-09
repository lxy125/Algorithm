package Homework2;

public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String X = "xzyzzyx";
        String Y = "zxyyzxz";


        System.out.println("字符串 '" + X + "' 和 '" + Y + "': " + longestCommonSubsequence(X, Y));


        X = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        Y = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";

        System.out.println("字符串 '" + X + "' 和 '" + Y + "': " + longestCommonSubsequence(X, Y));
    }


    public static String longestCommonSubsequence(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();


        int[][] dp = new int[m + 1][n + 1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 如果当前字符相同，则LCS长度加1
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // 否则取左右子问题的最大值作为当前LCS长度
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // 使用StringBuilder来构建最长公共子序列
        StringBuilder lcsBuilder = new StringBuilder();

        // 从右下角开始回溯，直到左上角
        int i = m, j = n;
        while (i > 0 && j > 0) {
            // 如果当前位置的字符相同，则将其添加到LCS中并回溯
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                lcsBuilder.append(text1.charAt(i - 1));
                i--;
                j--;
            }
            // 如果不相同且左边的LCS长度更大，向左移动
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                i--;
            }
            // 向上移动
            else {
                j--;
            }
        }

        // 将构建的LCS反转并返回
        return lcsBuilder.reverse().toString();
    }
}