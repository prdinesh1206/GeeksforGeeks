import java.util.Queue;
import java.util.LinkedList;
public class FindHeightBT {

	class Node 
	{
	    int data;
	    Node left, right;
	  
	    Node(int item) 
	    {
	        data = item;
	        left = right;
	    }
	}
	Node root;
	  
	public int findHeight(Node node){
		if(node==null)
			return 0;
		
		int left=findHeight(node.left);
		int right=findHeight(node.right);
		
		if(left>=right)
			return left+1;
		else
			return right+1;
	}
	
	public int findHeightQueue(Node node){
		Queue<Node> q=new LinkedList();
		Node del=new FindHeightBT().new Node(-1);
		int height=0;
		
		q.add(node);
		q.add(del);
		Node n;
		while(!q.isEmpty()){
			n=q.remove();
			if(n.data==-1){
				height++;
			}else{
				if(n.left!=null||n.right!=null){
				if(n.left!=null)
					q.add(n.left);
				if(n.right!=null)
					q.add(n.right);
				q.add(del);
				}	    
			}
		}
		return height;
	}
	public static void main(String[] args){
		FindHeightBT tree=new FindHeightBT();
		tree.root = tree.new Node(1);
        tree.root.left = tree.new Node(2);
        tree.root.right = tree.new Node(3);
        tree.root.left.left = tree.new Node(4);
        tree.root.left.right = tree.new Node(5);
        
        System.out.println("Height of the tree is "+tree.findHeightQueue(tree.root));
        
        
		
	}
}
