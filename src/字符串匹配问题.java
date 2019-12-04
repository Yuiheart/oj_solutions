import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Description
 *
 * Given a text txt[0..n-1] and a pattern pat[0..m-1], write a function search(char pat[], char txt[]) that prints all occurrences of pat[] in txt[]. You may assume that n > m.
 */
public class 字符串匹配问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            String[] temp = sc.nextLine().split(",");
            String text = temp[0];
            String pattern = temp[1];
            int w = pattern.length();
            List<Integer> result = new ArrayList<>();
            for(int i = 0; i <= text.length() - w; i++){
                String substring = text.substring(i, i + w);
                if(substring.equals(pattern)){
                    result.add(i);
                }
            }
            if(result.size() == 0){
                System.out.println();
            }else {
                Collections.sort(result);
                for (int i = 0; i < result.size() - 1; i++) {
                    System.out.print(result.get(i) + " ");
                }
                System.out.print(result.get(result.size() - 1));
                System.out.println();
            }
            numOfCases -= 1;
        }
    }
}



