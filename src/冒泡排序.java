import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 * 实现冒泡排序。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 */
public class 冒泡排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[] array = new int[num];
            for(int i = 0; i < num; i++){
                array[i] = sc.nextInt();
            }
            for(int i = 0; i < num - 1; i++){
                boolean flag = false;
                for(int j = i + 1; j < num; j++){
                    if(array[i] > array[j]){
                        int temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        flag = true;
                    }
                }
                if(!flag){
                    break;
                }
            }
            for(int i = 0; i < num - 1; i++){
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.print(array[num - 1]);
            System.out.println();
        }
    }
}
