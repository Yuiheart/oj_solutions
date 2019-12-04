/**
 * Description
 *
 * In a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that
 *
 * Point A and Point B do not coincide.
 * Manhattan Distance and the Euclidean Distance between the points should be equal.
 * Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).
 *
 * Manhattan Distance = |x2-x1|+|y2-y1|
 *
 * Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).
 *
 * Constraints:1<=T <= 50, 1<=N <= 2*10 ^ 5, 0<=(|Xi|, |Yi|) <= 10^9
 */
import java.util.*;


/**
 * Description
 *
 * In a given cartesian plane, there are N points. We need to find the Number of Pairs of points(A,B) such that
 *
 * Point A and Point B do not coincide.
 * Manhattan Distance and the Euclidean Distance between the points should be equal.
 * Note : Pair of 2 points(A,B) is considered same as Pair of 2 points(B,A).
 *
 * Manhattan Distance = |x2-x1|+|y2-y1|
 *
 * Euclidean Distance = ((x2-x1)^2 + (y2-y1)^2)^0.5 where points are (x1,y1) and (x2,y2).
 *
 * Constraints:1<=T <= 50, 1<=N <= 2*10 ^ 5, 0<=(|Xi|, |Yi|) <= 10^9
 */
public class 距离问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int n = scanner.nextInt();

            Map<Integer, List<Integer>> xMap = new HashMap<>();
            Map<Integer, List<Integer>> yMap = new HashMap<>();


            for (int j = 0; j < n; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                List<Integer> xList = xMap.get(x);
                if (xList == null) {
                    xList = new ArrayList<>();
                    xList.add(y);
                    xMap.put(x, xList);
                } else {
                    xList.add(y);
                }

                List<Integer> yList = yMap.get(y);
                if (yList == null) {
                    yList = new ArrayList<>();
                    yList.add(x);
                    yMap.put(y, yList);
                } else {
                    yList.add(x);
                }
            }

            int count = 0;
            for (List<Integer> list : xMap.values()) {
                count += (list.size() * (list.size() - 1)) / 2;
            }
            for (List<Integer> list : yMap.values()) {
                count += (list.size() * (list.size() - 1)) / 2;
            }
            System.out.println(count);
        }
    }
}


