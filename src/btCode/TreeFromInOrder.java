package btCode;

public class TreeFromInOrder {

	//Node root;
	char[] io, po;
	int i;
	int pre;
	public Node solve( int l, int h){
		if(l>h){
			return null;
		}
		int mid=0;
		char find;
		find=po[pre++];
		Node root=new Node(find);
		
		for(i=l;i<=h;i++){
			if(find==io[i])
				mid=i;
		}
		root.left=solve( l, mid-1);
		root.right=solve( mid+1, h);
		return root;
	}
	
	public static void main(String[] args){
		TreeFromInOrder tree=new TreeFromInOrder();
		tree.io = new char[]{'D', 'B', 'E', 'A', 'F', 'C'};
        tree.po = new char[]{'A', 'B', 'D', 'E', 'C', 'F'};
        tree.pre=0;
		Node root=tree.solve(0, tree.io.length-1);
		
		 new InOrderWithoutRecu().inOrder(root);
	}
}
