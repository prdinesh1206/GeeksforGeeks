
public class RemoveMiddleLL {
 class Node{
	 int f,s;
	 Node next;
	 public Node(int f, int s){
		 this.f=f;
		 this.s=s;
	 }
 }
 class LinkedList{

		Node head;
		public LinkedList(){
			this.head=null;
		}
		public LinkedList(Node node){
	     		this.head=node;
		}
		public void add(Node node){
			node.next=head;
			head=node;
			
		}
		public void push(int f, int s){
			Node newnode=new Node(f,s);
			newnode.next=head;
			head=newnode;
			
		}
		public void printList(Node head){
			Node node=head;
			while(true){
				System.out.print("("+node.f+","+node.s+")->");
				node=node.next;
				if(node==null)
					break;
			}
			System.out.println();
		}
		public void printList(){
			Node node=head;
			while(true){
				System.out.print("("+node.f+","+node.s+")->");
				node=node.next;
				if(node==null)
					break;
			}
			System.out.println();
		}
 }
 public Node removeMiddle(Node node,LinkedList llist){
	 
	 int f,s;
	 Node current,next2next;
	 current=node;
	 f=node.f;s=node.s;
	 int countf=0,counts=0;
	 Node prev;
	 

	while(current!=null){	
     while(current!=null&&current.next!=null&&current.next.next!=null&&current.next.s==current.s&&current.next.next.s==current.s){
			 next2next=current.next.next;
			
			 current.next=next2next;
			 
			 countf++;
			 System.out.println("First while");
			llist.printList();
		 }
     current=current.next;
     while(current!=null&&current.next!=null&&current.next.next!=null&&current.next.f==current.f&&current.next.next.f==current.f){
		 next2next=current.next.next;
		 
		 current.next=next2next;
		 
		 countf++;
		 System.out.println("Second while");
		 llist.printList();
	 }
     current=current.next;
	}
	 return node;
 }
 public static void main(String[] args){
	 RemoveMiddleLL rm=new RemoveMiddleLL();
	
	 LinkedList llist= rm.new LinkedList();
	 
//	    //llist.push(40,5);
//        llist.push(40,5);
//        llist.push(20,5);
        llist.push(12,3);
        llist.push(10,3);
        llist.push(6,3);
        llist.push(4,3);
        llist.push(2,3);
        
     llist.printList();
     rm.removeMiddle(llist.head,llist);
     System.out.println("Final");
     llist.printList();
 }
}
