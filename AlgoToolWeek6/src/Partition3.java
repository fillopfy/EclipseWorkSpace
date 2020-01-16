import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int sum=0;
        for(int i:A) {
        	sum+=i;
        }
        if(sum%3!=0) return 0;
        sum/=3;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int num:A) {
        	for(int j=sum;j>=0;j--) {
        		if(j>=num && j-num<=sum) {
        			dp[j]=dp[j] || dp[j-num];
        		}
        	}
        }
        return dp[sum]==true?1:0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

