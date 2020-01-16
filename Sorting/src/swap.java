
public class swap {
	public static void main(String[] args) {
		int a=4;
		int b=5;
		System.out.println("a="+a+" & b="+b+" ");
		swa(a,b);
		System.out.println("a="+a+" & b="+b+" ");
	}
	
	public static void swa(int x, int y) {
		int te=x;
		x=y;
		y=te;

	}
}
