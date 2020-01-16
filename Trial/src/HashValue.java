
public class HashValue {
	private static int prime = 1000000007;
    private static int multiplier = 263;
	private static int hash(String s, int bucketCount) {
	        long h = 0;
	        for (int i = s.length() - 1; i >= 0; --i)
	            h = (((h * multiplier + s.charAt(i)) % prime)+prime)%prime;
	        return (int)h % bucketCount;
	    }
	public static void print(int x) {
		System.out.println(x);
	}
	public static void main(String[] args) {
		print(hash("kutta",8));
	}
}
