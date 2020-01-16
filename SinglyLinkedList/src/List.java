import java.util.*;

class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
		this.next=null;
	}
}


public class List {
	
	public static Node head;
	public static final Scanner scan=new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Enter elements to eneter: ");
		int n=scan.nextInt();int j=0;
		
		while(j<n) {
			Node node=new Node(scan.nextInt());
			if(head==null) {
				head=node;
			}else {
				Node p=head;
				while(p.next!=null) {
					p=p.next;
				}
				p=node;
			
			}
			j++;
			
		}
		
		Print();
		
		
		
	}
	
	public static void Print() {
		if(head==null) {
			System.out.println("List is empty.");
			
			return;
		}
		Node op=head;
		while(op.next!=null) {
			System.out.print(op.data+" ");
			op=op.next;
		}
		System.out.println();
	}
	
	//Adding element in front of List
	public static void PushFront(int key) {
		Node node=new Node(key);
		if(head==null) {
			head=node;
		}
		
		node.next=head.next;
		head=node;
	}
	
	
	//See the top element of the list
	public static int TopFront() {
		if(head==null) {
			return -1;
		}
		return head.data;
	}
	
	
	//Removing element from top
	public static void PopFront() {
		if(head==null) {
			return;
		}
		head=head.next;
	}
	
	
	//Adding element in the last of list
	public static void PushBack(int key) {
		Node newNode=new Node(key);
		if(head==null) {
			head=newNode;
		}
		
		Node node=head;
		while(node.next!=null) {
			node=node.next;
		}
		node=newNode;
	}
	
	
	//See the last element of the list
	public static int TopBack() {
		if(head==null) {
			return -1;
		}
		Node node=head;
		while(node.next!=null) {
			node=node.next;
		}
		return node.data;
	}
	
	//Remove last element of the list
	public static void PopBack() {
		if(head==null) {
			return;
		}
		Node node=head;
		
		if(node!=null && node.next==null) {
			node=null;
		}
		
		
		while(node.next.next!=null) {
			node=node.next;
		}
		node.next=null;
	}
	
	//Check if given element is present in list
	public static boolean Find(int key) {
		if(head==null) {
			return false;
		}
		Node node=head;
		while(node.next!=null) {
			if(node.data==key) {
				return true;
			}
			node=node.next;
		}
		return false;
	}
	
	
	//Remove a given element from list
	public static void Erase(int key) {
		if(head==null) {
			return;
		}
		Node node=head;Node prev=head;
		while(node.next!=null || node.data!=key) {
			prev=node;
			node=node.next;
		}
		if(node.next==null) {
			return;
		}
		prev.next=node.next;
	}
	
	
	//Check if list is empty
	public static boolean Empty() {
		if(head==null) {
			return true;
		}
		return false;
	}
	
	//Adding an element before a given node
	public static void AddBefore(Node node,int key) {
		
	}
	
	//Adding an element after a given node
	public static void AddAfter(Node node, int key) {
		
	}
}
