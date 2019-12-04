import java.util.Scanner;

/**
 * Description
 *
 * Archana is very fond of strings. She likes to solve many questions related to strings. She comes across a problem which she is unable to solve. Help her to solve. The problem is as follows: Given is a string of length L. Her task is to find the longest string from the given string with characters arranged in descending order of their ASCII code and in arithmetic progression. She wants the common difference should be as low as possible(at least 1) and the characters of the string to be of higher ASCII value.
 */
public class 和最大的连续降序字符 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0) {
            char[] s = sc.next().toCharArray();
            boolean[] ch = new boolean[26];
            for(int i = 0; i<s.length; i++)
                ch[s[i]-'A'] = true;
            String res = "";
            for(int i = 1; i<26; i++) {
                for(int j = 25; j>=0; j--) {
                    if(ch[j]) {
                        String temp = "";
                        temp+=(char)('A'+j);
                        for(int k = j-i; k>=0; k-=i) {
                            if(ch[k])
                                temp+=(char)('A'+k);
                            else
                                break;
                        }
                        if(temp.length()>res.length())
                            res = temp;
                    }
                }
            }
            System.out.println(res);
        }
    }
}

