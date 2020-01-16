import java.util.*;
import java.io.*;

public class is_bst_hard {
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

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
          // Implement correct algorithm here
        	if(nodes==0) return true;
        	//if(nodes==1 && tree[0].key==Integer.MAX_VALUE)return true;
          return IS(0,Long.MIN_VALUE, Long.MAX_VALUE);
        }
        boolean val1=true, val2=true;
        boolean IS(int i, long min, long max) {
        	if(tree[i].key<min || tree[i].key>=max) {
        		return false;
        	}
        	
        	if(tree[i].left!=-1) {
        		val1=IS(tree[i].left,min,tree[i].key);
        	}
        	if(tree[i].right!=-1) {
        		val2=IS(tree[i].right,tree[i].key,max);
        	}
        	
        	return val1 && val2;
        }
    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst_hard().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }
    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
