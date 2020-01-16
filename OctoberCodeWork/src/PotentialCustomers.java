import java.util.*;
import java.io.*;
import java.lang.*;

public class PotentialCustomers{
	
    
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		//FastScanner scan=new FastScanner();
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long arr[]=new long[n];
		for(int i=0;i<n;i++){
		    arr[i]=Long.parseLong(br.readLine());
		}
		
		Arrays.sort(arr);
		long max=1;int k=n;
		for(int i=0;i<n;i++){
		    long pro=arr[i]*k;
		    if(pro>max){
		        max=pro;
		    }
		    --k;
		}
		System.out.println(max);
	}

}