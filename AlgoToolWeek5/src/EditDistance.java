import java.util.*;

public class EditDistance {
	
  public static int Min(int a,int b,int c) {
		  //if(a==b && b==c && c==a)return a;
		  if(a<=b && a<=c)return a;
		  if(b<=a && b<=c)return b;
		  else
			  return c;
   }
	 
  public static int EditDistance(String s, String t) {
    //write your code here
	int n=s.length();
	int m=t.length();
	char[] fir=new char[n+1];
	char[] sec=new char[m+1];
	for(int i=0;i<=s.length();i++) {
		if(i==0) {
			fir[i]=' ';
		}else {
			fir[i]=s.charAt(i-1);
		}
	}
	
	for(int i=0;i<=t.length();i++) {
		if(i==0) {
			sec[i]=' ';
		}else {
			sec[i]=t.charAt(i-1);
		}
	}
	
	int[][] T=new int[n+1][m+1];
	for(int i=0;i<=n;i++) {
		//i->fir && j->sec
		for(int j=0;j<=m;j++) {
			if(i==0) {
				T[i][j]=j;
			}else
			if(j==0) {
				T[i][j]=i;
			}else {
				if(i!=0 && j!=0) {
					if(fir[i]==sec[j]) {
						T[i][j]=T[i-1][j-1];
					}else {
						T[i][j]=1+Min(T[i][j-1],T[i-1][j],T[i-1][j-1]);
					}
				}
			}
			
		}
	}
    return T[n][m];
  }
 
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
