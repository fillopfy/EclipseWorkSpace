import java.io.*;
import java.util.*;


public class Evacuation {
    private static FastScanner in;

    public static void main(String[] args) throws IOException {
        in = new FastScanner();

        FlowGraph graph = readGraph();
        System.out.println(maxFlow(graph, 0, graph.size() - 1));
    }

    private static int maxFlow(FlowGraph graph, int from, int to) {
        int maxflow = 0;
        /* your code goes here */
        Map<Integer,Integer> parent=new HashMap<>();
        while(BFS(graph,from,to,parent)==true) {
        	//System.out.println("maxFlow");
        	int key=to;
        	ArrayList<Ed> list=new ArrayList<>();
        	List<Integer> real=new ArrayList<>();
        	//if(!parent.containsKey(key))break;
        	while(key!=from ) {
        		//System.out.println(key);
        		int fr=parent.get(key);
        		list.add(new Ed(fr,key));
        		key=fr;
        	}
        	int min=Integer.MAX_VALUE;
        	//System.out.println("CrossedFirst"+list.size());
        	for(Ed e:list) {
        		int fr=e.from;
        		//System.out.println("Between first and second");
        		List<Integer> l=graph.getIds(fr);
        		for(int i=0;i<l.size();i++) {
        			int id=l.get(i);
        			Edge edge=graph.getEdge(id);
        			if(e.from==edge.from && e.to==edge.to && edge.capacity>0) {
        				real.add(id);
        				//System.out.println(id);
        				if(edge.capacity<min) {
        					min=edge.capacity;
        				}
        			}
        		}
        	}
        	
        	
        	//System.out.println("CrossedSecond");
        	for(int id:real) {
        		graph.addFlow(id, min);
        	}
        	
        	maxflow+=min;
        	//System.out.println(maxflow);
        	
        	parent.clear();
        	list.clear();
        	real.clear();
        	
        }
        return maxflow;
    }
    
    private static boolean BFS(FlowGraph graph,int source, int sink, Map<Integer,Integer> parent) {
    	//System.out.println("BFS");
    	
    	Set<Integer> visited=new HashSet<>();
    	Queue<Integer> qu=new LinkedList<>();
    	qu.add(source);
    	visited.add(source);
    	while(!qu.isEmpty()) {
    		int u=qu.poll();
    		
    		ArrayList<Integer> list=(ArrayList<Integer>) graph.getIds(u);
    		for(int v=0;v<list.size();v++) {
    			int id=list.get(v);
    			Edge edge=graph.getEdge(id);
    			int k=edge.to;
    			//System.out.println(id);
    			if(!visited.contains(k) && edge.capacity>0) {
    				visited.add(k);
    				qu.add(k);
    				parent.put(k,u);
    				if(visited.contains(sink)) {
    					return true;
    				}
    			}
    			
    
    		}
    	}
    	
    	return false;
    }

    static FlowGraph readGraph() throws IOException {
        int vertex_count = in.nextInt();
        int edge_count = in.nextInt();
        FlowGraph graph = new FlowGraph(vertex_count);

        for (int i = 0; i < edge_count; ++i) {
            int from = in.nextInt() - 1, to = in.nextInt() - 1, capacity = in.nextInt();
            boolean done=false;
            //Capacity[from][to]+=capacity;
            //Capacity[to][from]+=capacity;
            for(int j=0;j<graph.size();j++) {
            	ArrayList<Integer> list=(ArrayList<Integer>) graph.getIds(j);
            	for(int k=0;k<list.size();k++) {
            		int id=list.get(k);
            		Edge edge=graph.getEdge(id);
            		if(edge.from==from && edge.to==to) {
            			done=true;
            		}
            	}
            }
            if(done==false) {
            	graph.addEdge(from, to, capacity);
            }
            
        }
        
        
        
        return graph;
    }

    static class Ed{
    	int from,to;
    	public Ed(int from,int to) {
    		this.from=from;
    		this.to=to;
    	}
    }
    static class Edge {
        int from, to, capacity;

        public Edge(int from, int to, int capacity) {
            this.from = from;
            this.to = to;
            this.capacity = capacity;
            
        }
    }

    /* This class implements a bit unusual scheme to store the graph edges, in order
     * to retrieve the backward edge for a given edge quickly. */
    static class FlowGraph {
        /* List of all - forward and backward - edges */
        private List<Edge> edges;

        /* These adjacency lists store only indices of edges from the edges list */
        private List<Integer>[] graph;

        public FlowGraph(int n) {
            this.graph = (ArrayList<Integer>[])new ArrayList[n];
            for (int i = 0; i < n; ++i)
                this.graph[i] = new ArrayList<>();
            this.edges = new ArrayList<>();
        }

        public void addEdge(int from, int to, int capacity) {
            /* Note that we first append a forward edge and then a backward edge,
             * so all forward edges are stored at even indices (starting from 0),
             * whereas backward edges are stored at odd indices. */
            Edge forwardEdge = new Edge(from, to, capacity);
            Edge backwardEdge = new Edge(to, from, 0);
            graph[from].add(edges.size());
            edges.add(forwardEdge);
            graph[to].add(edges.size());
            edges.add(backwardEdge);
        }

        public int size() {
            return graph.length;
        }

        public List<Integer> getIds(int from) {
            return graph[from];
        }

        public Edge getEdge(int id) {
            return edges.get(id);
        }

        public void addFlow(int id, int flow) {
            /* To get a backward edge for a true forward edge (i.e id is even), we should get id + 1
             * due to the described above scheme. On the other hand, when we have to get a "backward"
             * edge for a backward edge (i.e. get a forward edge for backward - id is odd), id - 1
             * should be taken.
             *
             * It turns out that id ^ 1 works for both cases. Think this through! */
        	
            edges.get(id).capacity -= flow;
            edges.get(id ^ 1).capacity += flow;
        }
    }

    static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;
        

        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        public String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
