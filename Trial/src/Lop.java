import java.io.BufferedOutputStream;
import java.io.PrintWriter;



public class Lop {
	
	private static PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out));
	static class Node{
		String s;
		Node next;
		public Node(String str) {
			this.s=str;
			next=null;
		}
	}
	static Node head;
	private static Node deleteNode(Node head,String str) {
    	if(head==null) return head;
    	Node temp=head,prev=null;
    	if(temp!=null && temp.s==str) {
    		head=temp.next;
    		return head;
    	}
    	while(temp!=null && temp.s!=str) {
    		prev=temp;
    		temp=temp.next;
    	}
    	if(temp==null) return head;
    	prev.next=temp.next;
    	return head;
    }
    
    private static boolean find(Node head, String str) {
    	if(head==null) return false;
    	if(head.s==str) return true;
    	Node temp=head;
    	while(temp!=null) {
    		if(temp.s==str) {
    			return true;
    		}
    		
    		temp=temp.next;
    	}
    	return false;
    }
    
    
    private static void print(Node head) {
    	if(head==null) {
    		out.println();
    		return;
    	}
    	Node temp=head;
    	while(temp!=null) {
    		out.print(temp.s+" ");
    		temp=temp.next;
    	}
    	out.println();
    	
    }
    
    private static Node add(Node head,String str) {
    	if(head==null) {
    		return new Node(str);
    	}
    	Node temp=head;boolean flag = false;
    	while(flag==false && temp!=null) {
    		if(temp.s==str) {
    			flag=true;
    		}
    		temp=temp.next;
    	}
    	
    	if(flag==false) {
    		Node u=new Node(str);
    		u.next=head;
    		head=u;
    	}
    	
    	return head;
    }
    
    public static void main(String[] args) {
    	add(head,"Abhishek");
    	add(head,"Kamal");
    	add(head,"Man");
    	print(head);
    	deleteNode(head,"Tiwari");
    	print(head);
    	deleteNode(head,"Abhishek");
    	print(head);
    	System.out.println(find(head,"Abhishek")?"yes":"no");
    	System.out.println(find(head,"Man")?"yes":"no");
    }

}
