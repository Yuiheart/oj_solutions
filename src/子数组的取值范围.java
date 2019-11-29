import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;


/**
 * Description
 *
 * 给定数组arr和整数num，求arr的连续子数组中满足：
 * 其最大值减去最小值的结果大于num的个数。请实现一个时间复杂度为O(length(arr))的算法。
 */
public class 子数组的取值范围 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        while (numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int length = temp.length;
            int[] array = new int[length];
            for (int i = 0; i < length; i++) {
                array[i] = Integer.valueOf(temp[i]);
            }
            int num = Integer.valueOf(sc.nextLine());
            int result = getNum(array, num);
            System.out.println(result);
            numOfCases -= 1;
        }
    }

    static int getNum(int[] array, int num){
        Deque<Integer> qmax = new LinkedList<>();
        Deque<Integer> qmin = new LinkedList<>();
        int result = 0;
        int i = 0;
        int j = 0;
        while(i < array.length){
            while(j < array.length){
                while (!qmax.isEmpty() && array[qmax.peekLast()] <= array[j]) {
                    qmax.pollLast();
                }
                qmax.addLast(j);
                while(!qmin.isEmpty() && array[qmin.peekLast()] >= array[j]){
                    qmin.pollLast();
                }
                qmin.addLast(j);
                if(array[qmax.peekFirst()] - array[qmin.peekFirst()] > num){
                    break;
                }
                j += 1;
            }
            if(qmax.peekFirst() == i){
                qmax.pollFirst();
            }
            if(qmin.peekFirst() == i){
                qmin.pollFirst();
            }
            result = result + array.length - j;
            i += 1;
        }
        return result;
    }
}

