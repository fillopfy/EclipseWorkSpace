import java.util.*;

public class LCS2 {
	
    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int n=a.length;
        int m=b.length;
        int[] A=new int[n+1];
        int[] B=new int[m+1];
        for(int i=0;i<=n;i++) {
        	if(i==0) {
        		A[i]=0;
        	}else {
        		A[i]=a[i-1];
        	}
        }
        
        for(int i=0;i<=m;i++) {
        	if(i==0) {
        		B[i]=0;
        	}else {
        		B[i]=b[i-1];
        	}
        }
        
        int[][] T=new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
        	//A->n,i   B->m,j
        	for(int j=0;j<=m;j++) {
        		if(i==0) {
        			T[i][j]=0;
        		}else
        		if(j==0) {
        			T[i][j]=0;
        		}else
        		if(i!=0 && j!=0){
        			if(A[i]==B[j]) {
        				T[i][j]=T[i-1][j-1]+1;
        			}else {
        				T[i][j]=Math.max(T[i-1][j], T[i][j-1]);
        			}
        		}
        	}
        }
        
        return T[n][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(lcs2(a, b));
    }
}

