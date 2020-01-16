import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

public class HashChains {

    private FastScanner in;
    private PrintWriter out;
    // store all strings in one list
    
    // for hash function
    private int bucketCount;
    private Node[] buckets;
    private int prime = 1000000007;
    private int multiplier = 263;

    public static void main(String[] args) throws IOException {
        new HashChains().processQueries();
    }

    private int hash(String s) {
        long h = 0;
        for (int i = s.length() - 1; i >= 0; i--)
            h = (((h * multiplier + s.charAt(i)) % prime) + prime) % prime ;
        return (int)h % bucketCount;
    }

    private Query readQuery() throws IOException {
        String type = in.next();
        if (!type.equals("check")) {
            String s = in.next();
            return new Query(type, s);
        } else {
            int ind = in.nextInt();
            return new Query(type, ind);
        }
    }

    private void writeSearchResult(boolean wasFound) {
        out.println((wasFound==true) ? "yes" : "no");
        // Uncomment the following if you want to play with the program interactively.
         out.flush();
    }
    
    private Node deleteNode(Node head,String str) {
    	if(head==null) return head;
    	Node temp=head,prev=null;
    	if(temp!=null && temp.s.equals(str)) {
    		head=temp.next;
    		return head;
    	}
    	while(temp!=null && !temp.s.equals(str)) {
    		prev=temp;
    		temp=temp.next;
    	}
    	if(temp==null) return head;
    	prev.next=temp.next;
    	return head;
    }
    
    private boolean find(Node head, String str) {
    	if(head==null) return false;
    	if(head.s.equals(str)) return true;
    	Node temp=head;
    	while(temp!=null) {
    		if(temp.s.equals(str)) {
    			return true;
    		}
    		
    		temp=temp.next;
    	}
    	return false;
    }
    
    
    private void print(Node head) {
    	if(head==null) {
    		out.println();
    		return;
    	}
    	Node temp=head;
    	while(temp!=null) {
    		out.print(temp.s+" ");
    		temp=temp.next;
    	}
    	out.println();
    	
    }
    
    private Node add(Node head,String str) {
    	if(head==null) {
    		return new Node(str);
    	}
    	Node temp=head;boolean flag = false;
    	while(flag==false && temp!=null) {
    		if(temp.s.equals(str)) {
    			flag=true;
    		}
    		temp=temp.next;
    	}
    	
    	if(flag==false) {
    		Node u=new Node(str);
    		u.next=head;
    		head=u;
    	}
    	
    	return head;
    }

    private void processQuery(Query query) {
        switch (query.type) {
            case "add":
                buckets[hash(query.s)]=add(buckets[hash(query.s)],query.s);
                break;
                
                
            case "del":
            	buckets[hash(query.s)]=deleteNode(buckets[hash(query.s)],query.s);
                break;
                
            case "find":
            	writeSearchResult(find(buckets[hash(query.s)], query.s));
                break;
                
            case "check":
            	print(buckets[query.ind]);
                // Uncomment the following if you want to play with the program interactively.
                // out.flush();
                break;
            default:
                throw new RuntimeException("Unknown query: " + query.type);
        }
    }

    public void processQueries() throws IOException {
        
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        bucketCount = in.nextInt();
        buckets=new Node[bucketCount];
        int queryCount = in.nextInt();
        for (int i = 0; i < queryCount; ++i) {
            processQuery(readQuery());
        }
        out.close();
    }
    
    static class Node{
    	String s;
    	Node next;
    	public Node(String s) {
    		this.s=s;
    		next=null;
    	}
    }
    static class Query {
        String type;
        String s;
        int ind;

        public Query(String type, String s) {
            this.type = type;
            this.s = s;
        }

        public Query(String type, int ind) {
            this.type = type;
            this.ind = ind;
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
