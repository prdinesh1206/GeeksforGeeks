package btCode;

public class DoubleTree {

	Node root;
	
	public Node solve(Node node){
		if(node==null)
			return null;
		
		Node left=solve(node.left);
		Node right=solve(node.right);
		
		node.left=new Node(node.data);
		node.left.left=left;
		node.right=right;
		
		return node;
	}
	public void printPreOrder(Node node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
	
	public static void main(String[] args){
		DoubleTree tree=new DoubleTree();
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        
        tree.printPreOrder(tree.root);
		System.out.println();
		
		tree.solve(tree.root);
		tree.printPreOrder(tree.root);
		
	}
}
