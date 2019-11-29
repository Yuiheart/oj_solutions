import java.util.Scanner;


/**
 * Description
 *
 * You are given N number of books. Every ith book has Pi number of pages. You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation one of the M students will be allocated the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a student is minimum of those in all the other permutations, and print this minimum value. Each book will be allocated to exactly one student. Each student has to be allocated atleast one book.
 */
public class 书本分发 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long times = scanner.nextLong();
        for (int i = 0; i < times; i++) {
            int bookNum = scanner.nextInt();
            int[] books = new int[bookNum];
            for (int j = 0; j < bookNum; j++) {
                books[j] = scanner.nextInt();
            }
            int head = scanner.nextInt();
            int[][] dp = new int[head + 1][bookNum + 1];
            for (int j = 0; j < bookNum + 1; j++) {
                dp[1][j] = sum(books, 0, j);
            }
            for (int j = 0; j < head + 1; j++) {
                dp[j][1] = books[0];
            }
            for (int j = 2; j < head + 1; j++) {
                for (int k = 2; k < bookNum + 1; k++) {
                    int best = Integer.MAX_VALUE;
                    for (int l = 1; l < k; l++) {
                        best = Math.min(best, Math.max(dp[j - 1][l], sum(books, l, k)));
                    }
                    dp[j][k] = best;
                }
            }
            System.out.println(dp[head][bookNum]);
        }
    }
    private static int sum(int[] is, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++) {
            sum += is[i];
        }
        return sum;
    }
}