import java.util.Scanner;
//https://www.interviewbit.com/problems/subtract/
public class SubtractLinkedList {
	public ListNode subtract(ListNode a) {
	    ListNode fast=a, slow=a, prev = null;
	    boolean odd = false;
	    if(a.next==null){
	    	return a;
	    }
	    while(fast!=null && fast.next!=null){
	        prev = slow;
	        slow = slow.next;
	        fast = fast.next.next;
	    }
	    if(fast==null){
	        odd = false;
	    }else if(fast.next==null){
	        odd=true;
	    }
//	    printList(a);
	    ListNode reversed;
	    if(odd){
            reversed = reverse(slow.next);
	    }else{
	        reversed = reverse(slow);
	    }
//	    System.out.println("Reverse: ");
	    printList(reversed);
//	    System.out.println("Done");
	    ListNode temp=null;
	    if(odd){
	        temp = prev.next;
	    }
	    prev.next = null;
	    ListNode current = a, otherhalf = reversed;
	    while(current!=null){
	        current.val = otherhalf.val - current.val;
	        current=current.next;
	        otherhalf=otherhalf.next;
	    }
	    if(odd){
	        prev.next =temp;
	        prev = prev.next;
	    }
	    prev.next = reverse(reversed);
	    printList(a);
	    return a;
	}
	public ListNode reverse(ListNode head){
	    ListNode prev = null;
	    ListNode current = head, next;
	    while(current!=null){
	        next = current.next;
	        current.next = prev;
	        prev = current;
	        current = next;
	    }
	    return prev;
	}
	public void printList(ListNode node){
	    while(node!=null){
	        System.out.print(node.val+" ");
	        node = node.next;
	    }
	    System.out.println();
	}
	
	public static void main(String[] args){
		SubtractLinkedList sub = new SubtractLinkedList();
		Scanner scanner = new Scanner(System.in);
		String line = scanner.nextLine();
		String[] numbers = line.split(" ");
		System.out.println(numbers.length);
		ListNode head = null, current = null;
		for(int i=0;i<numbers.length-1;i++){
			if(head==null){
				head = new ListNode(Integer.parseInt(numbers[i+1]));
				current = head;
			}else{
				current.next = new ListNode(Integer.parseInt(numbers[i+1]));
				current = current.next;
			}
		}
		sub.printList(head);
		sub.subtract(head);
	}
	
}
class ListNode {
	  public int val;
    public ListNode next;
    ListNode(int x) { val = x; next = null; }
}