import java.util.*;

class Node{
	int data;
	Node prev;
	Node next;
	Node(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}

public class DoublyLinkedListOperations {
	
	public static Node head;
	public static final Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Enter no of elements you want to enetr: ");
		int n=scan.nextInt();
		for(int i=0;i<n;i++) {
			int el=scan.nextInt();
			Node node=new Node(el);
			if(head==null) {
				head=node;
			}
			Node p=head;
			while(p.next!=null) {
				p=p.next;
			}
			p.next=node;
			node.prev=p;
			
		}
		
		Print();
		
	}
	
	public static void Print() {
		if(head==null) {
			System.out.println("Empty list.");
			return;
		}
		
		Node ob=head;
		while(ob.next!=null) {
			System.out.print(ob.data+" ");
			ob=ob.next;
		}
		
	}
	
	public static void PopBack() {
		
	}
	
	public static void PushBack() {
		
	}
	
	public static void  AddAfter(Node node, int key) {
		
	}
	
	
}
