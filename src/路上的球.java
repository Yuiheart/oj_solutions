import java.util.*;


/**
 * Description
 *
 * There are two parallel roads, each containing N and M buckets, respectively. Each bucket may contain some balls. The buckets on both roads are kept in such a way that they are sorted according to the number of balls in them. Geek starts from the end of the road which has the bucket with a lower number of balls(i.e. if buckets are sorted in increasing order, then geek will start from the left side of the road). The geek can change the road only at the point of intersection(which means, buckets with the same number of balls on two roads). Now you need to help Geek to collect the maximum number of balls.
 */
public class 路上的球
{
    static long collectBalls(int[] a,int[] b,int n,int m){
        long f=0,s=0,res=0;
        int i=0,j=0;
        while(i<n && j<m){
            if(a[i]<b[j]){
                f+=a[i++];
            }
            else if(a[i]>b[j]){
                s+=b[j++];
            }
            else{
                res+=Math.max(f,s)+a[i];
                f=0;
                s=0;
                int temp=a[i];
                ++i;
                temp=b[j];
                ++j;
                while(i<n && a[i]==temp){
                    res+=a[i++];
                }
                while(j<m && b[j]==temp){
                    res+=b[j++];
                }

            }
        }
        while(i<n){
            f+=a[i++];
        }
        while(j<m){
            s+=b[j++];
        }
        res+=Math.max(f,s);
        return res;
    }
    public static void main (String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t>0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] b1=new int[n];
            int[] b2=new int[m];
            for(int i=0;i<n;i++){
                b1[i]=sc.nextInt();
            }
            for(int i=0;i<m;i++){
                b2[i]=sc.nextInt();
            }
            System.out.println(collectBalls(b1,b2,n,m));
            t--;
        }
    }
}

