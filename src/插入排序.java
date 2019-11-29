import java.util.Scanner;

/**
 * Description
 * 实现插入排序。
 *
 * Input
 * 输入第一行为用例个数， 每个测试用例输入的每一行代表一个数组，其中的值用空格隔开，第一个值表示数组的长度。
 *
 * Output
 * 输出排序的数组，用空格隔开，末尾不要空格。
 */
public class 插入排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            String[] temp = sc.nextLine().split(" ");
            int length = Integer.parseInt(temp[0]);
            int[] array = new int[length];
            for(int i = 1; i < temp.length; i++){
                array[i - 1] = Integer.parseInt(temp[i]);
            }
            for(int i = 1; i < array.length; i++){
                int store = array[i];
                int flag = i - 1;
                while(flag >= 0 && store < array[flag]){
                    array[flag + 1] = array[flag];
                    flag -= 1;
                }
                array[flag + 1] = store;
            }
            for(int i = 0; i < array.length - 1; i++){
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.print(array[array.length - 1]);
            System.out.println();
            numOfCases -= 1;
        }
    }
}
