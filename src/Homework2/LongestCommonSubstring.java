package Homework2;

public class LongestCommonSubstring {

    public static void main(String[] args) {

        String X = "xzyzzyx";
        String Y = "zxyyzxz";


        System.out.println("字符串 '" + X + "' 和 '" + Y + "' 的最长公共子串: " + longestCommonSubstring(X, Y));


        X = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCALLAAQANKESSSESFISRLLAIVAD";
        Y = "MAEEEVAKLEKHLMLLRQEYVKLQKKLAETEKRCTLLAAQANKENSNESFISRLLAIVAG";


        System.out.println("字符串 '" + X + "' 和 '" + Y + "' 的最长公共子串: " + longestCommonSubstring(X, Y));
    }


    public static String longestCommonSubstring(String text1, String text2) {

        int maxLength = 0;
        // 初始化最长公共子串的结束索引
        int end = 0;


        int[][] dp = new int[text1.length()][text2.length()];


        for (int i = 1; i < text1.length(); i++) {
            for (int j = 1; j < text2.length(); j++) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    // 如果前一位置有公共子串或者首次匹配，长度加1
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    // 如果当前找到的公共子串长度大于已知最大长度
                    if (dp[i][j] > maxLength) {
                        // 更新最长公共子串的长度
                        maxLength = dp[i][j];
                        // 更新最长公共子串在text1中的结束索引
                        end = i;
                    }
                } else {
                    // 如果当前字符不同，重置当前位置的公共子串长度为0
                    dp[i][j] = 0;
                }
            }
        }

        // 根据最长公共子串的结束索引，从原始字符串中提取最长公共子串
        return text1.substring(end - maxLength + 1, end + 1);
    }
}