import java.util.Scanner;

/**
 * Description
 *
 * 有两个序列 a,b，大小都为 n,序列元素的值任意整数，无序；
 * 要求：通过交换 a,b 中的元素，使[序列 a 元素的和]与[序列 b 元素的和]之间的差最小。
 */
public class 调整数组使差最小 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        while(numOfCases > 0) {
            String[] temp = sc.nextLine().split(" ");
            int length = temp.length;
            int[] array = new int[length * 2];
            for (int i = 0; i < length; i++) {
                array[i] = Integer.valueOf(temp[i]);
            }
            temp = sc.nextLine().split(" ");
            for(int i = length; i < length * 2; i++){
                array[i] = Integer.valueOf(temp[i - length]);
            }
            double splitValue = sum(array) / 2.0;
            System.out.println(Math.abs(new Double(select(array, splitValue, 0, length) * 2).intValue()));
            numOfCases -= 1;
        }
    }

    static int sum(int[] array){
        int sum = 0;
        for(int i : array){
            sum += i;
        }
        return sum;
    }

    static double select(int[] array, double sum, int index, int count){
        if(count == 0){
            return sum;
        }
        if(index == array.length){
            return Double.MAX_VALUE;
        }
        if(array[index] > sum){
            return select(array, sum, index + 1, count);
        }
        return Math.min(select(array, sum - array[index], index + 1, count - 1),
                select(array, sum, index + 1, count));
    }
}
