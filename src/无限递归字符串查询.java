import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 9:17 PM 2019/11/18
 *
 * Description
 *
 * Consider a string A = "12345". An infinite string s is built by performing infinite steps on A recursively. In i-th step, A is concatenated with ‘$’ i times followed by reverse of A. A=A|$...$|reverse(A), where | denotes concatenation.
 *
 * Constraints:1<=Q<=10^5, 1<=POS<=10^12
 */
public class 无限递归字符串查询 {
    public static final String A = "12345";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0) {
            long pos = Long.parseLong(sc.nextLine());
            long step = 0;
            long initLength = 5 + step;
            while(pos > initLength){
                step += 1;
                initLength = initLength * 2 + step;
            }
            char result = search(pos, initLength, step);
            System.out.println(result);
            numOfCases -= 1;
        }
    }

    static char search(long pos, long initLength, long step){
        if(pos <= 5){
            return A.charAt((int)(pos - 1));
        }
        long leftHalf, rightHalf;
        if(initLength % 2 == 0){
            leftHalf = initLength / 2;
            rightHalf = initLength / 2 + 1;
        }else{
            leftHalf = initLength / 2 + 1;
            rightHalf = initLength / 2 + 1;
        }
        long border = (step - 1) / 2;
        if(pos >= leftHalf - border && pos <= rightHalf + border){
            return '$';
        }
        if(pos > rightHalf + border){
            pos = initLength - pos + 1;
        }
        long newLength = (initLength - step) / 2;
        return search(pos, newLength, step - 1);
    }
}


