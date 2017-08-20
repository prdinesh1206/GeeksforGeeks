package btCode;

public class ChildSum {

	Node root;
	
	public int solve(Node node){
		if(node==null)
			return 0;
		if(node.left==null&&node.right==null)
			return (int) node.data;
		
		int left=solve(node.left);
		int right=solve(node.right);
		
		int diff=(int)node.data-(left+right);
		if(diff==0)
			return (int)node.data;
		if(diff<0){
			node.data=left+right;
			
		}else{
			if(node.left!=null)
			addToLeft(node.left,diff);
			else if(node.right!=null)
				addToLeft(node.right, diff);
		}
		return (int)node.data;
	}
	public void addToLeft(Node node, int value){
		if(node==null)
			return;
		
		node.data=(int)node.data+value;
		 if(node.left!=null)
		    addToLeft(node.left,value);
		else if(node.right!=null)
			addToLeft(node.right,value);
	}
	public static void main(String[] args){
		ChildSum ch=new ChildSum();
		 BinaryTree tree = new BinaryTree();
	        tree.root = new Node(50);
	        tree.root.left = new Node(7);
	        tree.root.right = new Node(2);
	        tree.root.left.left = new Node(3);
	        tree.root.left.right = new Node(5);
	        tree.root.right.left = new Node(1);
	        tree.root.right.right = new Node(30);
	        new InOrderWithoutRecu().inOrder(tree.root);
	        System.out.println();
	        ch.solve(tree.root);
	        new InOrderWithoutRecu().inOrder(tree.root);
	}
}
