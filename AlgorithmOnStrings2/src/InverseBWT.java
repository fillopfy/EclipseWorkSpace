import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InverseBWT {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
    
    class Node{
    	Character c;int i;
    	public Node(char c, int i) {
    		this.c=c;
    		this.i=i;
    	}
    }

    

    String inverseBWT(String bwt) {
        StringBuilder result = new StringBuilder();
        char[] bwtArr=bwt.toCharArray();
        char[] sorted=sort(bwt.toCharArray());
        int n=bwt.length();
        int nA=0,nC=0,nG=0,nT=0,n$=0;;
        Map<Character,Integer> map=new HashMap<>();
        map.put('$',1);
        map.put('A',0);
        map.put('C', 0);
        map.put('G', 0);
        map.put('T', 0);
        for(int i=0;i<n;i++) {
        	char a=bwtArr[i];
        	if(map.containsKey(a)) {
        		map.replace(a, map.get(a)+1);
        	}
        }
        
        n$=0;
        nA=1;
        nC=map.get('A')+1;
        nG=map.get('A')+map.get('C')+1;
        nT=map.get('A')+map.get('C')+map.get('G')+1;
        map.clear();
        map.put('$',n$);
        map.put('A',nA);
        map.put('C',nC);
        map.put('G',nG);
        map.put('T',nT);
        int[] index=new int[n];
        int[] ch=new int[n];
        
        for(int i=0;i<n;i++) {
        	ch[i]=map.get(bwtArr[i]);
        }
        
        map.clear();
        
        for(int i=0;i<n;i++) {
        	char c=bwtArr[i];
        	if(map.containsKey(c)) {
        		map.replace(c, map.get(c)+1);
        	}else {
        		map.put(c,1);
        	}
        	
        	index[i]=map.get(c);
        }
        
        int[] lf=new int[n];
        for(int i=0;i<n;i++) {
        	lf[i]=ch[i]+index[i];
        }
        int r=1;int i=0;
        char c=sorted[r];
        while(i++<=n-1) {
        	result.append(c);
        	r=lf[r]-1;
        	c=sorted[r];
        }
        
        String pq=result.toString();
        if(pq.charAt(0)!='$') {
        	 char a=pq.charAt(0);int k=0;
             StringBuilder rup=new StringBuilder(pq.substring(1));
             while(a!='$') {
             	rup.append(a);
             	a=pq.charAt(++k);
             }
             rup.reverse();
             return rup.toString().substring(0, n);
        }
       
      
        return result.toString();
    }
    
    char[] sort(char arr[]) 
    { 
        int n = arr.length; 
  
        
        char output[] = new char[n]; 
        int count[] = new int[256]; 
        for (int i=0; i<256; ++i) 
            count[i] = 0; 
   
        for (int i=0; i<n; ++i) 
            ++count[arr[i]]; 
        for (int i=1; i<=255; ++i) 
            count[i] += count[i-1]; 
 
        for (int i = n-1; i>=0; i--) 
        { 
            output[count[arr[i]]-1] = arr[i]; 
            --count[arr[i]]; 
        } 
  
        for (int i = 0; i<n; ++i) 
            arr[i] = output[i]; 
        
        return output;
    } 
    static public void main(String[] args) throws IOException {
        new InverseBWT().run();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String bwt = scanner.next();
        System.out.println(inverseBWT(bwt));
    }
}
