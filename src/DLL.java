

public class DLL {

	Node head;
	public DLL(){
		head=null;
	}
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
	public void printList(Node head) 
    {
        System.out.println("Extracted Double Linked List is : ");
        while (head != null) 
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
	public void push(int data){
		if(head==null){
			head=new Node(data);
		}else{
			Node node=new Node(data);
			node.right=head;
			head.left=node;
			head=node;
		}
	}
	public void addNode(Node node){
		if(head==null){
			head=node;
		}else{
			node.right=head;
			head.left=node;
			head=node;
		}
			
	}
	public void printList(){
		Node node=head;
		while(node!=null){
            System.out.print(node.data + " ");
            node = node.right;
		}
	}
	public void delete(Node del){
		Node node=head,left, right;
		
		while(node!=null&&node!=del){
			node=node.right;
		}
		if(node!=null){
			if(node.left==null){
				head=node.right;
			}else{
				left=node.left;
				right=node.right;
				if(left!=null)
				left.right=right;
				if(right!=null)
				right.left=left;
				node=null;
			}
		}
	}
    public Node quickSort(Node node){
    	if(node==null)
    		return null;
    	Node partition=partition(node);
    	Node left,right;
    	System.out.println(partition.data);
    	
    	
    	left=partition.left;
    	right=partition.right;
    	partition.left=null;
    	partition.right=null;
    	
    	if(left!=null)
    	left.right=null;
    	if(right!=null)
    		right.left=null;
    	Node n=getHead(left);
    	left=quickSort(n);
    	
    	
    	right=quickSort(right);
    	if(left!=null)
        	left.right=partition;
        	partition.left=left;
        	
    	partition.right=right;
    	if(right!=null)
    	right.left=partition;
    	return node;
    }
    public Node getHead(Node node){
    	Node c=node;
    	if(node==null)
    		return node;
    	while(node.left!=null)
    		node=node.left;
    	return node;
    	
    }
    public Node partition(Node node){
    	Node pivot=getTail(node);
    	Node i=null;
    	Node j=node,left,right;
    	
    	while(j!=pivot){
    		if(j.data<pivot.data){
    			if(i==null){
    				i=node;
    			}else{
    				i=i.right;
    			
    			left=i.left;
    			right=i.right;
    			
    			i.left=j.left;
    			i.right=j.right;
    			j.right.left=i;
    			j.left.right=i;
    			if(left!=null)
    			left.right=j;
    			j.left=left;
    			if(right!=null)
    			right.left=j;
    			j.right=right;
    			}	
    		}
    		j=j.right;
    	}
    	if(i==null)
    		i=node;
    	else
    	i=i.right;
    	
    	left=i.left;
		right=i.right;
		
		i.left=pivot.left;
		i.right=pivot.right;
		if(pivot.right!=null)
		pivot.right.left=i;
		if(pivot.left!=null)
		pivot.left.right=i;
		if(left!=null)
		left.right=pivot;
		pivot.left=left;
		if(right!=null)
		right.left=pivot;
		pivot.right=right;
		return pivot;
    	
    }
    
    public Node getTail(Node node){
    	Node c=node;
    	while(node.right!=null)
    		node=node.right;
    	return node;
    	
    }
	public static void main(String[] args){
		
		DLL dll=new DLL();
		
//		Node node1=dll.new Node(2);
//		//dll.push(2);
//		dll.addNode(node1);
//		dll.push(4);
//		Node del=dll.new Node(8);
//		dll.push(8);
//		dll.addNode(del);
//		Node last=dll.new Node(10);
//		//dll.push(10);
//		dll.addNode(last);
//		dll.printList();
//		dll.delete(del);
//		System.out.println();
//		dll.printList();
//		dll.delete(node1);
//		System.out.println();
//		dll.printList();
//		
//		dll.delete(last);
//		System.out.println();
		dll.push(2);
		dll.push(4);
		dll.push(8);
		dll.push(10);
		dll.printList();
		System.out.println();
		dll.quickSort(dll.head);
		dll.printList();
	}
	
}
