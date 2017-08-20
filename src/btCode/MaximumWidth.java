package btCode;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

	Node root;
	Queue<Node> q;
	
	public void solve(){
		Node c=root, t=new Node('|');
		q=new LinkedList<Node>();
		q.add(c);
		q.add(t);
		int width=0,level=0;
		while(!q.isEmpty()){
		     c=q.remove();
		     if(c!=t){
		    	 width++;
		    	 if(c.left!=null)
		    	 q.add(c.left);
		    	 if(c.right!=null)
		    	 q.add(c.right);
		    	 if(q.peek()==t)
		    		 q.add(t);
		     }else if(q.peek()!=null){
		    	 level++;
		    	 System.out.println("Width of level "+level+" is "+width);
		    	 width=0;
		    	 
		     }
		}
	} 
	
	public static void main(String[] args){
		MaximumWidth tree=new MaximumWidth();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(8);
        tree.root.right.right.left = new Node(6);
        tree.root.right.right.right = new Node(7);
        
        tree.solve();
	}
}
