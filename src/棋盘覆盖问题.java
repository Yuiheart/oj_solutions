import java.util.*;

/**
 * Description
 *
 * 棋盘覆盖问题：给定一个大小为2^n2^n个小方格的棋盘，其中有一个位置已经被填充，现在要用一个L型（22个小方格组成的大方格中去掉其中一个小方格）形状去覆盖剩下的小方格。求出覆盖方案，即哪些坐标下的小方格使用同一个L型格子覆盖。注意：坐标从0开始。左上方的第一个格子坐标为(0,0)，第一行第二个坐标为(0,1)，第二行第一个为(1,0)，以此类推。
 */
public class 棋盘覆盖问题 {
    static int number = 1;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            int n = Integer.parseInt(temp1[0]);
            int[] specialPoint = {Integer.parseInt(temp1[1]), Integer.parseInt(temp1[2])};
            String[] temp2 = sc.nextLine().split(" ");
            int[] targetPoint = {Integer.parseInt(temp2[0]), Integer.parseInt(temp2[1])};
            int edge = (int)Math.pow(2, n);
            int[][] chess = new int[edge][edge];
            chess[specialPoint[0]][specialPoint[1]] = -1;
            chessFill(0, 0, specialPoint[0], specialPoint[1], edge, chess);
            int targetX = targetPoint[0];
            int targetY = targetPoint[1];
            int targetValue = chess[targetX][targetY];
            List<List<Integer>> results = new ArrayList<>();
            for (int i = 0; i < edge; i++) {
                for (int j = 0; j < edge; j++) {
                    if(chess[i][j] == targetValue && !(i == targetX && j == targetY)){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(j);
                        results.add(temp);
                    }
                }
            }
            results.sort(Comparator.comparing(o1 -> o1.get(0)));
            for (int i = 0; i < results.size() - 1; i++) {
                List<Integer> element = results.get(i);
                System.out.print(element.get(0) + " ");
                System.out.print(element.get(1) + ",");
            }
            List<Integer> element = results.get(results.size() - 1);
            System.out.print(element.get(0) + " ");
            System.out.println(element.get(1));
            numOfCases -= 1;
        }
    }

    static void chessFill(int startX, int startY, int specialX, int specialY, int edge, int[][] chess){
        int level = number++;
        if (edge == 1) {
            return;
        }
        edge = edge / 2;
        int startX1 = startX;
        int startX2 = startX + edge;
        int startY1 = startY;
        int startY2 = startY + edge;

        //左上角
        if(specialX < startX2 && specialY < startY2){
            chessFill(startX1, startY1, specialX, specialY, edge, chess);
        }else{
            chess[startX2 - 1][startY2 - 1] = level;
            chessFill(startX1, startY1, startX2 - 1, startY2 - 1, edge, chess);
        }

        //右上角
        if(specialX >= startX2 && specialY < startY2){
            chessFill(startX2, startY1, specialX, specialY, edge, chess);
        }else{
            chess[startX2][startY2 - 1] = level;
            chessFill(startX2, startY1, startX2, startY2 - 1, edge, chess);
        }

        //左下角
        if(specialX < startX2 && specialY >= startY2){
            chessFill(startX1, startY2, specialX, specialY, edge, chess);
        }else{
            chess[startX2 - 1][startY2] = level;
            chessFill(startX1, startY2, startX2 - 1, startY2, edge, chess);
        }

        //右下角
        if(specialX >= startX2 && specialY >= startY2){
            chessFill(startX2, startY2, specialX, specialY, edge, chess);
        }else{
            chess[startX2][startY2] = level;
            chessFill(startX2, startY2, startX2, startY2, edge, chess);
        }

    }
}


