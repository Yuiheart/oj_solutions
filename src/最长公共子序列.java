import java.util.*;

/**
 * Description
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入为两行，一行一个字符
 *
 * Output
 * 如果没有公共子序列，不输出，如果有多个则分为多行，按字典序排序。
 */
public class 最长公共子序列 {
    public static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            String a = sc.nextLine();
            String b = sc.nextLine();
            int m = a.length();
            int n = b.length();
            int[][] dp = getDp(a.toCharArray(), b.toCharArray());
            String res = "";
            traceBack(dp, a.toCharArray(), b.toCharArray(), m, n, res);
            Collections.sort(results);
            if(dp[m][n] != 0) {
                for (String str : results) {
                    System.out.println(str);
                }
            }
            results.clear();
            numOfCases -= 1;
        }
    }

    //动态规划
    public static int[][] getDp(char[] str1, char[] str2){
        int[][] dp = new int[str1.length + 1][str2.length + 1];
        if(str1.length == 1 && str2.length == 1) {
            dp[1][1] = str1[0] == str2[0] ? 1 : 0;
        }
        if(str1.length > 1) {
            for (int i = 2; i < str1.length; i++) {
                dp[i][1] = Math.max(dp[i - 1][1], str1[i] == str2[0] ? 1 : 0);
            }
        }
        if(str2.length > 1) {
            for (int j = 2; j < str2.length; j++) {
                dp[1][j] = Math.max(dp[1][j - 1], str1[0] == str2[j] ? 1 : 0);
            }
        }
        if(str1.length > 1 && str2.length > 1) {
            for (int m = 1; m < str1.length; m++) {
                for (int n = 1; n < str2.length; n++) {
                    if (str1[m] == str2[n]) {
                        dp[m + 1][n + 1] = dp[m][n] + 1;
                    } else {
                        dp[m + 1][n + 1] = Math.max(dp[m][n + 1], dp[m + 1][n]);
                    }
                }
            }
        }
        return dp;
    }

    //回溯法
    public static void traceBack(int[][] dp, char[] str1, char[] str2, int i, int j, String res){
        if(i < 0 || j < 0){
            return;
        }
        while(i > 0 && j > 0){
            if(str1[i-1] == str2[j-1]){
                res += str1[i-1];
                i -= 1;
                j -= 1;
            }else{
                if(dp[i - 1][j] > dp[i][j - 1]){
                    i -= 1;
                }else if(dp[i - 1][j] < dp[i][j - 1]){
                    j -= 1;
                }else{
                    traceBack(dp, str1, str2, i-1, j, res);
                    traceBack(dp, str1, str2, i, j-1, res);
                    return;
                }
            }
        }
        String temp = new StringBuilder(res).reverse().toString();
        if(!results.contains(temp)) {
            results.add(temp);
        }
    }
}


