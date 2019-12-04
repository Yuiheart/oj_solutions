import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 9:47 AM 2019/11/28
 *
 * Description
 *
 * Given the list of coins of distinct denominations and total amount of money. Output the minimum number of coins required to make up that amount. Output -1 if that money cannot be made up using given coins. You may assume that there are infinite numbers of coins of each type.
 *
 *
 * Input
 *
 * The first line contains 'T' denoting the number of test cases. Then follows description of test cases. Each cases begins with the two space separated integers 'n' and 'amount' denoting the total number of distinct coins and total amount of money respectively. The second line contains N space-separated integers A1, A2, ..., AN denoting the values of coins.
 *
 * Constraints:1<=T<=30，1<=n<=100，1<=Ai<=1000，1<=amount<=100000
 *
 *
 * Output
 *
 * Print the minimum number of coins required to make up that amount or return -1 if it is impossible to make that amount using given coins.
 *
 *
 * Sample Input 1
 *
 * 2
 * 3 11
 * 1 2 5
 * 2 7
 * 2 6
 * Sample Output 1
 *
 * 3
 * -1
 */
public class 硬币最小数量 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases-- > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp1[0]);
            int amount = Integer.parseInt(temp1[1]);
            int[] coins = new int[n];
            String[] temp2 = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(temp2[i]);
            }
            int[] dp = new int[amount + 1];
            for (int i = 0; i < n; i++) {
                dp[coins[i]] = 1;
            }
            for (int i = 1; i <= amount; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < n; j++) {
                    if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                        min = (dp[i - coins[j]] + 1 < min) ? dp[i - coins[j]] + 1 : min;
                    }
                }
                if(min != Integer.MAX_VALUE) {
                    dp[i] = min;
                } else {
                    dp[i] = -1;
                }
            }
            System.out.println(dp[amount]);
        }
    }
}


