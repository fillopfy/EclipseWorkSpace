import java.io.*;
import java.util.*;


public class TrieMatchingExtended implements Runnable {

	class Node{
		Map<Character, Node> children;
		boolean endOfWord;
		public Node() {
			this.children=new HashMap<>();
			this.endOfWord=false;
		}
	}
	//ACATA 3 AT A AG
	Node buildTrie(List<String> patterns) {
		Node root=new Node();
		for(String s: patterns) {
			Node current=root;
			for(int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				Node node=current.children.get(c);
				if(node==null) {
					node=new Node();
					current.children.put(c,node);
				}
				current=node;
			}
			current.endOfWord=true;
		}
		
		return root;
	}
	
	boolean prefixTrieMatching(String text,Node trie) {
		int i=0;int n=text.length();
		char symbol=text.charAt(i);
		Node v=trie;
		while(true) {
			if(v!=null && v.endOfWord==true) {
				return true;
			}else {
				if(v.children!=null && v.children.get(symbol)!=null) {
					v=v.children.get(symbol);
					symbol=(i+1<n)?text.charAt(++i):' ';
					
				}else {
					return false;
				}
			}
			
		}
	}
// 2  GGGT 
	List <Integer> solve (String text, int n, List <String> patterns) {
		List <Integer> result = new ArrayList <Integer> ();

		// write your code here
		Node trie=buildTrie(patterns);
		int i=0,m=text.length();
		while(i<m) {
			if(prefixTrieMatching(text.substring(i),trie)==true) {
				result.add(i);
			}
			++i;
		}
		return result;
	}

	public void run () {
		try {
			BufferedReader in = new BufferedReader (new InputStreamReader (System.in));
			String text = in.readLine().trim();
		 	int n = Integer.parseInt (in.readLine ().trim());
		 	List <String> patterns = new ArrayList <String> ();
			for (int i = 0; i < n; i++) {
				patterns.add (in.readLine ().trim());
			}

			List <Integer> ans = solve (text, n, patterns);

			for (int j = 0; j < ans.size (); j++) {
				System.out.print ("" + ans.get (j));
				System.out.print (j + 1 < ans.size () ? " " : "\n");
			}
		}
		catch (Throwable e) {
			e.printStackTrace ();
			System.exit (1);
		}
	}

	public static void main (String [] args) {
		new Thread (new TrieMatchingExtended ()).start ();
	}
}
