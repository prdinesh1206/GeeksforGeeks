import java.util.Scanner;

//http://practice.geeksforgeeks.org/problems/reverse-a-linked-list-in-groups-of-given-size/1
public class ReverseLinkedListInGroups {

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] numbers = scan.nextLine().split(" ");
		LinkedList ll = new LinkedList();
		for(int i=0;i<n;i++){
			ll.insert(Integer.parseInt(numbers[i]));
		}
		int k = Integer.parseInt(scan.nextLine());
		ll.printList(ll.head);
		Node head = solve(ll, k);
		ll.printList(head);
	}
	public static Node solve(LinkedList ll, int k){
		if(ll.head == null){
			return null;
		}
		Node tail = null, next = ll.head, prev, current = ll.head, newhead = null, oldtail = null;
		while(current!=null){
			prev = null;
			oldtail = tail;
			tail = current;
			for(int i=0; i<k && current != null ;i++){
				next = current.next;
				current.next = prev;
				prev = current;
				current = next;
			}
			if(newhead == null){
				newhead = prev;
			}
			if(oldtail != null){
				oldtail.next = prev;
			}
			tail.next = current;
			
		}
		return newhead;
	}
}
