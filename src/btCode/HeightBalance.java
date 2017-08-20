package btCode;

public class HeightBalance {

	Node root;
	
	class HNode{
		int h;
		boolean check;
		public HNode(int h, boolean check){
			this.h=h;
			this.check=check;
		}
	} 
	
	public HNode solve(Node node){
		HNode hnode;
		int lh, rh, h;
		boolean check;
		if(node==null){
			hnode=new HNode(0, false);
		    return hnode;
		}
		if(node.left==null&&node.right==null){
			hnode=new HNode(1, true);
			return hnode;
		}
		HNode left=solve(node.left);
		HNode right=solve(node.right);
		
		if(left.h>right.h)
			h=left.h+1;
		else
			h=right.h+1;
		
		if(!left.check||!right.check){
			hnode=new HNode(h,false);
			return hnode;
		}
		    
		hnode=new HNode(h,true);
			return hnode;
	}
	public static void main(String[] args){
		HeightBalance tree=new HeightBalance();
		
		tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        //tree.root.left.left.left = new Node(8);
		
        if(tree.solve(tree.root).check)
			System.out.println("Yes");
		else
			System.out.println("No");
			
		
	}
}
