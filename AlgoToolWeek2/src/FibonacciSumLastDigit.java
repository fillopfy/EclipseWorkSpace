import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long p) {
        if (p <= 1)
            return p;
        int n=(int)(p+2)%60;
        int[] fib=new int[n+1];
        fib[0]=0;
        fib[1]=1;
        int res=1;
        
        

        for (int i = 2; i <= n ; i++) {
           fib[i]=(fib[i-1]%10 +fib[i-2]%10)%10;
        }
        
        if(fib[n]==0) {
        	return 9;
        }

        return (fib[n] % 10)-1;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumNaive(n);
        System.out.println(s);
    }
}

