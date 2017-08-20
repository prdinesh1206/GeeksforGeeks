package btCode;

public class MirrorTree {

	public Node mirror(Node root){
		if(root==null)
			return null;
		
		Node left=mirror(root.left);
		Node right=mirror(root.right);
		Node temp;
		
		root.left=right;
		root.right=left;
		return root;
	}
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		   tree.root= new Node(1);
	       tree.root.left= new Node(3);
	       tree.root.right= new Node(2);
	       tree.root.right.left= new Node(5);
	       tree.root.right.right= new Node(4);
	      // tree.root.right.left= new Node(6);
	       
	     Node root=  new MirrorTree().mirror(tree.root);
	     new InOrderMorris().inOrderMorris(root);
	}
}
