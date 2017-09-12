
public class LinkedList {

	Node head;
	Node current;
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
	public void push(int data){
		Node newnode=new Node(data);
		newnode.next=head;
		head=newnode;
		
	}
	public void insert(int data){
		if(head == null){
			head = new Node(data);
			current = head;
		}else{
			current.next = new Node(data);
			current = current.next;
		}
	}
	public void printList(Node head){
		Node node=head;
		while(true){
			System.out.print(node.data+"->");
			node=node.next;
			if(node==null)
				break;
		}
		System.out.println();
	}
	public void printList(){
		Node node=head;
		while(true){
			System.out.print(node.data+"->");
			node=node.next;
			if(node==null)
				break;
		}
		System.out.println();
	}
}
class Node{
	Node next;
	int data;
	
	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node(int data){
		this.data=data;
		next=null;
	}

}
class DiffNode{
	DiffNode next,down;
	int data;
	public DiffNode(int data){
		this.data=data;
	}
}
