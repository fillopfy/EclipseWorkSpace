import java.util.*;

public class Dijkstra {
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
    	int n=cost.length;
    	long[] distances=new long[n];
    	boolean[] visited=new boolean[n];
    	for(int i=0;i<n;i++) {
    		distances[i]=Long.MAX_VALUE;
    	}
    	distances[s]=0;
    	PriorityQueue<Long> pq=new PriorityQueue<>();
    	for(int i=0;i<n;i++) {
    		pq.add(distances[i]);
    	}
    
    	while(!pq.isEmpty()) {
    		pq.poll();
    		int u=findMin(distances,visited);
    		visited[u]=true;
    		ArrayList<Integer> l=adj[u];
    		for(int i=0;i<l.size();i++) {
    			int v=l.get(i);
    			if(distances[u]!=Long.MAX_VALUE && distances[v]>distances[u]+cost[u].get(i)) {
    				pq.remove(distances[v]);
    				distances[v]=distances[u]+cost[u].get(i);
    				pq.add(distances[v]);
    			}
    		}
    		
    	}
    	
    	return (distances[t]==Long.MAX_VALUE)?-1:(int)distances[t];
    }
    
    public static int findMin(long[] distances,boolean[] visited) {
    	long min=Long.MAX_VALUE;
    	int index=0;
    	for(int i=0;i<distances.length;i++) {
    		if(distances[i]<min && !visited[i]) {
    			min=distances[i];
    			index=i;
    		}
    	}
   
    	return index;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
        scanner.close();
    }
}

