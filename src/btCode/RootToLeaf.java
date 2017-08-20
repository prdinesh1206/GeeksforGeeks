package btCode;

public class RootToLeaf {

	public void printRootToLeaf(Node root, int height, int[] array){
		if(root==null)
			return;
		if(root.left==null&&root.right==null){
			array[height]=(int) root.data;
		printArray(height, array);
		return;
		}
		array[height]=(int) root.data;
		printRootToLeaf(root.left, height+1, array);
		printRootToLeaf(root.right, height+1, array);
	}
	public void printArray(int h, int[] a){
		for(int i=0;i<=h;i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
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
	public static void main(String[] args){
		BinaryTree tree=new BinaryTree();
		   tree.root= new Node(1);
	       tree.root.left= new Node(2);
	       tree.root.right= new Node(3);
	       tree.root.left.left= new Node(4);
	       tree.root.left.right= new Node(5);
	       tree.root.right.left= new Node(6);
	       RootToLeaf rtf=new RootToLeaf();
	       
	       int height=rtf.heightOfTree(tree.root);
	       int[] a=new int[height];
	       
	       rtf.printRootToLeaf(tree.root, 0,a);
	}
}
