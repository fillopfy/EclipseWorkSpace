import java.util.*;

public class ChangeDP {
	
    private static int getChange(int m) {
        //1 3 4
    	int[] M=new int[m+1];
    	for(int i=0;i<=m;i++) {
    		M[i]=i;
    	}
    	int[] D=new int[] {0,1,3,4};
    	int[][] T=new int[4][m+1];
    	
    	for(int i=0;i<=3;i++) {
    		
    		for(int j=0;j<=m;j++) {
    			if(i==0 || j==0) {
    				T[i][j]=0;
    			}else
    			if(D[i]==1) {
    				T[i][j]=M[j];
    			}else
    				if(M[j]==1) {
        				T[i][j]=1;
        			}else
        			if(M[j]==2) {
        				T[i][j]=2;
        			}else
    			 {
    				if(i!=0 && M[j]-D[i]>=0 && M[j]-D[i]<=j) {
    					T[i][j]=Math.min(T[i-1][j],T[i][M[j]-D[i]]+1);
    				}
    				
    			}
    			
    		}
    	}
    	
    
    	
        return T[3][m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getChange(m));
        
    }
}

