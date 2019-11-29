import java.util.HashSet;
import java.util.Scanner;

/**
 * Description
 *
 * Given an array of strings A[ ], determine if the strings can be chained together to form a circle. A string X can be chained together with another string Y if the last character of X is same as first character of Y. If every string of the array can be chained, it will form a circle. For example, for the array arr[] = {"for", "geek", "rig", "kaf"} the answer will be Yes as the given strings can be chained as "for", "rig", "geek" and "kaf".
 */
public class 能否成环 {
    public static void main(String args[]) {
        testStringBeChain(new Scanner(System.in));
    }

    static boolean isCycle(String st[], StringBuilder sb, HashSet<Integer> visited) {

        int len = st.length;
        if( visited.size() == len) {
            if(sb.charAt(0) == sb.charAt(sb.length()-1)) {
                return true;
            }
            return false;
        }

        for(int j = 0; j < len; j++) {

            if(!visited.contains(j) && (sb.length()== 0 || (st[j].charAt(0) == sb.charAt(sb.length()-1))))  {
                sb.append(st[j].charAt(0));
                sb.append(st[j].charAt(st[j].length()-1));

                visited.add(j);

                if(isCycle(st,sb,visited)){
                    return true;
                }

                sb.setLength(sb.length()-2);
                visited.remove(j);
            }
        }

        return false;


    }
    public static void testStringBeChain (Scanner sc)
    {
        int testNum = Integer.parseInt(sc.nextLine());
        while (testNum-- > 0)
        {
            int num = Integer.parseInt(sc.nextLine());
            String[] input = sc.nextLine().split(" ");
            StringBuilder builder = new StringBuilder();
            HashSet<Integer> set = new HashSet<>();
            if(isCycle(input, builder, set))
            {
                System.out.println("1");
            }
            else
            {
                System.out.println("0");
            }
        }
    }
}