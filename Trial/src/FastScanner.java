import java.util.*;
import java.io.*;

public class FastScanner{
	
	static class FastReader{
		BufferedReader br;
		StringTokenizer tok;
		FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
			
		}
		
		String next() {
			while(tok==null || !tok.hasMoreElements()) {
				try {
					tok=new StringTokenizer(br.readLine());
				}
				catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			return tok.nextToken();
		}
		
		int nextInt() {
			return Integer.parseInt(next());
		}
		
		long nextLong() {
			return Long.parseLong(next());
		}
		
		double nextDouble() {
			return Double.parseDouble(next());
		}
		
		String nextLine() {
			String str="";
			try {
				str=br.readLine();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			return str;
		}
		
		boolean hasNext() {
			return next()==null;
		}
		
		
	}
	public static void main(String[] args) throws Exception{
		FastReader fast=new FastReader();
		int n=fast.nextInt();
		while(n-->0) {
			int a=fast.nextInt();
			int b=fast.nextInt();
			System.out.println(a+b+" ");
		}
	}
}