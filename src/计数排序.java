import java.util.Scanner;

/**
 * Description
 * 实现计数排序，通过多次遍历数组，统计比每一个元素小的其它元素个数，根据该统计量对数据进行排序。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 */
public class 计数排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int num = sc.nextInt();
            int[] array = new int[num];
            int[] sorted = new int[num];
            for (int i = 0; i < num; i++) {
                array[i] = sc.nextInt();
            }
            for(int m = 0; m < num; m++){
                int count = 0;
                for(int n = 0; n < num; n++){
                    if(array[n] < array[m]){
                        count += 1;
                    }
                }
                while(sorted[count] == array[m]){
                    count += 1;
                }
                sorted[count] = array[m];
            }
            for(int i = 0; i < num - 1; i++){
                System.out.print(sorted[i]);
                System.out.print(" ");
            }
            System.out.print(sorted[num - 1]);
            System.out.println();
        }
    }
}
