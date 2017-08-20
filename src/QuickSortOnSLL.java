
public class QuickSortOnSLL {
	class details{
		Node head,tail,pivot;
		public details(){}
	}
	public Node getTail(Node current){
		while(current.next!=null){
			current=current.next;
		}
		return current;
	}
	public Node quickSort(Node low, Node high){
		if(low==null||low==high)
			return low;
		
		details d=new details();
		Node pivot=partition1(low,high,d);
		
		if(d.head!=pivot){
			Node temp=d.head;
			while(temp.next!=pivot){
				temp=temp.next;
			}
			temp.next=null;
			d.head=quickSort(d.head,temp);
			temp=getTail(d.head);
			temp.next=pivot;
		}
		pivot.next=quickSort(pivot.next,d.tail);
		
		return d.head;
	}
	public Node partition1(Node low, Node high, details d){
		Node pivot=high;
		Node prev=null, curr=low, tail=pivot;
		
		while(curr!=pivot){
			if(curr.data<pivot.data){
				if(d.head==null){
					d.head=curr;
				}
				prev=curr;
				curr=curr.next;
			}
			else{
				if(prev!=null){
					prev.next=curr.next;
				Node temp=curr.next;
				curr.next=null;
				tail.next=curr;
				tail=curr;
				curr=temp;
				}
			}
		}
		if(d.head==null){
			d.head=pivot;
		}
		d.tail=tail;
		return pivot;
	}
	public details partition(Node low, Node high){
		
		Node pivot=high;
		Node head=low,tail=high;
		Node i=null,prev=null,previ=null,next,nexti;
		details det=new details();
		for(Node j=low;j!=high;j=j.next){
			if(j.data<pivot.data){
				if(i!=null){
					next=j.next;
					previ=i;
				    i=i.next;
				    nexti=i.next;
					prev.next=i;
					i.next=next;
					j.next=nexti;
					previ.next=j;
					//j=i;
				}else{
					if(prev!=null){
						i=low;
						prev.next=i;
					    next=j.next;
					    j.next=i.next;
					    i.next=next;
					    head=j;
					}else{
						i=low;
					}
				}
				j=i;
			}
			prev=j;
		}
		if(i!=null){
			previ=i;
			i=i.next;
			next=pivot.next;
			prev.next=i;
			pivot.next=i.next;
			i.next=next;
			previ.next=pivot;
			
			pivot=i;
		}else{
			i=low;
			prev.next=i;
			nexti=i.next;
			i.next=pivot.next;
			pivot.next=nexti;
			pivot=i;
		}
		tail=i;
		det.head=head;
		det.tail=tail;
		det.pivot=pivot;
		return det;
	}
	
	public static void main(String[] args){
		QuickSortOnSLL q=new QuickSortOnSLL();
		LinkedList ll=new LinkedList();
		ll.push(7);
		ll.push(9);
		ll.push(8);
		ll.push(6);
		ll.push(4);
		ll.push(1);
	//	ll.push(7);
		ll.printList();
		Node high=ll.head;
		Node low=ll.head;
		
		while(high.next!=null)
			high=high.next;
	    Node head=q.quickSort(low, high);
	    ll.printList(head);
		
	}
}
