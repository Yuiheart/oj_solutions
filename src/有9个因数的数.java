import java.util.Scanner;

/**
 * @Author: czj
 * @Date: Created in 5:42 PM 2019/11/19
 */
public class 有9个因数的数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfCases = Integer.parseInt(sc.nextLine());
        while(numOfCases > 0){
            long N = Long.parseLong(sc.nextLine());
            long limit = (long)Math.sqrt(N);
            long[] primes = new long[(int)(limit + 1)];
            long sum = 0;
            for (int i = 1; i <= limit; i++) {
                primes[i] = i;
            }
            for(int i = 2; i * i <= limit; i++){
                if(primes[i] == i){
                    for(int j = i * i; j <= limit; j += i){
                        if(primes[j] == j){
                            primes[j] = i;
                        }
                    }
                }
            }
            for(int i = 2; i <= limit; i++){
                long p = primes[i];
                long q = primes[(int)(i / primes[i])];
                if (p * q == i && q != 1 && p != q) {
                    sum += 1;
                } else if (primes[i] == i) {
                    if (Math.pow(i, 8) <= N) {
                        sum += 1;
                    }
                }
            }
            System.out.println(sum);
            numOfCases -= 1;
        }
    }
}


