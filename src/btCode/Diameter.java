package btCode;

public class Diameter {

	Node root;
	class DiaNode{
		int h, d;
		public DiaNode(int h, int d){
			this.h=h;
			this.d=d;
		}
	}
	
	public DiaNode solve(Node node){
		DiaNode dn;
		int ld, rd, lh, rh, d, h;
		if(node==null){
			dn=new DiaNode(0,0);
			return dn;
		}
		
		if(node.left==null&&node.right==null){
			dn=new DiaNode(1,1);
			return dn;
		}
		
		DiaNode left=solve(node.left);
		DiaNode right=solve(node.right);
		
		lh=left.h;
		ld=left.d;
		
		rh=right.h;
		rd=right.d;
		
		d=lh+rh+1;
		
		if(lh>rh)
			h=lh+1;
		else
			h=rh+1;
		
		if(d>ld&&d>rd){
			dn=new DiaNode(h,d);
			
		}else {
		    
			if(ld>rd)
				dn=new DiaNode(h,ld);
			else
				dn=new DiaNode(h,rd);
			
		}
		return dn;
		}
	
		public static void main(String[] args){
			Diameter tree=new Diameter();
			tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.right.right=new Node(6);
			DiaNode result=tree.solve(tree.root);
			
			System.out.println("Diameter of the tree: "+result.d);
		}	
	}

