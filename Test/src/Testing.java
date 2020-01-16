import java.io.BufferedReader;
import java.io.*;
import java.lang.*;


import java.util.*;

public class Testing {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t>0){
            String line=br.readLine();
            String[] str=line.trim().split("\\s+");
            long n=Long.parseLong(str[0]);
            long m=Long.parseLong(str[1]);
            int count=0;int a=0;
            if(m!=1){
                a=(int)(Math.log(n)/Math.log(m));
            }
            if(m==1){
                count=(int)n;
            }
            
            while(n>=0 && m!=1){
                if(a!=1 && (Math.pow(m,a)-n)>=0){
                    n-=Math.pow(m,a);
                    ++count;
                }else{
                    a-=1;
                    
                }
                
            }
            
            System.out.println(count);
            t-=1;
        }

    }
}
