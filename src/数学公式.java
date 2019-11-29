import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 5:02 PM 2019/11/19
 *
 * Description
 *
 * Implement pow(A, B) % C.In other words, given A, B and C, find (A^B)%C
 */
public class 数学公式 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            String[] temp = sc.nextLine().split(" ");
            int A = Integer.parseInt(temp[0]);
            int B = Integer.parseInt(temp[1]);
            int C = Integer.parseInt(temp[2]);
            int result = getRemainder(A, B, C);
            System.out.println(result);
            numOfCases -= 1;
        }
    }

    static int getRemainder(int A, int B, int C){
        if(B == 1){
            return A % C;
        }
        if(B % 2 == 0){
            return (getRemainder(A, B/2, C) * getRemainder(A, B/2, C)) % C;
        }else{
            return (getRemainder(A, B-1, C) * getRemainder(A, 1, C)) % C;
        }
    }
}
