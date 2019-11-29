import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 9:30 PM 2019/11/18
 *
 * Description
 *
 * There are Infinite People Standing in a row, indexed from 1.A person having index 'i' has strength of (i*i).You have Strength 'P'. You need to tell what is the maximum number of People You can Kill With your Strength P.You can only Kill a person with strength 'X' if P >= 'X' and after killing him, Your Strength decreases by 'X'.
 */
public class 序号乘方 {
    public static void main(String[] args) {
        final int MAX = 1000000;
        long[] sums = new long[MAX];
        for (int i = 1; i < MAX; i++) {
            sums[i] = sums[i-1] + (long)i * i;
        }
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            long power = Long.parseLong(sc.nextLine());
            // 用折半查找是关键
            int ind = Arrays.binarySearch(sums, power);
            if (ind < 0) {
                ind = -ind-2;
            }
            System.out.println(ind);
            numOfCases -= 1;
        }
    }
}
