import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        
        //write your code heres
        int n=adj.length;
        boolean[] visited = new boolean[n];
        return DFS(adj,visited);
        
        
       
    }
    
    private static void Explore(ArrayList<Integer>[] adj, boolean[] visited,int x) {
    	if(visited[x]==true) return;
    	if(visited[x]==false) {
    		visited[x]=true;
    	    
        	ArrayList<Integer> l=adj[x];
        	for(int i=0;i<l.size();i++) {
        		int y=l.get(i);
        		if(visited[y]==false) {
        			Explore(adj, visited, y);
        		}
        	}
    	}
    	
    }
    
    private static int DFS(ArrayList<Integer>[] adj, boolean[] visited) {
    	int cc=0;
    	for(int i=0;i<visited.length;i++) {
    		if(visited[i]==false) {
    			Explore(adj,visited,i);
    			cc+=1;
    		}
    	}
    	
    	return cc;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

