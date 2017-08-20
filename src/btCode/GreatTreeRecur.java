package btCode;

public class GreatTreeRecur {

	public Node greatTree(Node root){
		if(root==null)
			return root;
		
		Node left=greatTree(root.left);
		Node right=greatTree(root.right);
		
		Node rightMost=findMostRight(left);
		Node leftMost=findMostLeft(right);
		
		if(rightMost!=null)
		rightMost.right=root;
		root.left=rightMost;
		
		if(leftMost!=null)
		leftMost.left=root;
		root.right=leftMost;
		
		return root;
		
		
	}
	public Node findMostRight(Node node){
		Node c=node;
		if(node==null)
			return null;
		while(c.right!=null)
			c=c.right;
		return c;
		
	}
	public Node findMostLeft(Node node){
		Node c=node;
		if(node==null)
			return null;
		while(c.left!=null){
			c=c.left;
		}	
		return c;
		
	}
	
	public static void main(String[] args){
BinaryTree tree=new BinaryTree();
		
		tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.left= new Node(6);
		GreatTreeRecur gtr=new GreatTreeRecur();
		Node root=gtr.greatTree(tree.root);
		
		root=gtr.findMostLeft(root);
		
		Node c=root;
		while(c!=null){
			System.out.print(c.data+" ");
			c=c.right;
		}
		
	}
}
