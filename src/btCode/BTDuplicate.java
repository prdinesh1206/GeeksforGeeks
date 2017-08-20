package btCode;

import java.util.HashMap;
import java.util.HashSet;

public class BTDuplicate {

	Node root;
	HashSet<String> hash;
	public BTDuplicate(){
		hash=new HashSet<String>();
	}
	public boolean hasLeafNodes(Node node){
		
		
		Node left=node.left, right=node.right;
		
		if(left!=null&&right!=null){
			if(left.left==null&&left.right==null)
				if(right.left==null&&right.right==null)
					return true;
		}
		return false;
	}
	
	public void solve(Node node){
		if(node==null)
			return;
		if(hasLeafNodes(node)){
			findDuplicate(root, node);
		}else{
		solve(node.left);
		solve(node.right);
		}
	}
	public int findDuplicate(Node root, Node node){
		
		if(root==null)
			return 0;
		if(hasLeafNodes(root)){
			if(root.data==node.data){
				if(root.left.data==node.left.data){
					if(root.right.data==node.right.data)
						return 1;
				}
			}
			return 0;
		}
		int left=findDuplicate(root.left, node);
		int right=findDuplicate(root.right,node);
		
		if(left+right>=2){
			stop(left+right);
		}
			return left+right;
		
	}
	public void stop(int sum){
		System.out.println(sum+" Yes");
		System.exit(0);
		
	}
	public String duplicate(Node node){
		String s="";
		if(node==null)
			return s+"$";
		
		String left=duplicate(node.left);
		if(left.equals(""))
			return "";
		
		String right=duplicate(node.right);
		if(right.equals(""))
			return "";
		
		s=s+node.data+left+right;
		
		if(s.length()>3&&hash.contains(s)){
			return "";
		}
		hash.add(s);
		return s;
		
	}
	public static void main(String[] args){
		//BinaryTree bt=new BinaryTree();
		BTDuplicate bt=new BTDuplicate();
		bt.root=new Node('A');
		bt.root.left=new Node('B');
		bt.root.right=new Node('C');
		bt.root.left.left=new Node('D');
		bt.root.left.right=new Node('E');
		bt.root.right.right=new Node('B');
		bt.root.right.right.right=new Node('E');
		bt.root.right.right.left=new Node('D');
		
		//bt.solve(bt.root);
		System.out.println("No");
		
		String result=bt.duplicate(bt.root);
		if(result.equals(""))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
