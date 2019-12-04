import java.util.Scanner;

/**
 * Description
 *
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number. There are several combinations possible. Print only first such pair.
 *
 * NOTE: A solution will always exist, read Goldbach’s conjecture.Also, solve the problem in linear time complexity, i.e., O(n).
 */
public class 素数和问题 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = scanner.nextInt();
        for (int j = 0; j < times; j++) {
            int even = scanner.nextInt();
            for (int i = 2; i <= even / 2; i++) {
                if (prime(i) && prime(even - i)) {
                    System.out.println(i + " " + (even - i));
                    break;
                }
            }
        }
    }


    //	判断数字是否为质数方法
    private static boolean prime(int n) {
        boolean flag = true;
        if (n != 2 && n != 3) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    flag = false;
                    break;
                }
            }
        }
        return flag;
    }
}

