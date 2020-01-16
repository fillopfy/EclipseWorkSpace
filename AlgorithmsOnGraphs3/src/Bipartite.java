import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        //write your code here
    	for(int i=0;i<adj.length;i++) {
    		Map<Integer, Integer> map=new HashMap<>();
    		Explore(adj,map,i);
    		if(map.get(i)>1 && map.size()%2==0) {
    			return 0;
    		}
    	}
        return 1;
    }
    
    private static void Explore(ArrayList<Integer>[] adj, Map<Integer, Integer> map, int x) {
    	if(map.containsKey(x)) {
    		map.replace(x, map.get(x)+1);
    		return;
    	}
    	map.put(x,1);
    	ArrayList<Integer> l=adj[x];
    	for(int i=0;i<l.size();i++) {
    		Explore(adj,map,l.get(i));
    	}
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
        System.out.println(bipartite(adj));
    }
}

