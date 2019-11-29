import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 9:46 AM 2019/11/28
 *
 * Description
 *
 * Given arrival and departure times of all trains that reach a railway station. Your task is to find the minimum number of platforms required for the railway station so that no train waits.
 *
 * Note: Consider that all the trains arrive on the same day and leave on the same day. Also, arrival and departure times must not be same for a train.
 *
 *
 * Input
 *
 * The first line of input contains T, the number of test cases. For each test case, first line will contain an integer N, the number of trains. Next two lines will consist of N space separated time intervals denoting arrival and departure times respectively.
 *
 * Note: Time intervals are in the 24-hourformat(hhmm), preceding zeros are insignificant. 200 means 2:00.
 * Consider the example for better understanding of input.
 *
 * Constraints:1 <= T <= 100，1 <= N <= 1000，1 <= A[i] < D[i] <= 2359
 *
 *
 * Output
 *
 * For each test case, print the minimum number of platforms required for the trains to arrive and depart safely.
 *
 *
 * Sample Input 1
 *
 * 1
 * 6
 * 900  940 950  1100 1500 1800
 * 910 1200 1120 1130 1900 2000
 * Sample Output 1
 *
 * 3
 */
public class 时间分隔 {
    static int findPlatform(int arr[], int dep[], int n)
    {
        // Sort arrival and departure arrays
        Arrays.sort(arr);
        Arrays.sort(dep);

        // plat_needed indicates number of platforms
        // needed at a time
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;

        // Similar to merge in merge sort to process
        // all events in sorted order
        while (i < n && j < n)
        {
            // If next event in sorted order is arrival,
            // increment count of platforms needed
            if (arr[i] <= dep[j])
            {
                plat_needed++;
                i++;

                // Update result if needed
                if (plat_needed > result)
                    result = plat_needed;
            }

            // Else decrement count of platforms needed
            else
            {
                plat_needed--;
                j++;
            }
        }

        return result;
    }

    // Driver program to test methods of graph class
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases-- > 0){
            int n = Integer.parseInt(sc.nextLine());
            int arr[] = new int[n];
            int dep[] = new int[n];
            String[] temp1 = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(temp1[i]);
            }
            String[] temp2 = sc.nextLine().split(" ");
            for (int i = 0; i < n; i++) {
                dep[i] = Integer.parseInt(temp2[i]);
            }

            System.out.println(findPlatform(arr, dep, n));
        }

    }
}
