import java.util.*;

/**
 * @Author: czj
 * @Date: Created in 9:37 AM 2019/11/21
 * Description
 *
 * Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.In order to maximize the total tip value they decided to distribute the order among themselves. One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing all the orders.
 */
public class 订单问题 {
    public static void main (String args[])
    {
        Scanner sc = new Scanner(System.in);
        int tc= sc.nextInt();
        while(tc-- >0)
        {
            int N= sc.nextInt();
            int X= sc.nextInt();
            int Y= sc.nextInt();

            int A[]=new int[N];
            int B[]=new int[N];

            for(int i=0;i<N;i++)
                A[i]=sc.nextInt();
            for(int i=0;i<N;i++)
                B[i]=sc.nextInt();

            int dp[][]=new int[X+1][Y+1];

            for(int i=1;i<=X;i++)
                dp[i][0]= A[i-1] + dp[i-1][0];
            for(int i=1;i<=Y;i++)
                dp[0][i]= B[i-1] + dp[0][i-1];

            for(int i=1;i<=X;i++)
            {
                for(int j=1;j<=Y;j++)
                {
                    if(i+j <= N)
                    {
                        int op1= A[i+j-1] + dp[i-1][j]; // GIVING TO X (CHECK X IN FOR)-> ROW
                        int op2= B[i+j-1] + dp[i][j-1]; // TO Y

                        dp[i][j] = Math.max( op1 , op2 );
                    }
                    else
                        dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                }
            }

            System.out.println(dp[X][Y]);
        }
    }
}


