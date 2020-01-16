
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        ArrayList<Integer> g=new ArrayList<>();
        ArrayList<Integer> m=new ArrayList<>();
        for(int i=0;i<n;i++){
            String line=br.readLine();
            if(line.charAt(0)=='G'){
                String[] str=line.trim().split("\\s+");
                for(int j=0;j<str.length;j++){
                    if(IsInt(str[j])){
                        g.add(Integer.parseInt(str[j]));
                    }
                }
            }else{
                String[] str=line.trim().split("\\s+");
                for(int j=0;j<str.length;j++){
                    if(IsInt(str[j])){
                        m.add(Integer.parseInt(str[j]));
                    }
                }
            }
            
            int Gcount19=0,Gcount20=0;int Mcount19=0,Mcount20=0;
            for(int k=0;k<g.size();k++){
                if(g.get(k)==19){
                    ++Gcount19;
                }
                if(g.get(k)==20){
                    ++Gcount20;
                }
                if(m.get(k)==19){
                    ++Mcount19;
                }
                if(m.get(k)==20){
                    ++Mcount20;
                }
                
            }
            
            if(2*Gcount19>Mcount19 || 2*Gcount20>Mcount20){
                System.out.println("Date");
            }
            System.out.println("No Date");
            
        }
        
    }
    
    public static boolean IsInt(String s){
        try{
            int a=Integer.parseInt(s);
        }catch(NumberFormatException e){
            return false;
        }
        
        return true;
    }
}
