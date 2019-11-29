import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 *
 * 输入一个数组和一个数字，在数组中查找两个数，使得它们的和正好是输入的那个数字，统计这样两个数的对数。
 */
public class 固定和的元素对 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        while(numOfCases > 0){
            String[] temp = sc.nextLine().split(" ");
            int length = temp.length;
            int[] array = new int[length];
            for(int i = 0; i < length; i++){
                array[i] = Integer.valueOf(temp[i]);
            }
            int sum = Integer.valueOf(sc.nextLine());
            int num = 0;
            Arrays.sort(array);
            int start = 0;
            int end = length - 1;
            while(start < end){
                int left = array[start];
                int right = array[end];
                if(left + right < sum){
                    start += 1;
                }else if(left + right > sum){
                    end -= 1;
                }else{
                    num += 1;
                    start += 1;
                    end -= 1;
                }
            }
            System.out.println(num);
            numOfCases -= 1;
        }
    }
}
