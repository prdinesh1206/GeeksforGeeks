package btCode;

public class TreeFromPostOrder {
	
	int[] io, post;
	int i;
	int po;
	public Node solve( int l, int h){
		if(l>h){
			return null;
		}
		int mid=0;
		int find;
		find=post[po--];
		Node root=new Node(find);
		
		for(i=l;i<=h;i++){
			if(find==io[i])
				mid=i;
		}
		root.right=solve( mid+1, h);
		root.left=solve( l, mid-1);
		
		return root;
	}
	public static void main(String[] args){
		
		TreeFromPostOrder tree = new TreeFromPostOrder();
		tree.io = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        tree.post = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        tree.po=tree.post.length-1;
		Node root=tree.solve(0, tree.io.length-1);
		
		new InOrderWithoutRecu().inOrder(root);
	}
}
