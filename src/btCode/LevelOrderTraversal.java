package btCode;

public class LevelOrderTraversal {

	BinaryTree bt;
	public LevelOrderTraversal(BinaryTree bt){
		this.bt=bt;
	}
	public int heightOfTree(Node root){
		if(root==null)
			return 0;
		int left=heightOfTree(root.left);
		int right=heightOfTree(root.right);
		
		if(left>=right){
			return left+1;
		}else{
			return right+1;
		}
		
	}
	
	public void levelOrderTraversal(Node root){
		
		if(root==null)
		return;
		int height=heightOfTree(root);
		
		for(int i=0;i<height;i++){
			levelOrderPrint(root,i);
		}
	}
	public void levelOrderPrint(Node root, int h){
		if(root==null)
			return;
		if(h==0){
			System.out.print(root.data+" ");
			return;
		}
		levelOrderPrint(root.left,h-1);
		levelOrderPrint(root.right, h-1);
		
	}
	public static void main(String[] args){
		 BinaryTree tree = new BinaryTree();
		   LevelOrderTraversal lv=new LevelOrderTraversal(tree);
	       tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	  
	       System.out.println("Level order traversal of binary tree is ");
	    lv.levelOrderTraversal(tree.root);
	        
	       
	       
	}
}
