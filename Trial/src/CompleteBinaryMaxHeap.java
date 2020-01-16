import java.io.*;
import java.util.*;

public class CompleteBinaryMaxHeap {
	static int size=0;
	static int maxSize=1;
	static int[] H=new int[maxSize];
	public static void main(String args[]) {
		
		
	}
	
	public static int Parent(int index) {
		return (int)Math.floor(index/2);
	}
	
	public static int LeftChild(int index) {
		return 2*index;
	}
	
	public static int RightChild(int index) {
		return 2*index +1;
	}
	
	public static void ShiftUp(int index) {
		
	}
	
	public static void ShiftDown(int index) {
		
	}
	
	public static void ChangePriority(int index,int priority) {
		
	}
	
	public static void Insert(int el) {
		
	}
	
	public static int ExtractMax() {
		int res=H[0];
		H[0]
	}
	
	public static void Remove(int i) {
		H[i]=Integer.MAX_VALUE;
		ShiftUp(i);
		ExtractMax();
	}
	
}
