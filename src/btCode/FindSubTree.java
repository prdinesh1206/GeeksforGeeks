package btCode;

public class FindSubTree {
	public void preOrder(Node root, StringBuffer s){
		if(root == null){
			s.append("$");
			return;
		}
		s.append(root.data);
		preOrder(root.left, s);
		preOrder(root.right, s);
	}
	public void inOrder(Node root, StringBuffer s){
		if(root == null){
			s.append("$");
			return;
		}
		inOrder(root.left, s);
		s.append(root.data);
		inOrder(root.right, s);
	}
	
	public boolean isSubString(String hay, String needle){
		if(hay.equals("") || needle.equals("")){
			return false;
		}
		System.out.println(hay+" "+needle);
		int l1 = hay.length();
		int l2 = needle.length();
		
		for(int i=0;i<=l1-l2;i++){
			if(hay.substring(i, i+l2).equals(needle)){
				return true;
			}
		}
		return false;
	}
	public static void main(String[] args){
		BinaryTree bt = new BinaryTree();
		Node T = new Node('a');
		T.left = new Node('b');
		T.right = new Node('d');
		T.left.left = new Node('c');
		T.right.right = new Node('e');
		 
        Node S = new Node('a');
		S.left = new Node('b');
		S.right = new Node('d');
		S.left.left = new Node('c');
		StringBuffer preOrderT = new StringBuffer("");
		StringBuffer preOrderS = new StringBuffer("");
		StringBuffer inOrderT = new StringBuffer("");
		StringBuffer inOrderS = new StringBuffer("");
		
		FindSubTree f =new FindSubTree();
		f.preOrder(T, preOrderT);
		f.preOrder(S, preOrderS);
		
		f.inOrder(T, inOrderT);
		f.inOrder(S, inOrderS);
		
		boolean check = f.isSubString(preOrderT.toString(), preOrderS.toString()) && f.isSubString(inOrderT.toString(), inOrderS.toString());
		System.out.println(check);
	}
}
