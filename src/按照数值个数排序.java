import java.util.*;


/**
 * Description
 *
 * 对给定数组中的元素按照元素出现的次数排序，出现次数多的排在前面，如果出现次数相同，则按照数值大小排序。例如，给定数组为{2, 3, 2, 4, 5, 12, 2, 3, 3, 3, 12}，则排序后结果为{3, 3, 3, 3, 2, 2, 2, 12, 12, 4, 5}。
 */
public class 按照数值个数排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            int N = Integer.parseInt(sc.nextLine());
            String[] temp = sc.nextLine().split(" ");
            int[] nums = new int[N];
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(temp[i]);
            }
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
            Map<Integer, List<Integer>> reversedMap = new HashMap<>();
            for(Integer i : map.keySet()){
                int value = map.get(i);
                List<Integer> list = reversedMap.getOrDefault(value, new ArrayList<>());
                list.add(i);
                reversedMap.put(value, list);
            }
            List<Integer> result = new ArrayList<>();
            List<Integer> keys = new ArrayList<>(reversedMap.keySet());
            Collections.sort(keys, ((o1, o2) -> o2 - o1));
            for (Integer key : keys) {
                List<Integer> list = reversedMap.get(key);
                Collections.sort(list);
                for (Integer elem : list) {
                    int count = key;
                    while(count > 0){
                        result.add(elem);
                        count -= 1;
                    }
                }
            }
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.print(result.get(i) + " ");
            }
            System.out.print(result.get(result.size() - 1));
            System.out.println();
            numOfCases -= 1;
        }
    }
}
