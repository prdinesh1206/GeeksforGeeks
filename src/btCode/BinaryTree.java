package btCode;

public class BinaryTree {

	Node root;
	public BinaryTree(){
		root=null;
	}
	public void printPreOrder(Node node){
		if(node==null)
			return;
		System.out.print(node.data);
		printPreOrder(node.left);
		printPreOrder(node.right);
	}
}
