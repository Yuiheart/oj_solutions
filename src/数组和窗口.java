
import java.util.Arrays;

import java.util.Scanner;

/**
 * Description
 *
 * 给定一个整型数组arr和一个大小为w的窗口，窗口从数组最左边滑动到最右边，
 * 每次向右滑动一个位置，求出每一次滑动时窗口内最大元素的和。
 */
public class 数组和窗口 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        while(numOfCases > 0){
            String[] temp = sc.nextLine().split(" ");
            int[] array = new int[temp.length];
            for(int i = 0; i < temp.length; i++){
                array[i] = Integer.valueOf(temp[i]);
            }
            int window = Integer.valueOf(sc.nextLine());
            int start = 0;
            int end = start + window - 1;
            int[] maxOfWindows = new int[array.length - window + 1];
            int pointer = 0;
            while(end < array.length){
                int[] copy = Arrays.copyOfRange(array, start, end + 1);
                Arrays.sort(copy);
                int currentMax = copy[copy.length - 1];
                maxOfWindows[pointer] = currentMax;
                pointer += 1;
                start += 1;
                end += 1;
            }
            int sum = 0;
            for(int i : maxOfWindows){
                sum += i;
            }
            System.out.println(sum);
            numOfCases -= 1;
        }
    }
}


