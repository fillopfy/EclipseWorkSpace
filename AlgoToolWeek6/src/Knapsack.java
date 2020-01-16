import java.util.*;

public class Knapsack {
    static int optimalWeight(int P, int[] w) {
        int n=w.length;
        int m=P;
        int[] I=new int[n+1];
        for(int i=0;i<=n;i++) {
        	if(i==0) {
        		I[i]=0;
        	}else {
        		I[i]=w[i-1];
        	}
        }
        int[] W=new int[m+1];
        for(int i=0;i<=m;i++) {
        	W[i]=i;
        }
        int[][] V=new int[n+1][m+1];
        //i->I,n,j->W,m
        for(int i=0;i<=n;i++) {
        	for(int j=0;j<=m;j++) {
        		if(i==0 || j==0) {
        			V[i][j]=0;
        		}else {
        			if(i>0 && j>0 && W[j]-I[i]>=0 && W[j]-I[i]<=j) {
        				V[i][j]=Math.max(V[i-1][j], V[i-1][W[j]-I[i]]+I[i]);
        			}
        			if(i>0 && j>0 && W[j]-I[i]<0) {
        				V[i][j]=V[i-1][j];
        			}
        		}
        	}
        }
        
        return V[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

