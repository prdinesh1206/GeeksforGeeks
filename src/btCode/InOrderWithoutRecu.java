package btCode;

import java.util.LinkedList;
import java.util.Stack;

public class InOrderWithoutRecu {

	public void inOrder(Node node){
		Stack<Node> stack=new Stack();
		Node c;
		while(node!=null||!stack.isEmpty()){
			c=node;
		while(c!=null){
			stack.push(c);
			c=c.left;
		}
		node=stack.pop();
		System.out.print(node.data+" ");
		node=node.right;
		
	}
	}
	
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		   tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.left= new Node(6);
	       
	       new InOrderWithoutRecu().inOrder(tree.root);
	}
}
