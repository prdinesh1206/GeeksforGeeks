
public class GetNthNode {

	LinkedList llist;
	public GetNthNode(){
		 llist = new LinkedList();
	        llist.push(5);
	        llist.push(4);
	        llist.push(3);
	        llist.push(2);
	        llist.push(1);
	        // 1->2->1->3->1
	}
	public int getNthNode(int index){
		Node node=llist.head;
		while(index>1){
			node=node.next;
			index--;
		}
		return node.getData();
	}
	public static void main(String[] args){
		 GetNthNode g = new GetNthNode();
		 g.llist.printList();
		 
		System.out.println(g.getNthNode(3));
	}
}
