import java.util.*;

/**
 * @Author: czj
 * @Date: Created in 9:15 AM 2019/11/21
 *
 * Description
 *
 * Given an array, the task is to complete the function which finds the maximum sum subarray, where you may remove at most one element to get the maximum sum.
 */
public class 数组查询 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numOfTestCases = scanner.nextInt();
        while (numOfTestCases-- > 0)
        {
            int lengthOfArray = scanner.nextInt();
            int[] array = new int[lengthOfArray];
            for (int i = 0; i < lengthOfArray; i++)
            {
                array[i] = scanner.nextInt();
            }
            System.out.println(calMaxSubSumByRemoveOneNum(array, lengthOfArray));
        }
    }

    private static int calMaxSubSumByRemoveOneNum(int[] array, int lengthOfArray)
    {
        int forward[] = new int[lengthOfArray];
        int backward[] = new int[lengthOfArray];

        int curMax = array[0];
        int maxSoFar = array[0];
        forward[0] = array[0];
        for (int i = 1; i < lengthOfArray; i++)
        {
            curMax = Math.max(array[i], curMax + array[i]);
            maxSoFar = Math.max(maxSoFar, curMax);

            forward[i] = curMax;
        }

        curMax = maxSoFar = backward[lengthOfArray - 1] = array[lengthOfArray - 1];
        for (int i = lengthOfArray - 2; i >= 0; i--)
        {
            curMax = Math.max(array[i], curMax + array[i]);
            maxSoFar = Math.max(maxSoFar, curMax);
            backward[i] = curMax;
        }

        int fans = maxSoFar;
        for (int i = 1; i < lengthOfArray - 1; i++)
        {
            fans = Math.max(fans, forward[i - 1] + backward[i + 1]);
        }
        return fans;
    }
}
