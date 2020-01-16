import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static int distance(ArrayList<Integer>[] adj, int s, int t) {
        //write your code here
    	int[] distances=new int[adj.length];
    	Arrays.fill(distances, -1);
    	Queue<Integer> q=new LinkedList<>();
    	q.add(s);
    	distances[s]=0;
    	while(!q.isEmpty()) {
    		int a=q.poll();
    		ArrayList<Integer> l=adj[a];
    		for(int i=0;i<l.size();i++) {
    			if(distances[l.get(i)]==-1) {
    				q.add(l.get(i));
    				distances[l.get(i)]=distances[a]+1;
    			}
    		}
    	}
        return distances[t];
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, x, y));
    }
}

