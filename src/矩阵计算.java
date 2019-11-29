import java.util.Scanner;

/**
 * Description
 *
 * Let's define a Series Whose recurrence formula is as follows :
 *
 * C(n)= 3C(i-1) + 4C(i-2) + 5C(i-3) + 6C(i-4)
 *
 * C(0)= 2
 *
 * C(1)= 0
 *
 * C(2)= 1
 *
 * C(3)= 7
 *
 * Now based on this Series a Matrix Mi,j of size nn is to be formed.The top left cell is(1,1) and the bottom right corner is (n,n). Each cell (i,j) of the Matrix contains either 1 or 0. If C( (i*j)^3 ) is odd, Mi,j is 1, otherwise, it's 0.Count the total number of ones in the Matrix.
 */
public class 矩阵计算 {
    public static void main(String args[]) {
        calMatrix(new Scanner(System.in));
    }

    public static void calMatrix(Scanner scanner)
    {
        int testNum = scanner.nextInt();
        while (testNum-- > 0)
        {
            int n = scanner.nextInt();
            int[][] matrix = new int[n][n];
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = (int) Math.pow((i+1) * (j+1), 3) % 7;
                    if (num == 2 || num == 3 || num == 4 || num == 6) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }
    }
}