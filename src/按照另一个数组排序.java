import java.util.*;

/**
 *
 * Description
 *
 * Given two array A1[] and A2[], sort A1 in such a way that the relative order among the elements will be same as those in A2. For the elements not present in A2. Append them at last in sorted order. It is also given that the number of elements in A2[] are smaller than or equal to number of elements in A1[] and A2[] has all distinct elements.
 *
 * Input:A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8} A2[] = {2, 1, 8, 3}Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
 *
 * Since 2 is present first in A2[], all occurrences of 2s should appear first in A[], then all occurrences 1s as 1 comes after 2 in A[]. Next all occurrences of 8 and then all occurrences of 3. Finally we print all those elements of A1[] that are not present in A2[]
 *
 * Constraints:1 ≤ T ≤ 501 ≤ M ≤ 501 ≤ N ≤ 10 & N ≤ M1 ≤ A1[i], A2[i] ≤ 1000
 */
public class 按照另一个数组排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            int M = sc.nextInt();
            int N = sc.nextInt();

            List<Integer> A1 = new ArrayList<>();
            List<Integer> A1_out = new ArrayList<>();
            List<Integer> A2 = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                A1.add(sc.nextInt());
            }
            for (int i = 0; i < N; i++) {
                A2.add(sc.nextInt());
            }
            for (int i = 0; i < M; i++) {
                if (A2.indexOf(A1.get(i)) == -1) {
                    A1_out.add(A1.get(i));
                }
            }
            for (int i = M - 1; i >= 0; i--) {
                if (A1_out.indexOf(A1.get(i)) != -1) {
                    A1.remove(i);
                }
            }
            Collections.sort(A1, Comparator.comparingInt(o1 -> A2.indexOf(o1)));
            Collections.sort(A1_out);
            A1.addAll(A1_out);
            for (int i = 0; i < M - 1; i++) {
                System.out.print(A1.get(i) + " ");
            }
            System.out.println(A1.get(M - 1));
            numOfCases -= 1;
        }
    }
}
