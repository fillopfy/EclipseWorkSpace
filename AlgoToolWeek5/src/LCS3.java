import java.util.*;

public class LCS3 {
	
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

    private static int lcs3(int[] a, int[] b, int[] c) {
        //Write your code here
        int l=lcs2(a,b);
        int m=lcs2(a,c);
        int n=lcs2(b,c);
        if(l<=m && l<=n)return l;
        if(m<=l && m<=n) return m;
        else
        	return n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

