
public class ArbitraryPoint {
class Node{
	Node arbit, next;
	int data;
	public Node(int data){
		this.data=data;
	}
}
class LinkedList {

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
	public void push(int data){
		Node newnode=new Node(data);
		newnode.next=head;
		head=newnode;
		
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
	public void printArbit(Node head){
		Node node=head;
		while(true){
			if(node.arbit!=null)
			System.out.print(node.arbit.data+"->");
			else{
				System.out.print("n");
			}
			node=node.next;
			if(node==null)
				break;
		}
		System.out.println();
	}
}
public Node arbitPointImpl(Node head){
	
	if(head==null||head.next==null)
		return head;
	head.arbit=arbitPoint(head.next);
	return head;
}
public Node arbitPoint(Node head){
	if(head==null||head.next==null){
		return head;
	}
	Node node=arbitPoint(head.next);
	head.arbit=node;
	if(head.data>node.data)
		return head;
	else
		return node;
}

public static void main(String[] args){
	ArbitraryPoint ap=new ArbitraryPoint();
	LinkedList l=ap.new LinkedList();
	
	l.push(3);
	l.push(2);
	l.push(10);
	l.push(5);
	
	l.printList(ap.arbitPointImpl(l.head));
	l.printArbit(ap.arbitPointImpl(l.head));
}
}
