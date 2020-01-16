import java.util.*;

class Node{
	int data;
	Node root,left,right;

	public Node(int data) {
		this.data=data;
		left=null;
		right=null;
	}
}

public class BST {
	
	private static Node root=new Node(1);
	final static Random rand=new Random();
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++) {
			//int d=rand.nextInt();
			BST.Insert(root,i);
			BST.Print(root);
		}
		
		BST.Print(root);
	}
	
	//Printing elements of the tree
	public static void Print(Node root) {
		if(root==null) {
			System.out.println("No element!");
			return;
		}
		if(root!=null && (root.left==null && root.right!=null)) {
			System.out.print(root.data+" ");
			return;
		}
		Node temp=root;
		while(temp.left!=null || temp.right!=null) {
			System.out.print(temp.data+" ");
			if(temp.left!=null) {
				System.out.print(temp.left.data+" ");
			}
			if(temp.right!=null) {
				System.out.print(temp.right.data+" ");
			}
		}
		
		System.out.println();
	}
	
	
	//Inserting elements in a tree based on BST
	public static void Insert(Node root,int data) {
		Node node=new Node(data);
		if(root==null) {
			root=node;
		}
		Node temp=root;
		if(temp.left!=null || temp.root!=null) {
			if(data>temp.data && temp.right!=null) {
				Insert(temp.right,data);
			}
			if(data<temp.data && temp.left!=null) {
				Insert(temp.left,data);
			}
		}
	}
}
