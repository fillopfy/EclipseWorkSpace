import java.util.*;
import java.io.*;

public class tree_orders {
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

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
			
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            InOrder(0,result);            
			return result;
		}
		void InOrder(int i, ArrayList<Integer> res) {
			if(left[i]!=-1) {
				InOrder(left[i],res);
			}
			res.add(key[i]);
			if(right[i]!=-1) {
				InOrder(right[i],res);
			}
		}

		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            PreOrder(0,result);            
			return result;
		}
		void PreOrder(int i, ArrayList<Integer> res) {
			res.add(key[i]);
			if(left[i]!=-1) {
				PreOrder(left[i],res);
			}
			if(right[i]!=-1) {
				PreOrder(right[i],res);
			}
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            PostOrder(0,result);            
			return result;
		}
		void PostOrder(int i, ArrayList<Integer> res) {
			if(left[i]!=-1) {
				PostOrder(left[i],res);
			}
			if(right[i]!=-1) {
				PostOrder(right[i],res);
			}
			res.add(key[i]);
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_orders().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
