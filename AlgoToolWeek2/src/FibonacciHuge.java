import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
        }

        return current % m;
    } 
    
    private static long pisano(long m) {
    	long p=0,c=1;
    	long a=p+c;long i;
    	for(i=0;i<m*m;i++) {
    		a=(p+c)%m;
    		p=c;
    		c=a;
    		if(p==0 && c==1) break;
    	}
    	
    	return i+1;
    }
    
    private static long getFibonacciHuge(long n, long m) {
    	long res=n % pisano(m);
    	long a=0,b=1;long c=res;
    	for(long i=1;i<res;i++) {
    		c=(a+b)%m;
    		a=b;
    		b=c;
    	}
    	
    	return c%m;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

