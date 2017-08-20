
public class DLinkedList {
	 Node head;  
	 public Node flattening(Node head){
			Node current, down;	
			current=head;
			Node next;
			
			while(current!=null){
				next=current.right;
				while(current.down!=null){
					current.right=current.down;
					current=current.right;
				}
				current.right=next;
				current=current.right;
			}
			printList(head);
			return head;
		}
	 
	 public Node multilevelFlatten(Node head){
		 Node head1,current,node,end;
		 end=head;
		 
		 while(end.right!=null)
			 end=end.right;
		 
		 current=head;
		 while(current!=null){
			 if(current.down!=null){
				 node=current.down;
				 end.right=node;
				 end=end.right;
				 current.down=null;
			 }
			 current=current.right;
		 }
		 
		 return head;
	 }
	 
	 public Node flatten(Node head){
		 if(head==null||head.right==null)
			 return head;
		 head.right=flatten(head.right);
		 head=merge(head,head.right);
		 return head;
	 }
	 public Node merge(Node h1,Node h2){
		Node result;
		if(h1==null)
			return h2;
		if(h2==null)
			return h1;
		
		if(h1.data<h2.data){
			result=h1;
			result.down=merge(h1.down,h2);
		}else{
			result=h2;
			result.down=merge(h1,h2.down);
		}
		return result;
	}
	 public void printList(Node head){
		 Node current=head;
		 while(current!=null){
			 System.out.print(current.data+" ");
			 current=current.down;
		 }
	 }
	 public void printMultiList(Node head){
		 Node current=head;
		 while(current!=null){
			 System.out.print(current.data+" ");
			 current=current.right;
		 }
	 }
	 
	class Node
	    {
	        int data;
	        Node right, down;
	        Node(int data)
	        {
	            this.data = data;
	            right = null;
	            down = null;
	        }
	    }
	 Node push(Node head_ref, int data)
	    {
	        /* 1 & 2: Allocate the Node &
	                  Put in the data*/
	        Node new_node = new Node(data);
	 
	        /* 3. Make next of new Node as head */
	        new_node.down = head_ref;
	 
	        /* 4. Move the head to point to new Node */
	        head_ref = new_node;
	 
	        /*5. return to link it back */
	        return head_ref;
	    }
	public static void main(String[] args){
		 DLinkedList L = new DLinkedList();
		 
	        /* Let us create the following linked list
	            5 -> 10 -> 19 -> 28
	            |    |     |     |
	            V    V     V     V
	            7    20    22    35
	            |          |     |
	            V          V     V
	            8          50    40
	            |                |
	            V                V
	            30               45
	        */
	 
	        L.head = L.push(L.head, 30);
	        L.head = L.push(L.head, 8);
	        L.head = L.push(L.head, 7);
	        L.head = L.push(L.head, 5);
	 
	        L.head.right = L.push(L.head.right, 20);
	        L.head.right = L.push(L.head.right, 10);
	 
	        L.head.right.right = L.push(L.head.right.right, 50);
	        L.head.right.right = L.push(L.head.right.right, 22);
	        L.head.right.right = L.push(L.head.right.right, 19);
	 
	        L.head.right.right.right = L.push(L.head.right.right.right, 45);
	        L.head.right.right.right = L.push(L.head.right.right.right, 40);
	        L.head.right.right.right = L.push(L.head.right.right.right, 35);
	        L.head.right.right.right = L.push(L.head.right.right.right, 28);
	        //L.printList(L.flatten(L.head));
	        L.printMultiList(L.multilevelFlatten(L.head));
	}
	 
}
