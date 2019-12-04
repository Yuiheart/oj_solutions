import java.util.*;

/**
 * Description
 *
 * 给定有向无环图中所有边，计算图的拓扑排序解的个数。
 */
public class 拓扑排序解的个数 {
    static int num;
    static int solutions = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            Map<String, List<String>> map = new HashMap<>();
            String[] temp = sc.nextLine().split(",");
            List<String> vertices = new ArrayList<>();
            for(int i = 0; i < temp.length; i++){
                String[] edge = temp[i].split(" ");
                if(!vertices.contains(edge[0]) || !vertices.contains(edge[1])){
                    num += 1;
                }
                if(!map.containsKey(edge[0])){
                    List<String> endpoints = new ArrayList<>();
                    endpoints.add(edge[1]);
                    map.put(edge[0], endpoints);

                }else{
                    List<String> endpoints = map.get(edge[0]);
                    endpoints.add(edge[1]);
                    map.put(edge[0], endpoints);
                }
            }
            int[] in = new int[num];
            for (int i = 0; i < temp.length; i++) {
                String[] edge = temp[i].split(" ");
                in[edge[1].charAt(0) - 'a'] += 1;
            }
            boolean[] visited = new boolean[num];
            findSolutions(in, map, visited);
            System.out.println(solutions);
            solutions = 1;
            numOfCases -= 1;
        }
    }

    static void findSolutions(int[] in, Map<String, List<String>> map, boolean visited[]){
        List<Integer> zeroIns = new ArrayList<>();
        for (int i = 0; i < in.length; i++) {
            if (in[i] == 0 && !visited[i]) {
                zeroIns.add(i);
            }
        }
        int curZeros = zeroIns.size();
        if (curZeros > 1) {
            solutions = solutions + curZeros - 1;
        }
        for (int i = 0; i < zeroIns.size(); i++) {
            int index = zeroIns.get(i);
            visited[index] = true;
            if(map.containsKey(String.valueOf((char)(index + 97)))) {
                List<String> endpoints = map.get(String.valueOf((char) (index + 97)));
                List<String> temp = new ArrayList<>(endpoints);
                for (int j = 0; j < endpoints.size(); j++) {
                    String str = endpoints.get(j);
                    in[str.charAt(0) - 'a'] -= 1;
                }
                endpoints = new ArrayList<>();
                map.put(String.valueOf((char) (index + 97)), endpoints);
                findSolutions(in, map, visited);
                visited[index] = false;
                for (int j = 0; j < temp.size(); j++) {
                    String str = temp.get(j);
                    in[str.charAt(0) - 'a'] += 1;
                }
                map.put(String.valueOf((char) (index + 97)), temp);
            }
        }
    }
}


