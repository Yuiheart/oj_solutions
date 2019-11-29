import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 8:02 PM 2019/11/17
 *
 * Description
 *
 * Given a string ‘str’ of digits, find length of the longest substring of ‘str’, such that the length of the substring is 2k digits and sum of left k digits is equal to the sum of right k digits.
 */
public class 对称子字符串 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            String array = sc.nextLine();
            int length = array.length();
            if(length <= 1){
                System.out.println(0);
            }else {
                int k = 1;
                int maxLen = 0;
                while (k * 2 <= length) {
                    int start, end;
                    for (int i = 0; i + k * 2 <= length; i++) {
                        start = i;
                        end = start + k * 2 - 1;
                        int comparison = 0;
                        while (start < end) {
                            comparison = comparison + array.charAt(start) - array.charAt(end);
                            start += 1;
                            end -= 1;
                        }
                        if (comparison == 0) {
                            maxLen = k * 2 > maxLen ? k * 2 : maxLen;
                        }
                    }
                    k += 1;
                }
                System.out.println(maxLen);
            }
            numOfCases -= 1;
        }
    }
}
