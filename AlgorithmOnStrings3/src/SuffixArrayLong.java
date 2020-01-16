import java.util.*;
import java.io.*;
import java.util.zip.CheckedInputStream;

public class SuffixArrayLong {
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

    public class Suffix implements Comparable {
        String suffix;
        int start;

        Suffix(String suffix, int start) {
            this.suffix = suffix;
            this.start = start;
        }

        @Override
        public int compareTo(Object o) {
            Suffix other = (Suffix) o;
            return suffix.compareTo(other.suffix);
        }
    }

    // Build suffix array of the string text and
    // return an int[] result of the same length as the text
    // such that the value result[i] is the index (0-based)
    // in text where the i-th lexicographically smallest
    // suffix of text starts.
    public int[] computeSuffixArray(String text) {
        
        int n=text.length();
        int[] order=new int[n];
        int[] Class=new int[n];
        order=SortCharacters(text);
        Class=ComputeCharClasses(text,order);
        int L=1;
        while(L<n) {
        	order=SortDoubled(text,L,order,Class);
        	Class=UpdateClasses(order,Class,L);
        	L=2*L;
        }
        // write your code here
        

        return order;
    }
    
    int[] SortCharacters(String s) {
    	int n=s.length();
    	int[] order=new int[s.length()];
    	int[] count=new int[256];
    	Arrays.fill(count, 0);
    	for(int i=0;i<n;i++) {
    		count[(int)s.charAt(i)]+=1;
    	}
    	for(int j=1;j<256;j++) {
    		count[j]+=count[j-1];
    	}
    	for(int i=n-1;i>=0;i--) {
    		char c=s.charAt(i);
    		count[(int)c]-=1;
    		order[count[(int)c]]=i;
    	}
    	return order;
    }
    
    int[] ComputeCharClasses(String s,int[] order) {
    	int n=s.length();
    	int[] Class=new int[n];
    	Class[order[0]]=0;
    	for(int i=1;i<n;i++) {
    		if(s.charAt(order[i])!=s.charAt(order[i-1])) {
    			Class[order[i]]=Class[order[i-1]]+1;
    		}else {
    			Class[order[i]]=Class[order[i-1]];
    		}
    	}
    	
    	return Class;
    }
    
    int[] SortDoubled(String s,int L,int[] order, int[] Class) {
    	int n=s.length();
    	int[] count=new int[n];
    	int[] newOrder=new int[n];
    	for(int i=0;i<n;i++) {
    		count[Class[i]]+=1;
    	}
    	
    	for(int j=1;j<n;j++) {
    		count[j]+=count[j-1];
    	}
    	int start=0;
    	for(int i=n-1;i>=0;i--) {
    		start=(order[i]-L+n)%n;
    		int cl=Class[start];
    		count[cl]-=1;
    		newOrder[count[cl]]=start;
    	}
    	
    	return newOrder;
    }
    
    int[] UpdateClasses(int[] newOrder, int[] Class, int L) {
    	int n=newOrder.length;
    	int[] newClass=new int[n];
    	newClass[newOrder[0]]=0;
    	int cur=0,prev=0,mid=0,midPrev=0;
    	for(int i=1;i<n;i++) {
    		cur=newOrder[i];
    		prev=newOrder[i-1];
    		mid=cur+L;
    		midPrev=(prev+L)%n;
    		if(Class[cur]!=Class[prev] || Class[mid]!=Class[midPrev]) {
    			newClass[cur]=newClass[prev]+1;
    		}else {
    			newClass[cur]=newClass[prev];
    		}
    	}
    	if(L==2)System.out.println(newClass[2]);
    	return newClass;
    }


    static public void main(String[] args) throws IOException {
        new SuffixArrayLong().run();
    }

    public void print(int[] x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String text = scanner.next();
        int[] suffix_array = computeSuffixArray(text);
        print(suffix_array);
    }
}
