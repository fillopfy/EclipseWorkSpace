import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class Toposort {
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        boolean used[] = new boolean[adj.length];
        ArrayList<Integer> order = new ArrayList<Integer>();
        //write your code here
        dfs(adj,used,order);
        return order;
    }
    
    private static void Explore(ArrayList<Integer>[] adj, boolean[] visited, int x, Stack<Integer> stack) {
    	if(visited[x]) return;
    	visited[x]=true;
    	ArrayList<Integer> l=adj[x];
    	for(int i=0;i<l.size();i++) {
    		if(visited[l.get(i)]==false) {
    			Explore(adj,visited,l.get(i), stack);
    		}
    	}
    	stack.push(x);
    }

    private static void dfs(ArrayList<Integer>[] adj, boolean[] visited, ArrayList<Integer> order) {
      //write your code here
    	Stack<Integer> stack=new Stack<>();
    	for(int i=0;i<visited.length;i++) {
    		if(visited[i]==false) {
    			Explore(adj,visited,i,stack);
    		}
    	}
    	int n=stack.size();
    	for(int i=0;i<n;i++) {
    		order.add(stack.pop());
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
        }
        ArrayList<Integer> order = toposort(adj);
        for (int x : order) {
            System.out.print((x + 1) + " ");
        }
    }
}

