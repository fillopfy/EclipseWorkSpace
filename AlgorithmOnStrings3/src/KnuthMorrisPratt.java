import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KnuthMorrisPratt {
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

    // Find all the occurrences of the pattern in the text and return
    // a list of all positions in the text (starting from 0) where
    // the pattern starts in the text.
    public List<Integer> findPattern(String pattern, String text) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        // Implement this function yourself
        if(pattern.length()>text.length() || text==null || pattern==null) {
        	return result;
        }
        StringBuilder str=new StringBuilder(pattern);
        str.append('$');
        str.append(text);
        String string=str.toString();
        int n=string.length();
        int[] s=new int[n];
        s[0]=0;int border=0;
        for(int i=1;i<n;i++) {
        	while(border>0 && string.charAt(i)!=string.charAt(border)) {
        		border=s[border-1];
        	}
        	
        	if(string.charAt(i)==string.charAt(border)) {
        		border+=1;
        	}else {
        		border=0;
        	}
        	
        	s[i]=border;
        }
        int p=pattern.length();
        for(int i=p+1;i<string.length();i++) {
        	if(s[i]==p) {
        		result.add(i-2*p);
        	}
        }
        return result;
    }
    
    

    static public void main(String[] args) throws IOException {
        new KnuthMorrisPratt().run();
    }

    public void print(List<Integer> x) {
        for (int a : x) {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    public void run() throws IOException {
        FastScanner scanner = new FastScanner();
        String pattern = scanner.next();
        String text = scanner.next();
        List<Integer> positions = findPattern(pattern, text);
        print(positions);
    }
}
