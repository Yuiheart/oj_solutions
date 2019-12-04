import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 *
 * Given an array of N distinct elementsA[ ], find the minimum number of swaps required to sort the array.Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.
 */
public class 最小交换次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            int N = sc.nextInt();
            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }
            int loopNum = 1;
            for (int i = 1; i < N; i++) {
                if(A[i] > A[i - 1]){
                    loopNum += 1;
                }
            }
            numOfCases -= 1;
        }
    }
}


