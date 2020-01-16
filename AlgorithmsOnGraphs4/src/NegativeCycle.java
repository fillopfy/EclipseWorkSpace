import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NegativeCycle {
	static class Edge{
		int source,destination,weight;
		Edge(int s,int d,int w){
			this.source=s;
			this.destination=d;
			this.weight=w;
		}
	}
    private static int negativeCycle(int n,ArrayList<Edge> list,int s) {
        // write your code here
    
    	int m=list.size();
    	long dist[] = new long[n];
    	Arrays.fill(dist, Long.MAX_VALUE);
    	dist[s]=0;
    
    	for(int k=0;k<n-1;k++) {
    		for(int i=0;i<m;i++) {
        		Edge edge=list.get(i);
        		int u=edge.source;
        		int v=edge.destination;
        		int w=edge.weight;
        		if(dist[u]!=Long.MAX_VALUE && dist[v]>dist[u]+w) {
        			dist[v]=dist[u]+w;
        		}
        	}
    	}
    	
    	
    	for(int i=0;i<m;i++) {
    		Edge edge=list.get(i);
    		int u=edge.source;
    		
    		int v=edge.destination;
    		int w=edge.weight;
    		if(dist[u]!=Long.MAX_VALUE && dist[v]>dist[u]+w) {
    			return 1;
    		}
    	}
    	
    	
    	
    	return 0;
    }
    
    public static void Explore(ArrayList<Integer>[] adj,boolean[] visited,Map<Integer,Integer> map, int x) {
    	if(map.containsKey(x)) {
    		map.replace(x, map.get(x)+1);
    		return;
    	}
    	map.put(x,1);
    	ArrayList<Integer> l=adj[x];
    	for(int i=0;i<l.size();i++) {
    		if(!visited[l.get(i)]) {
    			Explore(adj,visited,map,l.get(i));
    		}
    	}
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Edge> list=new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
       
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x-1].add(y-1);
            list.add(new Edge(x-1,y-1,w));
            
        }
        ArrayList<Integer> pq=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	boolean[] visited=new boolean[n];
        	Map<Integer,Integer> map=new HashMap<>();
        	Explore(adj,visited,map,i);
        	if(map.get(i)>1) {
        		pq.add(i);
        	}
        	
        }
        int res=0;
        for(int i:pq) {
        	res=negativeCycle(n,list,i);
        	if(res==1) {
        		break;
        	}
        }
        System.out.println(res);
        scanner.close();
    }
}

