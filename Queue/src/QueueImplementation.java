import java.util.*;
import java.io.*;

public class QueueImplementation {
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data=data;
			next=null;
		}
	}
	
	static Node queue;
	public static void main(String args[]) {
		
		//Print();
		Enqueue(2);
		//Print();
		Enqueue(4);
		Print();
		Enqueue(6);
		Print();
		Enqueue(8);
		System.out.println(Dequeue());
		Print();
		
		
		
	}
	
	public static void Print() {
		if(queue==null) {
			System.out.println("Empty!");
		}
		Node temp=queue;
		while(temp.next!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
		System.out.println();
	}
	
	public static void Enqueue(int val) {
		Node node =new Node(val);
		
		if(queue==null) {
			queue=node;
		}
		
		node.next=queue;
		queue=node;
	}
	
	public static int Dequeue() {
		if(queue==null) {
			System.out.println("No element to dequeue!");
			return -1;
		}
		Node temp=queue;
		while(temp.next.next!=null) {
			temp=temp.next;
		}
		int d=temp.next.data;
		temp.next=null;
		return d;
	}
	
	public static int Peek() {
		if(queue==null) {
			return -1;
		}
		return queue.data;
	}
}
