import java.util.PriorityQueue;
import java.util.*;


/**
 * Description
 *
 * Given a square grid of size n, each cell of which contains integer cost which represents a cost to traverse through that cell, we need to find a path from top left cell to bottom right cell by which total cost incurred is minimum.
 *
 * Note : It is assumed that negative cost cycles do not exist in input matrix.
 */
public class 格子里的整数 {

    static class Path implements Comparable<Path>
    {
        int x, y, distance;

        public Path(int x, int y, int distance)
        {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Path p)
        {
            return this.distance - p.distance;
        }
    }

    static int[] xPath = {-1, 0, 0, 1};
    static int[] yPath = {0, -1, 1, 0};

    private static boolean isValid(int x, int y, int[][] a)
    {
        if(x >= 0 && x < a.length && y >= 0 && y < a[0].length)
        {
            return true;
        }

        return false;
    }

    private static int getMinimumCostPath(int[][] a)
    {
        int[][] r = new int[a.length][a[0].length];

        for(int i = 0; i < r.length; i++)
        {
            for(int j = 0; j < r[0].length; j++)
            {
                r[i][j] = Integer.MAX_VALUE;
            }
        }

        r[0][0] = a[0][0];
        PriorityQueue<Path> pq = new PriorityQueue<Path>();
        pq.add(new Path(0, 0, r[0][0]));
        Path p;
        int x = 0;
        int y = 0;
        boolean f = false;

        while(!pq.isEmpty())
        {
            p = pq.poll();

            for(int i = 0; i < 4; i++)
            {
                x = p.x + xPath[i];
                y = p.y + yPath[i];

                if(isValid(x, y, a) && r[p.x][p.y] + a[x][y] < r[x][y])
                {
                    r[x][y] = r[p.x][p.y] + a[x][y];
                    pq.add(new Path(x, y, r[x][y]));
                }
            }
        }

        return r[a.length - 1][a[0].length - 1];
    }

    public static void main (String[] args) {
        //code
        Scanner sc = new Scanner(System.in);

        int testCases, n, a[][];

        testCases = sc.nextInt();

        for(int i = 0; i < testCases; i++)
        {
            n = sc.nextInt();
            a = new int[n][n];

            for(int j = 0; j < n; j++)
            {
                for(int k = 0; k < n; k++)
                {
                    a[j][k] = sc.nextInt();
                }
            }

            System.out.println(getMinimumCostPath(a));
        }
    }
}