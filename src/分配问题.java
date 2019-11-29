import java.util.*;

/**
 * Description
 *
 * 对给定的n个任务与n个人之间的成本矩阵完成成本最低的任务分配策略。
 *
 */
public class 分配问题 {
    static int minCost = Integer.MAX_VALUE;
    static int curCost = 0;
    static int[] people;
    static Map<Integer, List<List<Integer>>> result = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String[] temp = sc.nextLine().split(",");
            // 行是人员，列是任务
            int[][] matrix = new int[n][n];
            for(int i = 0; i < temp.length; i++){
                String[] array = temp[i].split(" ");
                int person = Integer.parseInt(array[0]);
                int task =Integer.parseInt(array[1]);
                int cost = Integer.parseInt(array[2]);
                matrix[person - 1][task - 1] = cost;
            }
            people = new int[n];
            for (int i = 0; i < n; i++) {
                people[i] = i;
            }
            allocate(0, n, matrix, new ArrayList<>());
            int minKey = Integer.MAX_VALUE;
            for(Integer i : result.keySet()){
                if(i < minKey){
                    minKey = i;
                }
            }
            List<List<Integer>> output = result.get(minKey);
            Collections.sort(output, new Comparator<List<Integer>>() {
                @Override
                public int compare(List<Integer> o1, List<Integer> o2) {
                    for (int i = 0; i < o1.size(); i++) {
                        if(o1.get(i) == o2.get(i)){
                            continue;
                        }
                        return o2.get(i) - o1.get(i);
                    }
                    return 0;
                }
            });
            for(int i = 0; i < output.size() - 1; i++){
                List<Integer> list = output.get(i);
                for(int j = 0; j < list.size() - 1; j++){
                    System.out.print(list.get(j) + " ");
                }
                System.out.print(list.get(list.size() - 1) + ",");
            }
            List<Integer> list = output.get(output.size() - 1);
            for(int j = 0; j < list.size() - 1; j++){
                System.out.print(list.get(j) + " ");
            }
            System.out.print(list.get(list.size() - 1));
            System.out.println();
            minCost = Integer.MAX_VALUE;
            curCost = 0;
            result.clear();
            for (int i = 0; i < n; i++) {
                people[i] = i;
            }
            numOfCases -= 1;
        }
    }

    static void allocate(int i, int n, int[][] matrix, List<Integer> res){
        if(i == n){
            if (curCost <= minCost) {
                minCost = curCost;
                if(!result.containsKey(minCost)){
                    List<List<Integer>> init = new ArrayList<>();
                    if(!init.contains(res) && res.size() == n) {
                        init.add(res);
                    }
                    result.put(minCost, init);
                }else{
                    List<List<Integer>> lists = result.get(minCost);
                    if(!lists.contains(res) && res.size() == n) {
                        lists.add(res);
                    }
                    result.put(minCost, lists);
                }
            }
        }else{
            for(int j = i; j < n; j++){
                int temp = people[j];
                people[j] = people[i];
                people[i] = temp;
                curCost += matrix[people[i]][i];
                if(res.size() < n) {
                    res.add(people[i] + 1);
                }
                allocate(i + 1, n, matrix, new ArrayList<>(res));
                curCost -= matrix[people[i]][i];
                temp = people[j];
                people[j] = people[i];
                people[i] = temp;
                res.remove(res.size() - 1);
            }
        }
    }
}
