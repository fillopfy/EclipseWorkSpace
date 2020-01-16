import java.util.*;

public class DynamicArrayImplementation {
	
	private static int capacity=5;
	private static int size=0;
	private static int[] arr=new int[capacity];
	
	public static void main(String args[]) {
		Random rand=new Random();
		for(int i=0;i<capacity;i++) {
			PushBack(rand.nextInt());
		}
		
		for(int i=0;i<size;i++) {
			System.out.print(Get(i)+" ");
		}
		System.out.println();
		PushBack(1);
		for(int i=0;i<size;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		System.out.println("Size is "+Size());
		Remove(size-1);
		System.out.println(Size());
		
		
	}
	
	public static int Get(int index) {
		if(index<0 || index>=capacity) {
			System.out.println("Out of Range.");
			return -1;
		}
		return arr[index];
	}
	
	public static void Set(int index, int value) {
		if(index<0 || index>=capacity) {
			System.out.println("Invalid Entry");
		}
		arr[index]=value;
	}
	
	public static void PushBack(int val) {
		if(size==capacity) {
			int[] arrN=new int[2*capacity];
			for(int i=0;i<size;i++) {
				arrN[i]=arr[i];
			}
			arr=arrN;
		}
		arr[size]=val;
		size+=1;
	}
	
	public static void Remove(int index) {
		if(index<0 || index>=capacity) {
			System.out.println("Out of range");
		}
		for(int i=index;i<size;i++) {
			arr[i]=arr[i+1];
		}
		size-=1;
	}
	
	public static int Size() {
		return size;
	}
}
