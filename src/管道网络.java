import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 9:45 AM 2019/11/28
 *
 * Description
 *
 * Every house in the colony has at most one pipe going into it and at most one pipe going out of it. Tanks and taps are to be installed in a manner such that every house with one outgoing pipe but no incoming pipe gets a tank installed on its roof and every house with only an incoming pipe and no outgoing pipe gets a tap. Find the efficient way for the construction of the network of pipes.

 */
public class 管道网络 {
    // number of houses and number
    // of pipes
    static int n, p;

    // Array rd stores the
    // ending vertex of pipe
    static int rd[] = new int[1100];

    // Array wd stores the value
    // of diameters between two pipes
    static int wt[] = new int[1100];

    // Array cd stores the
    // starting end of pipe
    static int cd[] = new int[1100];

    // arraylist a, b, c are used
    // to store the final output
    static List<Integer> a =
            new ArrayList<>();

    static List <Integer> b =
            new ArrayList<>();

    static List <Integer> c =
            new ArrayList<>();

    static int ans;

    static int dfs(int w)
    {
        if (cd[w] == 0)
            return w;
        if (wt[w] < ans)
            ans = wt[w];

        return dfs(cd[w]);
    }

    // Function to perform calculations.
    static void solve(int arr[][])
    {
        int i = 0;

        while (i < p)
        {

            int q = arr[i][0];
            int h = arr[i][1];
            int t = arr[i][2];

            cd[q] = h;
            wt[q] = t;
            rd[h] = q;
            i++;
        }

        a=new ArrayList<Integer>();
        b=new ArrayList<Integer>();
        c=new ArrayList<Integer>();

        for (int j = 1; j <= n; ++j)

            /*If a pipe has no ending vertex
            but has starting vertex i.e is
            an outgoing pipe then we need
            to start DFS with this vertex.*/
            if (rd[j] == 0 && cd[j]>0) {
                ans = 1000000000;
                int w = dfs(j);

                // We put the details of
                // component in final output
                // array
                a.add(j);
                b.add(w);
                c.add(ans);
            }

        System.out.println(a.size());

        for (int j = 0; j < a.size(); ++j)
            System.out.println(a.get(j) + " "
                    + b.get(j) + " " + c.get(j));
    }

    // main function
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while (numOfCases-- > 0) {
            String[] temp1 = sc.nextLine().split(" ");
            n = Integer.parseInt(temp1[0]);
            p = Integer.parseInt(temp1[1]);
            // set the value of the araray
            // to zero
            for(int i = 0; i < 1100; i++)
                rd[i] = cd[i] = wt[i] = 0;

            int arr[][] = new int[p][3];
            for (int i = 0; i < p; i++) {
                String[] temp = sc.nextLine().split(" ");
                arr[i][0] = Integer.parseInt(temp[0]);
                arr[i][1] = Integer.parseInt(temp[1]);
                arr[i][2] = Integer.parseInt(temp[2]);
            }
            solve(arr);
        }
    }
}

