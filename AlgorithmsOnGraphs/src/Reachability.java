import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {
	static class Point{
		boolean visited;int point;
		public Point(int point) {
			this.point=point;
			this.visited=false;
		}
	}
	
    private static int reach(ArrayList<Integer>[] adj, int x, int y) {
        //write your code here
    	int n=adj.length;
    	boolean[] visited =new boolean[n];
    	DFS(adj, visited, x);
    	return (visited[y]==true)?1:0;
    	
        
    }
    
    private static void DFS(ArrayList<Integer>[] adj, boolean[] visited, int x) {
    	if(visited[x]==false) {
    		visited[x]=true;
    	}
    	ArrayList<Integer> l=adj[x];
    	for(int i=0;i<l.size();i++) {
    		int v=l.get(i);
    		if(visited[l.get(i)]==false) {
    			DFS(adj,visited,v);
    		}
    	}
    }
    
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Point[] points=new Point[n];
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for(int i=0;i<n;i++) {
        	points[i]=new Point(i);
        }
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
        //DFS(points,adj);
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adj, x, y));
    }
}

