import java.util.*;
import java.io.*;

public class Implementation {

	static int[] stack=new int[100];
	static int index=-1;
	public static void main(String args[]) throws Exception{
		
		Push(2);
		Print();
		Pop();
		Print();
		Push(4);
		Push(8);
		Push(0);
		Print();
		Pop();
		Print();
		if(IsEmpty()) {
			System.out.println("Its empty");
		}else {
			System.out.println("Not Empty");
		}
		
	}
	
	public static void Push(int x) {
		stack[++index]=x;
	}
	
	public static int Pop() {
		if(IsEmpty()) {
			System.out.println("Empty stack");
			return -1;
		}
		index-=1;
		return stack[index+1];
	}
	
	public static boolean IsEmpty() {
		if(index==-1) {
			//System.out.println("Empty stack");
			return true;
		}
		return false;
	}
	
	public static int top() {
		if(IsEmpty()) {
			System.out.println("Empty stack");
			return -1;
		}
		return stack[index];
	
	}
	
	public static void Print() {
		if(index==-1) {
			System.out.println("Empty");
		}
		for(int i=0;i<=index;i++) {
			System.out.print(stack[i]+" ");
		}
		System.out.println();
	}
	
	
}
