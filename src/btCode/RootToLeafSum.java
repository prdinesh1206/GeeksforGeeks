package btCode;

public class RootToLeafSum {

	Node root;
	
	public boolean solve(Node node, int value){
		if(node==null||value<0)
			return false;
		if(node.left==null&&node.right==null)
		{
			if(value==(int)node.data)
				return true;
		}
		boolean left=solve(node.left,value-(int)node.data);
		boolean right=solve(node.right,value-(int)node.data);
		return left||right;
		
	}
	public static void main(String[] args){
		RootToLeafSum tree=new RootToLeafSum();
		tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(2);
  
        if(tree.solve(tree.root, 18)){
        	System.out.println("Yes");
        }
        else
        	System.out.println("No");
		
	}
}
