package btCode;

public class InOrderMorris {

	public void inOrderMorris(Node root){
		
		Node c=root, node;
		while(c!=null){
			if(c.left==null){
				System.out.print(c.data+" ");
				c=c.right;
			}else{
				node=c.left;
				while(node.right!=null&&node.right!=c){
					node=node.right;
				}
				if(node.right==null){
					node.right=c;
					c=c.left;
				}else if(node.right==c){
					System.out.print(c.data+" ");
					c=c.right;
				}
				
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
	       tree.root.right.left= new Node(6);
	       
	       new InOrderMorris().inOrderMorris(tree.root);
	}
}
