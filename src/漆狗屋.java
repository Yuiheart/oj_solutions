import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 12:45 PM 2019/11/19
 *
 * Description
 *
 * Dilpreet wants to paint his dog- Buzo's home that has n boards with different lengths[A1, A2,..., An]. He hired k painters for this work and each painter takes 1 unit time to paint 1 unit of the board.The problem is to find the minimum time to get this job done under the constraints that any painter will only paint continuous sections of boards, say board {2, 3, 4} or only board {1} or nothing but not board {2, 4, 5}.
 *
 * Constraints:1<=T<=100,1<=k<=30,1<=n<=50,1<=A[i]<=500
 */
public class 漆狗屋 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int k = Integer.parseInt(temp[0]);
            int n = Integer.parseInt(temp[1]);
            String[] boards = sc.nextLine().split(" ");
            int[] dp = new int[n];
            int[] sumNow = new int[n];
            dp[0] = Integer.parseInt(boards[0]);
            sumNow[0] = Integer.parseInt(boards[0]);
            if(n <= 1) {
                System.out.println(sumNow[0]);
                continue;
            }
            for(int i = 1; i < n; i++){
                sumNow[i] = sumNow[i - 1] + Integer.parseInt(boards[i]);
                dp[i] = sumNow[i];
            }
            for(int i = 1; i < k; i++){
                for(int j = n - 1; j > i - 1; j--){
                    int min = Integer.MAX_VALUE;
                    for(int m = i - 1; m < j; m++){
                        int cur = Math.max(dp[m], sumNow[j] - sumNow[m]);
                        min = Math.min(cur, min);
                    }
                    dp[j] = min;
                }
            }
            System.out.println(dp[n - 1]);
            numOfCases -= 1;
        }
    }
}


