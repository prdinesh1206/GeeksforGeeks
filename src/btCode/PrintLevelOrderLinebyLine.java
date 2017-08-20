package btCode;

import java.util.LinkedList;
import java.util.Queue;

//Print level order traversal line by line
public class PrintLevelOrderLinebyLine {

	public void printLinebyLine(Node root){
		Queue<Node> q= new LinkedList();
		
		q.add(root);
		q.add(new Node(-1));
		Node n;
		while(!q.isEmpty()){
			
			n=q.remove();
			if((int)n.data==-1){
				System.out.println();
				//q.add(new Node(-1));
			}
			else{
				
					System.out.print(n.data+" ");
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
				if((int)q.peek().data==-1&&(n.left!=null||n.right!=null))
					q.add(new Node(-1));
				
			}
		}
	}
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		
		tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.right= new Node(6);
	       new PrintLevelOrderLinebyLine().printLinebyLine(tree.root);
	}
}
