import java.util.Arrays;
import java.util.Scanner;

/**
 * Description
 *
 * 按照给定的起始顶点深度优先遍历给定的无向图，尝试所有可能的遍历方式，打印遍历过程中出现的最大深度。
 */
public class 深度优先遍历 {
    static int maxDepth = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp1[0]);
            String startPoint = temp1[1];
            String[] pointNames = sc.nextLine().split(" ");
            int firstVertex = startPoint.charAt(0) - pointNames[0].charAt(0);
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
            DFS(matrix, visited, firstVertex, 1);
            System.out.println(maxDepth);
            maxDepth = Integer.MIN_VALUE;
            numOfCases -= 1;
        }
    }

    static void DFS(int[][] matrix, boolean[] visited, int vertex, int depth){
        int[] neighbors = matrix[vertex];
        visited[vertex] = true;
        int firstNeighbor = -1;
        for (int i = 0; i < neighbors.length; i++) {
            if(neighbors[i] == 1 && !visited[i]){
                firstNeighbor = i;
                break;
            }
        }
        if(firstNeighbor == -1){
            maxDepth = (depth > maxDepth) ? depth : maxDepth;
            return;
        }
        for (int i = 0; i < neighbors.length; i++) {
            if(neighbors[i] == 1 && !visited[i]){
                DFS(matrix, visited, i, depth + 1);
            }
        }
    }
}


