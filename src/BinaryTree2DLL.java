
public class BinaryTree2DLL {
	class Node 
	{
	    int data;
	    Node left, right;
	 
	    public Node(int data) 
	    {
	        this.data = data;
	        left = right = null;
	    }
	}
	class BinaryTree{
		Node root;
		
	}
	public void printList(Node head) 
	    {
	        System.out.println("Extracted Double Linked List is : ");
	        
	        while (head != null) 
	        {
	            System.out.print(head.data + " ");
	            head = head.right;
	        }
	    }
	public void printCLList(Node head) 
    {
        System.out.println("Extracted Double Linked List is : ");
        Node node=head;
        do 
        {
            System.out.print(node.data + " ");
            node = node.right;
        }while (node != head);
    }
	public Node convert2DLL(Node tree, boolean isleft){
		if(tree==null)
			return null;
		Node left;
		if(!isleft)
		 left=convert2DLL(tree.left,!isleft);
		else
			 left=convert2DLL(tree.left,isleft);	
		if(left!=null){
			left.right=tree;
			tree.left=left;
		}
		Node right;
		if(isleft)
		   right=convert2DLL(tree.right,!isleft);
		else
			right=convert2DLL(tree.right,isleft);
		if(right!=null){
			tree.right=right;
			right.left=tree;
		}
		if(head==null){
			if(left!=null)
				head=left;
			else
				head=tree;
		}
		if(isleft){
			if(right!=null){
				return right;
			}else{
				return tree;
			}
		}else{
			if(left!=null){
				return left;
			}else{
				return tree;
			}
		}
		
	}
	static Node head =null;
	public void convert2CDLL(Node node){
		if(node==null)
			return;
		convert2CDLL(node.right);
		if(head==null){
			head=node;
			
		}else{
			node.right=head;
			//node.left=head;
			//head.right=node;
			head.left=node;
			head=node;
		}
		convert2CDLL(node.left);
	}
	
	public static void main(String[] args){
		BinaryTree2DLL bdl=new BinaryTree2DLL();
		BinaryTree tree = bdl.new BinaryTree();
		
        tree.root = bdl.new Node(5);
        tree.root.left = bdl.new Node(3);
        tree.root.right = bdl.new Node(6);
        tree.root.left.right = bdl.new Node(4);
        tree.root.left.left = bdl.new Node(1);
        tree.root.right.right = bdl.new Node(8);
      //  tree.root.left.left.right = bdl.new Node(2);
       // tree.root.left.left.left = bdl.new Node(0);
        //tree.root.right.right.left = bdl.new Node(7);
        tree.root.right.right.right = bdl.new Node(9);
        bdl.convert2CDLL(tree.root);
       bdl.printList(head);
	}
	 
}
