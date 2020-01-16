import java.util.*;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        //write your code here
    	
    	for(int i=1;i<adj.length;i++) {
    		
    		Map<Integer,Integer> map=new HashMap<>();
    		Explore(adj,i,map);
    		if(map.get(i)>1) {
    			return 1;
    		}
    		
    	}
        return 0;
    }
    
    private static void Explore(ArrayList<Integer>[] adj,int x,Map<Integer,Integer> map) {
    	
    	if(map.containsKey(x)) { 
    		map.replace(x, map.get(x)+1);
    		return;
    	}
    
    	map.put(x,1);
    	ArrayList<Integer> l=adj[x];
    	for(int i=0;i<l.size();i++) {
    		Explore(adj,l.get(i),map);
    		
    	}
    	
    
    }
    
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x].add(y);
        }
        System.out.println(acyclic(adj));
    }
}

