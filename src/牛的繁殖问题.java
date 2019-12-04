import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Description
 *
 * Cows in the FooLand city are interesting animals. One of their specialties is related to producing offsprings. A cow in FooLand produces its first calve (female calf) at the age of two years and proceeds to produce other calves (one female calf a year).
 *
 * Now the farmer Harold wants to know how many animals would he have at the end of N years, if we assume that none of the calves die, given that initially, he has only one female calf?
 *
 * explanation:At the end of 1 year, he will have only 1 cow, at the end of 2 years he will have 2 animals (one parent cow C1 and other baby calf B1 which is the offspring of cow C1).At the end of 3 years, he will have 3 animals (one parent cow C1 and 2 female calves B1 and B2, C1 is the parent of B1 and B2).At the end of 4 years, he will have 5 animals (one parent cow C1, 3 offsprings of C1 i.e. B1, B2, B3 and one offspring of B1).
 */
public class 牛的繁殖问题
{
    static Map<Long,Long> map;

    static {
        map = new HashMap<Long, Long>();
    }

    public static long fib(long n)
    {
        if(n==0)
            return 0;
        if(n==2 || n==1)
            return 1;
        //check if already exists in map ( precalculated val)
        if(map.containsKey(n))
            return map.get(n);
        if(n%2!=0)
        {
            long k=(n+1)/2;
            map.put(n,(fib(k)*fib(k)+fib(k-1)*fib(k-1))%1000000007);
        }
        else{
            long k=n/2;
            map.put(n,(fib(k)*((fib(k-1)<<1)+fib(k)))%1000000007);

        }
        return map.get(n);
    }
    public static void main (String[] args)
    {
        Scanner ab=new Scanner(System.in);
        int t=ab.nextInt();
        while(t-->0)
        {
            System.out.println(fib(ab.nextLong()+1));
        }
    }
}

