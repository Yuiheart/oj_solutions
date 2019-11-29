import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 *
 * 汉诺塔问题中限制不能将一层塔直接从最左侧移动到最右侧，
 * 也不能直接从最右侧移动到最左侧，而是必须经过中间。求当有N层塔的时候移动步数。
 */
public class 汉诺塔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.valueOf(sc.nextLine());
        List<Integer> list = new ArrayList<>();
        while(numOfCases > 0){
            int N = Integer.valueOf(sc.nextLine());
            int result = process(N, "A", "B", "C", "A", "C");
            list.add(result);
            numOfCases -= 1;
        }
        for(int i = 0; i < list.size() - 1; i++){
            System.out.println(list.get(i));
        }
        System.out.print(list.get(list.size() - 1));
    }

    public static int process(int num, String left, String mid, String right,
                              String from, String to) {
        if (num == 1) {
            if (from.equals(mid) || to.equals(mid)) {
                return 1;
            } else {
                return 2;
            }
        }
        if (from.equals(mid) || to.equals(mid)) {
            String another = (from.equals(left) || to.equals(left)) ? right : left;
            int part1 = process(num - 1, left, mid, right, from, another);
            int part2 = 1;
            int part3 = process(num - 1, left, mid, right, another, to);
            return part1 + part2 + part3;
        } else {
            int part1 = process(num - 1, left, mid, right, from, to);
            int part2 = 1;
            int part3 = process(num - 1, left, mid, right, to, from);
            int part4 = 1;
            int part5 = process(num - 1, left, mid, right, from, to);
            return part1 + part2 + part3 + part4 + part5;
        }
    }
}
