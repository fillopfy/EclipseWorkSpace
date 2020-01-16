import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ConnectingPoints { 
	public static int[] parent,rank;
	public static void MakeSet(Point p) {
		parent[p.index]=p.index;
		rank[p.index]=0;
	}
	public static int find(Point p) {
		while(p.index!=parent[p.index]) {
			p.index=parent[p.index];
		}
		return p.index;
	}
	public static void Union(Point p1, Point p2) {
		int i_id=find(p1);
		int j_id=find(p2);
		if(i_id==j_id) {
			return;
		}
		if(rank[i_id]>rank[j_id]) {
			parent[j_id]=i_id;
		}
		else {
			parent[i_id]=j_id;
			if(rank[i_id]==rank[j_id]) {
				rank[j_id]=rank[j_id]+1;
			}
		}
			
		
	}
	static class Point{
		int x,y;boolean visited;int index;
		Point(int x, int y, int index){
			this.x=x;
			this.y=y;
			this.index=index;
			visited=false;
		}
	}
	static class Edge{
		Point p1,p2; double weight;
		Edge(Point p1, Point p2, double weight){
			this.p1=p1;
			this.p2=p2;
			this.weight=weight;
		}
		
	}
	
	class EdgeCompare implements Comparator<Edge>
	{ 
	
	    public int compare(Edge m1, Edge m2) 
	    { 
	        if (m1.weight < m2.weight) return -1; 
	        if (m1.weight > m2.weight) return 1; 
	        else return 0; 
	    } 
	} 
	
    private static double minimumDistance(Point[] points) {
    	int n=points.length;
    	ArrayList<Edge> list=new ArrayList<>();
    	
    	for(int i=0;i<n;i++) {
    		Point p1=points[i];
    		for(int j=i+1;j<n;j++) {
    			Point p2=points[j];
    			double dis=dist(p1,p2);
    			list.add(new Edge(p1,p2,dis));
    			
    		}
    	}
    	
    	double res=0;
    	
    	ConnectingPoints cp=new ConnectingPoints();
    	Collections.sort(list,cp.new EdgeCompare());
    	for(Edge e:list) {
    		if(find(e.p1)!=find(e.p2)) {
    			res+=e.weight;
    			Union(e.p1,e.p2);
    		}
    	}
    	
    	return res;
    }
    
   

    public static double dist(Point p1, Point p2) {
    	return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x)+(p2.y-p1.y)*(p2.y-p1.y));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        
        
        Point[] points=new Point[n];
        parent=new int[n];
        rank=new int[n];
        
        
        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
            y[i] = scanner.nextInt();
            points[i]=new Point(x[i],y[i],i);
            MakeSet(points[i]);
            
        }
        System.out.printf("%.9f\n",minimumDistance(points));
        scanner.close();
    }
}

