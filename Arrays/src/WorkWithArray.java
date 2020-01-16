import java.util.*;

public class WorkWithArray {
	
	
	public static int[] arr=new int[6];
	public static void main(String[] args) {
		Print();
		Insert(0,2);
		Insert(1,4);
		Print();
		Insert(2,8);Print();
		Insert(3,8);Print();
		Insert(4,0);Print();
		Insert(5,9);Print();
		Remove(5);Print();
		Remove(4);Print();
		Insert(1,8);Print();
		
	}
	
	public static void Insert(int index,int x) {
		
		if(index<0 || index>=arr.length) {
			System.out.println("Out of range!");
			return;
		}
		
		for(int i=index;i<arr.length-1;i++) {
			int e=arr[i+1];
			int p=arr[i];
			arr[i+1]=p;
			p=e;
		}
		arr[index]=x;
		
	}
	

	
	public static void Remove(int index) {
		if(index<0 || index>=arr.length) {
			System.out.println("Out of range!");
			return;
		}
		int i;
		for(i=index;i<arr.length-1;i++) {
			arr[i]=arr[i+1];
			
		}
		
		arr[i]=0;
		
		
	}
	
	public static void Print() {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
}
