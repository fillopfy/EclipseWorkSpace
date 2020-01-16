
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.lang.*;
 

public class Towerofhanoi {
    
    static class Disk{
        int R,H;
        
        public Disk(int R,int H){
            this.R=R;
            this.H=H;
        }
    }
    
    static class SortByR implements Comparator<Disk>{
    	public int compare(Disk a, Disk b) {
    		return a.R-b.R;
    	}
    }
    public static void main(String args[] ) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0){
            int n=Integer.parseInt(br.readLine());
            ArrayList<Disk> disk=new ArrayList<Disk>();
            //int[] R=new int[n];
            //int[] H=new int[n];
            for(int i=0;i<n;i++){
                String line=br.readLine();
                String[] RH=line.trim().split("\\s+");
                int a=Integer.parseInt(RH[0]);
                int b=Integer.parseInt(RH[1]);
                Disk d=new Disk(a,b);
                disk.add(d);
                
            }
            
            Collections.sort(disk,new DiskType());
            int h=0;
            for(int i=n-1;i>0;i--){
                Disk temp1=disk.get(i);
                Disk temp2=disk.get(i-1);
                
                if(temp1.H>temp2.H){
                    ++h;
                }
            }
            
            System.out.println(h);
            
        }

    }
    
    static class DiskType implements Comparator<Disk>{
    	@Override
    	public int compare(Disk d1, Disk d2) {
    		return d1.R>d2.R?1:0;
    	}
    }
}
