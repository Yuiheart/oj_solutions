import java.util.Scanner;

/**
 * Description
 * Given an array of positive integers and many queries for divisibility.
 * In every query Q[i], we are given an integer K , we need to count all elements in the array which are perfectly divisible by K.
 *
 * Constraints:1<=T<=1001<=N,M<=1051<=A[i],Q[i]<=105
 *
 *
 * Input
 * The first line of input contains an integer T denoting the number of test cases.
 * Then T test cases follow. Each test case consists of three lines. First line of each test case contains two integers N & M,
 * second line contains N space separated array elements and third line contains M space separated queries.
 *
 *
 * Output
 * For each test case,In new line print the required count for each query Q[i].
 *
 */
public class 整除查询 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            int N = Integer.parseInt(temp1[0]);
            int M = Integer.parseInt(temp1[1]);
            int[] array = new int[N];
            String[] temp2 = sc.nextLine().split(" ");
            for(int i = 0; i < N; i++){
                array[i] = Integer.parseInt(temp2[i]);
            }
            int[] queries = new int[M];
            String[] temp3 = sc.nextLine().split(" ");
            for(int j = 0; j < M; j++){
                queries[j] = Integer.parseInt(temp3[j]);
            }
            int[] results = new int[M];
            for(int m = 0; m < M; m++){
                int count = 0;
                for(int n = 0; n < N; n++){
                    if(array[n] % queries[m] == 0){
                        count += 1;
                    }
                }
                results[m] = count;
            }
            for(int i = 0; i < M - 1; i++){
                System.out.print(results[i] + " ");
            }
            System.out.print(results[M - 1]);
            System.out.println();
            numOfCases -= 1;
        }
    }
}


