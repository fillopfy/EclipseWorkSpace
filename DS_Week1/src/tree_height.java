import java.util.*;
import java.io.*;

public class tree_height {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeHeight {
		int n;
		
		int parent[];
		
		class Node{
			int val;
			ArrayList<Node> child=new ArrayList<>();
			public Node(int val){
				this.val=val;
			}
			
			public void addChild(Node c) {
				child.add(c);
			}
		}
		Node[] nodes;
		Node root;
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			parent = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = in.nextInt();
			}
			nodes=new Node[n];
			for(int i=0;i<n;i++) {
				nodes[i]=new Node(i);
			}
			
			for(int i=0;i<n;i++) {
				int parent_index=parent[i];
				if(parent_index==-1) {
					root=nodes[i];
				}else {
					nodes[parent_index].addChild(nodes[i]);
				}
				
			}
			
		}

		int computeHeight() {
            // Replace this code with a faster implementation
			int maxHeight = getHeight(root.child);
			
			return maxHeight;
		}
		int getHeight(ArrayList<Node> root) {
			int height=0;
			if(root==null) {
				return height;
			}
			
			
			
			for(Node n:root) {
				height=Math.max(height, getHeight(n.child));
			}
			return height+1;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_height().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}
	public void run() throws IOException {
		TreeHeight tree = new TreeHeight();
		tree.read();
		System.out.println(tree.computeHeight());
	}
}
