import java.util.*;


/**
 * Description
 *
 * 按照给定的起始顶点广度优先遍历图，每一次通过字母顺序选择顶点查找下一层邻接点，打印遍历顺序。
 */
public class 广度优先遍历图 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp1[0]);
            String startPoint = temp1[1];
            String[] pointNames = sc.nextLine().split(" ");
            int firstVertex = startPoint.charAt(0) - pointNames[0].charAt(0);
            char[] alphabet = new char[26];
            for (int i = 0; i < 26; i++) {
                alphabet[i] = (char)(97 + i);
            }
            int[][] matrix = new int[n][n];
            for (int i = 0; i < n; i++) {
                String[] temp2 = sc.nextLine().split(" ");
                for (int j = 1; j < temp2.length; j++) {
                    matrix[i][j - 1] = Integer.parseInt(temp2[j]);
                }
            }
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                visited[i] = false;
            }
            List<Integer> result = BFS(matrix, visited, firstVertex);
            for (int i = 0; i < result.size() - 1; i++) {
                System.out.print(alphabet[i] + " ");
            }
            System.out.print(alphabet[result.size() - 1]);
            System.out.println();
            numOfCases -= 1;
        }
    }

    static List<Integer> BFS(int[][] matrix, boolean[] visited, int vertex){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        while(!queue.isEmpty()){
            int element = queue.poll();
            if(!visited[element]){
                result.add(element);
                visited[element] = true;
                int[] neighbors = matrix[element];
                for (int i = 0; i < neighbors.length; i++) {
                    if(neighbors[i] == 1 && !visited[i]){
                        queue.add(i);
                    }
                }
            }
        }
        return result;
    }
}
