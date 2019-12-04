import java.util.PriorityQueue;
import java.util.Scanner;


/**
 * Description
 *
 * 找到给定数组的给定区间内的第K小的数值。
 */
public class 区间第k最小 {
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
            String[] temp2 = sc.nextLine().split(" ");
            int start = Integer.valueOf(temp2[0]);
            int end = Integer.valueOf(temp2[1]);
            int K = Integer.valueOf(sc.nextLine());
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(int i = start - 1; i <= end - 1; i++){
                minHeap.add(array[i]);
            }
            for(int i = 0; i < K - 1; i++){
                minHeap.poll();
            }
            System.out.println(minHeap.peek());
            numOfCases -= 1;
        }
    }
}



