import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 *
 * 实现Shell排序，对给定的无序数组，按照给定的间隔变化（间隔大小即同组数字index的差），打印排序结果，注意不一定是最终排序结果！
 */
public class 实现Shell排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int[] array = new int[temp.length];
            for(int i = 0; i < temp.length; i++){
                array[i] = Integer.parseInt(temp[i]);
            }
            String[] gaps = sc.nextLine().split(" ");
            int left = 0;
            int right = array.length - 1;
            int temp1, i, j;
            for(int m = 0; m < gaps.length; m++){
                int gap = Integer.parseInt(gaps[m]);
                for(i = left + gap; i <= right; i++){
                    if(array[i] < array[i - gap]){
                        temp1 = array[i];
                        j = i - gap;
                        do {
                            array[j + gap] = array[j];
                            j = j - gap;
                        } while(j >= left && temp1 < array[j]);
                        array[j + gap] = temp1;
                    }
                }
            }
            for (int k = 0; k < array.length - 1; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print(array[array.length - 1]);
            System.out.println();
            numOfCases -= 1;
        }
    }
}


