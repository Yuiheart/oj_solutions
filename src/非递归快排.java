import java.util.*;

/**
 * Description
 * 快速排序的核心思想是使用元素的值对数组进行划分。实现其非递归方案。
 *
 * Input
 * 输入的每一行表示一个元素为正整数的数组，所有值用空格隔开，第一个值为数值长度，其余为数组元素值。
 *
 * Output
 * 输出的每一行为排序结果，用空格隔开，末尾不要空格。
 */
public class 非递归快排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int[] array = new int[num];
            for(int i = 0; i < num; i++){
                array[i] = sc.nextInt();
            }
            // 递归转非递归的辅助结构，一般选取栈
            Stack<Boarder> stack = new Stack<>();
            int left = 0;
            int right = num - 1;
            Boarder initBoarder = new Boarder(left, right);
            stack.push(initBoarder);
            while (!stack.empty()) {
                Boarder boarder = stack.pop();
                int low = boarder.getLeft();
                int high = boarder.getRight();
                if (low >= num || high < 0) {
                    break;
                }
                int key = array[low];
                while (low < high) {
                    while (low < high && key <= array[high]) {
                        high -= 1;
                    }
                    if (low < high) {
                        array[low] = array[high];
                        low += 1;
                    }
                    while (low < high && key > array[low]) {
                        low += 1;
                    }
                    if (low < high) {
                        array[high] = array[low];
                        high -= 1;
                    }
                    array[low] = key;
                }

                if (low + 1 < boarder.getRight()) {
                    Boarder boarder1 = new Boarder(low + 1, boarder.getRight());
                    stack.push(boarder1);
                }
                if (low - 1 > boarder.getLeft()) {
                    Boarder boarder1 = new Boarder(boarder.getLeft(), low - 1);
                    stack.push(boarder1);
                }
                /*
                if(boarder.getRight() - boarder.getLeft() >= 1){
                    Boarder boarder1 = new Boarder(low + 1, boarder.getRight());
                    stack.push(boarder1);
                    Boarder boarder2 = new Boarder(boarder.getLeft(), low - 1);
                    stack.push(boarder2);
                }
                */
            }
            for (int i = 0; i < num - 1; i++) {
                System.out.print(array[i]);
                System.out.print(" ");
            }
            System.out.print(array[num - 1]);
            System.out.println();
        }
    }
}

class Boarder{
    private int left;
    private int right;

    public Boarder(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }
}




