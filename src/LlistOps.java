
public class LlistOps {

	LinkedList llist;
	public LlistOps(){
		 llist = new LinkedList();
		// llist.push(9);
		 //llist.push(8);
		    llist.push(7);
		    llist.push(6);
		    llist.push(5);
	        llist.push(4);
	        llist.push(3);
	        llist.push(2);
	        llist.push(1);
	        // 1->2->3->5->6->7->
	        llist.printList();
	        Node head=yahoo(llist.head,3);
	        llist.printList(head);
	}
	public Node yahoo(Node n, int k){
		
		Node current=n, next,head,prev = null;
		if(n==null)
			return null;
		
		for(int i=0;i<k;i++){
			prev=current;
			current=current.next;
			if(current==null)
				break;
		}
		//next=current;
		next=yahoo(current,k);
		//next.next=null;
		prev.next=null;
		head=reverseList(n);
		n.next=next;
		return head;
		
	}
	
	public boolean searchNode(int searchData, Node head){
		
		if(head==null){
			return false;
		}
		else {
		    if(searchData==head.getData()){
		    	return true;
		    }
		    else{
		    	return searchNode(searchData,head.next);
		    }
		}
	}
	public void swapNodes(int searchData1, int searchData2){
		Node head=llist.head;
		Node searchNode1=null,  searchNode2=null,prev1=null,prev2=null,prev=null;
	
		while(true){
			if(head==null){
				break;
			}else{
				
				if(searchData1==head.getData()){
					prev1=prev;
					searchNode1=head;
				}else if(searchData2==head.getData()){
					prev2=prev;
					searchNode2=head;
				}
				if(searchNode1!=null&&searchNode2!=null){
					
					if(prev1!=null)
					prev1.next=searchNode2;
					if(prev2!=null)
					prev2.next=searchNode1;
					
					Node temp=searchNode1.next;
					searchNode1.next=searchNode2.next;
					searchNode2.next=temp;
					break;
				}
				prev=head;
				head=head.next;
				
				
			}
		}
		if(llist.head==searchNode1&&searchNode2!=null)
			llist.head=searchNode2;
		else if(llist.head==searchNode2&&searchNode1!=null)
			llist.head=searchNode1;
	}
	
	public Node findMiddle(Node head){
	
		Node head1=head,head2=head;
		while(true){
			if(head2.next==null){
				return head1;
			}else if(head2.next.next==null){
				//return head1;
				return head1.next;
			}else{
				head1=head1.next;
				head2=head2.next.next;
			}
		}
	}
	public Node nthNodefromEnd(int n,Node head){
		Node head1=head,head2=head;
		
		while(--n>0){
			head2=head2.next;
		}
		while(head2.next!=null&&head1.next!=null){
			head1=head1.next;
			head2=head2.next;
		}
		return head1;
	}
	public Node reverseList(Node head){
		Node prev=null,next = null,head1 = null;
		
		while(head!=null){
		next=head.next;
		head.next=prev;
		prev=head;
		head=next;
		
		}
		return prev;
	}
	public Node reverseListRecur(Node head,Node prev,Node head1){
		if(head.next==null){
			head1=head;
			head.next=prev;
			return head1;
		}
		Node next=head.next;
		head.next=prev;
		prev=head;
		head1=reverseListRecur(next,prev,head1);
		return head1;
		
	}
	public Node reverseListRecursive(Node current,Node prev){
		if(current==null)
			return prev;
		Node next=current.next;
		current.next=prev;
		prev=current;
		return reverseListRecursive(next,prev);
	}
	public Node mergeLists(Node head1, Node head2){
		Node head=null,current=null;
		
		while(head1!=null&&head2!=null){
			if(head1.data<head2.data){
				if(head==null){
				head=head1;
				current=head1;
				}else{
					current.next=head1;
					current=current.next;
				}
				head1=head1.next;
			}
			else{
				//head=head2;
				if(head==null){
					head=head2;
					current=head2;
					}else{
						current.next=head2;
						current=current.next;
					}
				head2=head2.next;
			    }
		}
		while(head1!=null){
			current.next=head1;
			current=current.next;
			head1=head1.next;		
		}
		while(head2!=null){
			current.next=head2;
			current=current.next;
			head2=head2.next;		
		}
		return head;
	}
	public Node insertInSorted(Node head,int data){
		Node current=head,prev=null;
		Node newNode=new Node(data);
		if(current==null)
			head=newNode;
		else{
			while(current.data<newNode.data){
				prev=current;
				current=current.next;
			}
			prev.next=newNode;
			newNode.next=current;
		}
		return head;
	}
	public void deleteNode(Node node){
		Node temp=node.next;
		node.data=temp.data;
		node.next=temp.next;
		temp=null;
		 
	}
	public boolean findPalindrome(Node head){
		Node current1=head,current2=head,prev = null,middle = null,secondhead = null;
		
		while(current2.next!=null&&current2.next.next!=null){
			prev=current1;
			current1=current1.next;
			current2=current2.next.next;
		}
		if(current2.next==null){
			middle=current1;
			prev.next=null;
			secondhead=current1.next;
		}else{
			secondhead=current1.next;
			current1.next=null;
		}
		secondhead=reverseList(secondhead);
		
		boolean isPal=compareToList(head,secondhead);
		secondhead=reverseList(secondhead);
		if(middle!=null){
			prev.next=middle;
		    middle.next=secondhead;
		}else
			prev.next=secondhead;
		return isPal;
		
	}
	public boolean compareToList(Node n1,Node n2){
		boolean isPal=false;
		while(n1!=null&&n2!=null){
			
			if(n1.data!=n2.data){
				return false;
			}
			n1=n1.next;
			n2=n2.next;
		}
		if(n1!=null||n2!=null)
			return false;
		else
			return true;
	}
	public boolean floydAlgo(Node head){
		Node slow=head,fast=head;
		
		while(slow!=null&&fast!=null){
			slow=slow.next;
			fast=fast.next.next;
			if(slow==fast){
				System.out.println(floydAlgoloopstart(head,fast).data);
				return true;
			}
		}
		return false;
	}
	public Node floydAlgoloopstart(Node head,Node fast){
		while(head!=fast){
			head=head.next;
			fast=fast.next;
		}
		return head;
	}
	public Node intersectionOfLists(Node node1,Node node2){
		Node current1=node1,current2=node2;
		int length1=0,length2=0,length=0;
		
		while(current1!=null){
			current1=current1.next;
			length1++;
		}
		while(current2!=null){
			current2=current2.next;
			length2++;
		}
		
		current1=node1;
		current2=node2;
		
		if(length1>length2){
			for(int i=0;i<length2;i++){
				current1=current1.next;
			}
			return current1;
		}
		else{
			for(int i=0;i<length1;i++){
				current2=current2.next;
			}
			return current2;
		}
     }
	public void printReverseList(Node head){
		if(head==null)
			return ;
		printReverseList(head.next);
		System.out.println(head.data);
	}
	public Node pairwiseSwap(Node head){
		Node current=head,prev=null;
		Node first,second,next;
		
		while(current.next!=null){
		 	first=current;
		 	second=current.next;
		 	next=second.next;
		 	first.next=next;
		 	if(prev!=null){
		 		prev.next=second;
		 		
		 	}else{
		 		head=second;
		 	}
		 	second.next=first;
		 	
		 	prev=current;
		 	current=next;
		}
		return head;
	}
	public Node pairwiseRecurSwap(Node current){
		if(current==null||current.next==null)
			return current;
		Node tail=pairwiseRecurSwap(current.next.next);
		Node first=current;
		Node second=current.next;
		Node next=second.next;
		second.next=first;
		first.next=tail;
		
		return second;
	}
	public Node intersectTwoSortedListsRecur(Node a,Node b,Node result){
		if(a==null||b==null){
			return null;
		}
		if(a.data==b.data){
			Node newNode=new Node(a.data);
			newNode.next=intersectTwoSortedListsRecur(a.next,b.next,result);
			return newNode;
		}else if(a.data<b.data){
			return intersectTwoSortedListsRecur(a,b.next,result);
		}
		else{
			return intersectTwoSortedListsRecur(a.next,b,result);
		}
	}
	public Node deleteAlternateNodesRecur(Node node){
		if(node==null){
			return null;
		}
		if(node.next==null){
			return node;
		}
		node.next=deleteAlternateNodesRecur(node.next.next);
		return node;
	}
	public Node mergeSort(Node a){
		if(a.next==null)
			return a;
		Node middle=findMergeMiddle(a);
		Node next=middle.next;
		middle.next=null;
		Node node1=mergeSort(a);
		Node node2=mergeSort(next);
		return merge(node1,node2);
		
	}
	public Node merge(Node a,Node b){
		Node head=null,current = null,node;
		while(a!=null&&b!=null){
			if(a.data>b.data){
				node=new Node(b.data);
				b=b.next;
			}else{
				node=new Node(a.data);
				a=a.next;
			}
			if(head==null){
				head=node;
				current=head;
			}else{
				current.next=node;
				current=current.next;
			}
		}
		while(b!=null){
			node=new Node(b.data);
			if(head==null){
				head=node;
				current=head;
			}else{
				current.next=node;
				current=current.next;
			}
			b=b.next;
		}
		while(a!=null){
			node=new Node(a.data);
			if(head==null){
				head=node;
				current=head;
			}else{
				current.next=node;
				current=current.next;
			}
			a=a.next;
		}
		return head;
	}
	public Node findMergeMiddle(Node node){
		if(node==null)
			return null;
		Node slowptr=node,fastptr=node;
		while(true){
			if(fastptr==null||fastptr.next==null||fastptr.next.next==null)
				break;
			slowptr=slowptr.next;
			fastptr=fastptr.next.next;
		}
		return slowptr;
	}
	public Node reverseInGroups(Node node,int k){
		if(node==null)
			return node;
		Node current=node,next,head;
		int i;
		for(i=1;i<k;i++){
			if(current.next==null)
				break;
			current=current.next;
		}
		if(i!=k){
			return reverseListRecursive(node,null);
		}else{
			
			next=reverseInGroups(current.next,k);
			current.next=null;
			head=reverseListRecursive(node,null);
			node.next=next;
			return head;
		}
	}
	public Node reverseInGroupsSimple(Node node,int k){
		int count=0;
		Node current=node,prev=null,next=null;
		for(int i=0;i<k;i++){
			if(current==null)
				break;
		     next=current.next;
		     current.next=prev;
		     prev=current;
		     current=next;
		}
		if(next!=null)
			node.next=reverseInGroupsSimple(next,k);
		return prev;
	}
	public Node reverseAlternateKNodes(Node node,int k,boolean doit){
		if(node==null)
			return node;
		Node current=node,next,head;
		
		int i=0;
		for(i=1;i<k;i++){
			if(current.next==null)
			   break;
			current=current.next;
		}
		if(i==k){
			next=reverseAlternateKNodes(current.next,k,!doit);
			
			if(doit){
				current.next=null;
				head=reverseListRecursive(node,null);
				node.next=next;
			}
			else{
				head=node;
				current.next=next;
			}
			return head;
		}else{
			if(doit)
			return reverseListRecursive(node,null);
			else
				return node;
		}
		
	}
	public void deleteNodesWithGreaterValue(Node head){
		Node prev,current,next;
		current=head;
		prev=null;
		
		while(true){
			if(current==null)
				break;
			next=current.next;
			current.next=prev;
			prev=current;
			current=next;
		}
		head=prev;
		new LinkedList().printList(prev);
		int max=0;
		current=head;
		prev=null;
		while(current!=null){
			if(max<current.data){
				max=current.data;
				prev=current;
				current=current.next;
			}else{
				
				prev.next=current.next;
				current=current.next;
				
			}
		}
		new LinkedList().printList(head);
	}
	public Node segregateOddAndEven(Node head){
		if(head==null)
			return head;
		Node even = null,odd = null,current_e = null,current_o = null,current,newNode;
		current=head;
		while(current!=null){
			newNode=new Node(current.data);
			if(current.data%2==0){
				
				if(even==null){
					even=newNode;
					
				}else{
					current_e.next=newNode;
					
				}
				current_e=newNode;
			}else{
				if(odd==null){
					odd=newNode;
				}else{
					current_o.next=newNode;
				}
				current_o=newNode;
			}
			current=current.next;
		}
		current_e.next=odd;
		return even;
	}
	public Node segregateGoodMethod(Node head){
		Node end=head,end_r;
		while(end.next!=null)
			end=end.next;
		end_r=end;
		Node current=head,prev=null,next;
		while(current!=null&&current!=end_r){
			 next = current.next;
			if(current.data%2!=0){
				if(prev!=null){
					prev.next=next;
				}
				end.next=current;
				if(prev==null)
				head=next;
				current.next=null;
				end=end.next;
			}else{
				prev=current;
			}
			current=next;
		}
		return head;
	}
	
	public Node addTwoNumbers(Node head1,Node head2){
		Node c1=head1,c2=head2,prevc1 = null;
		int carry=0,value;
		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		while(c1!=null&&c2!=null){
			value=0;
			if(carry!=0){
				value+=carry;
			}
			value+=(c1.data+c2.data);
			if(value/10>=1){
				carry=value/10;
			}else
				carry=0;
			c1.data=value%10;
			prevc1=c1;
			c1=c1.next;
			c2=c2.next;
		}
		value=0;
		while(c1!=null){
			if(carry!=0){
				value=c1.data+carry;
				if(value/10>=1){
					carry=value/10;
				}else
					carry=0;
				c1.data=value%10;
				
			}
			c1=c1.next;
		}
		while(c2!=null){
			if(carry!=0){
				value=c2.data+carry;
				if(value/10>1){
					carry=value/10;
				}else
					carry=0;
				c2.data=value%10;
				
			}
			prevc1.next=c2;
			prevc1=prevc1.next;
			c2=c2.next;
		}
		return head1;
	}
	public LinkedList addTwoListsImpl(Node h1, Node h2){
		LinkedList llist3=new LinkedList();
		  
		   
		   Node c1=h1,c2=h2,c3;
		   int size1=0,size2=0,carry;
		 
		  while(c1!=null){
			  c1=c1.next;
			  size1++;
		  }
		  while(c2!=null){
			  c2=c2.next;
			  size2++;
		  }
		  if(size1>size2){
			  c3=h1;
			  for(int i=0;i<size1-size2;i++){
				  c3=c3.next;
			  }
			   carry=addTwoLists(c3,h2,llist3);
			  carry= addCarryToRemList(c3,h1,carry,llist3);
		  }else if(size1<size2){
			  c3=h2;
			  for(int i=0;i<size1-size2;i++){
				  c3=c3.next;
			  }
			   carry=addTwoLists(c3,h1,llist3);
			  carry= addCarryToRemList(c3,h2,carry,llist3);
		  }else{
			   carry=addTwoLists(h1,h2,llist3);
		  }
		    
		 
		   if(carry!=0){
			   llist3.push(carry);
		   }
		   llist3.printList();
		   return llist3;
		   
	}
	public int addCarryToRemList(Node head,Node current,int carry,LinkedList llist3){
		if(current.next==head){
			int value=current.data+carry;
			llist3.push(value%10);
			return value/10;
		}
		int c=addCarryToRemList(head,current.next,carry,llist3);
		int value=c+current.data;
		llist3.push(value%10);
		return value/10;
	}
	public int addTwoLists(Node h1, Node h2, LinkedList list){
		if(h1==null&&h2==null){
			return 0;
		}
		if(h1==null){
			list.add(h2);
			return 0;
		}
		if(h2==null){
			list.add(h1);
			return 0;
		}
		int carry=addTwoLists(h1.next,h2.next,list);
		int answer=h1.data+h2.data+carry;
		list.push(answer%10);
		return answer/10;
		
	}
	public void mergeAlternate(Node h1, Node h2){
		if(h1==null||h2==null)
			return;
		mergeAlternate(h1.next,h2.next);
		
		Node next=h1.next;
		h1.next=h2;
		h2.next=next;
	}
	public void addFromLast(Node node, LinkedList ll, Node check){
		if(node==check)
			return ;
		addFromLast(node.next, ll,check);
		ll.push(node.data);
	}
    public void maxSumLL(Node head1, Node head2, LinkedList ll){
    	Node c1=head1,c2=head2,result=null;
    	int sum1=0,sum2=0;
    	boolean mid=false;
    	
    	if(head1==null){
    		addFromLast(head2,ll,null);
    		ll.printList();
    		return;
    	}
    	if(head2==null){
    		addFromLast(head1,ll,null);
    		ll.printList();
    		return;
    	}
    	
    	while(c1!=null&&c2!=null){
    		if(c1.data>c2.data){
    			sum2+=c2.data;
    			c2=c2.next;
    		}else if(c2.data>c1.data){
    			sum1+=c1.data;
    			c1=c1.next;
    		}else if(c1.data==c2.data){
    			mid=true;
    			break;
    		}
    	}
    	
    	
    	if(mid){
    		maxSumLL(c1.next,c2.next,ll);
    		ll.push(c1.data);
    	}else{
    		Node c3=null;
    		boolean one=false, two=false;
    		if(c1!=null&&c2==null){
    			c3=c1;
    			one=true;
    		}else if(c1==null&&c2!=null){
    			c3=c2;
    			two=true;
    		}
    		while(c1!=null&&one&&!two){
    			sum1+=c1.data;
    			c1=c1.next;
    		}
    		while(c2==null&&two&&!one){
    			sum2+=c2.data;
    			c2=c2.next;
    		}
    		
    		
    	}
    		if(sum1>sum2)
        		addFromLast(head1,ll,c1);
        		else
        		addFromLast(head2,ll,c2);
    		ll.printList();
        		return;
    }
    public void insertionSort(Node head, LinkedList ll){
    	Node c=ll.head.next, c1=ll.head,previ=head,prevc=head,next, prevd;
    	int pivot;
	    	while(c!=null){
	    		next=c.next;
	    		previ=insertSorted(ll,c,previ);
	    		
	    		c=next;
	    	}
    }
    public Node insertSorted(LinkedList ll, Node insert, Node previ){
    	Node node=ll.head,prev=null, next=insert.next, nextn;
    	
    	while(node.data<insert.data){
    		prev=node;
    		node=node.next;
    	}
    	if(node==insert){
    		return insert;
    	}
    	if(prev==null){
    		previ.next=next;
    		insert.next=node;
    		ll.head=insert;
    	}else{
    		prev.next=insert;
    		insert.next=node;
    		previ.next=next;
    	}
    	
    	return previ;
    }
    public Node rearrange(Node head){
    	//Node rhead=reverseList(head);
    	Node slowptr=head, fastptr=head;
    	boolean even=false;
    	
    	while(fastptr.next!=null&&fastptr.next.next!=null){
    		slowptr=slowptr.next;
    		fastptr=fastptr.next.next;
    	}
   
    	if(fastptr.next==null)
    		even=false;
    	else if(fastptr.next.next==null)
    		even=true;
    	
    	Node node=head, node1, temp=null, next=null, next1=null, prev=null;
    	next=slowptr.next;
    	slowptr.next=null;
    	
    	node1=next;
    	node1=reverseList(node1);
    	while(node!=null&&node1!=null){
    		if(prev==null)
    			head=node;
    		temp=node.next;
    		node.next=node1;
    		next1=node1.next;
    		node1.next=null;
    		node1=next1;
    		node=node.next;
    		node.next=temp;
    		node=node.next;
    		prev=node;
    	}
    	
    	return head;
    	}
    public void mergeDec(Node head1, Node head2){
    	Node c1=head1, c2=head2;
    	LinkedList l=new LinkedList();
    	
    	while(c1!=null&&c2!=null){
    		if(c1.data<=c2.data){
    			l.push(c1.data);
    			c1=c1.next;
    			
    		}else{
    			l.push(c2.data);
    			c2=c2.next;
    		}
    	}
    	while(c1!=null){
    		l.push(c1.data);
    		c1=c1.next;
    	}
    	while(c2!=null){
    		l.push(c2.data);
    		c2=c2.next;
    	}
    	l.printList();
    }
	public int strCmp(Node head1, Node head2){
		if(head1==null&&head2==null)
			return 0;
		if(head1!=null&&head2==null)
			return 1;
		if(head1==null&&head2!=null)
			return 0;
		if(head1.data==head2.data)
			return strCmp(head1.next,head2.next);
		else if(head1.data>head2.data)
			return 1;
		else return -1;
			
	}
	public Node evenOdd(Node head){
		if(head==null)
			return null;
		if(head.next==null||head.next.next==null)
			return head;
		Node current=head, check=head.next, prev=null, next=null, tail=null;
		int count=0;
		while(current.next!=null){
			current=current.next;
			count++;
		}
		System.out.println(count);
		tail=current;
		if(count%2==0)
			check=tail;
		else
			check=head.next;
		
		current=head;
		System.out.println(check.data);
		while(current!=check){
			
			prev=current;
			current=current.next;
			
			next=current.next;
			prev.next=next;
			current.next=null;
			tail.next=current;
			tail=tail.next;
			
			current=next;
			System.out.println(current.data);
		}
		return head;
	}
	public Node zigzag(Node head){
		if(head==null)
			return head;
		if(head.next==null||head.next.next==null)
			return head;
		Node current=head,temp,prev=null;
		boolean flag=true;
		while(current!=null&&current.next!=null){
			if(flag){
				if(current.data>current.next.data){
					if(prev==null){
						temp=current.next;
						current.next=current.next.next;
						temp.next=current;
						head=temp;
						prev=temp;
						
						
					}else{
						temp=current.next;
						prev.next=current.next;
						current.next=current.next.next;
						temp.next=current;
						prev=prev.next;
					}
				}else{
					prev=current;
					current=current.next;
				}
				
			}else{
				if(current.data<current.next.data){
					if(prev==null){
						temp=current.next;
						current.next=current.next.next;
						temp.next=current;
						head=temp;
						prev=current;
					
						
					}else{
						temp=current.next;
						prev.next=current.next;
						current.next=current.next.next;
						temp.next=current;
						prev=prev.next;
					}
				}else{
					prev=current;
					current=current.next;
				}
			}
			flag=!flag;
			
		}
		return head;
		
	}
	public Node add1Impl(Node head){
		int carry=add1(head);
		if(carry!=0){
			Node node=new Node(carry);
			node.next=head;
			head=node;
		}
			return head;
	}
	public int add1(Node head){
		if(head.next==null){
			int value=head.data+1;
			if(head.data==9){
				head.data=0;
				return 1;
			}else{
				head.data=value;
				return 0;
			}
		}
			
		
		int value=head.data+add1(head.next);
		int carry=0;
		if(value>9){
			carry=value/10;
			value=value%10;
		}
		head.data=value;
		return carry;
		
	}
	public Node findSecondBig(Node head, int data){
		if(head==null)
			return head;
		if(head.next==null||head.next.next==null)
			return head;
		
		Node c=head, fb=null,sb=null, prev=null;
		while(c!=null){
			if(c.data>data){
			if(fb==null){
				fb=c;
				
			}
			else if(sb==null){
				if(fb.data<c.data){
					sb=fb;
					fb=c;
				}else{
					sb=c;
				}
			}
			else if(fb.data<c.data){
				sb=fb;
				fb=c;
			}
			else if(sb.data<c.data){
				sb=c;
			}
			}
			c=c.next;
		}
		if(sb==null)
			return fb;
		else
			return sb;
	}
    public Node absoluteSort(Node head){
    	if(head==null)
    		return head;
    	Node current=head,prev=null,next;
    	while(current!=null){
    		if(current.data<0){
    			if(prev!=null){
    				next=current.next;
    				current.next=head;
    				head=current;
    				prev.next=next;
    				current=next;
    			}else{
    				prev=current;
    				current=current.next;
    			}
    		}else{
    			prev=current;
    			current=current.next;
    		}
    	}
    	return head;
    }
    public Node insertSortedCLL(Node head, int data){
    	if(head==null)
    		return new Node(data);
    	
    	Node current=head, prev=null, next=null;
    	Node node=new Node(data);
    	do{
    		if(current.data>data){
    			if(prev==null){
    				Node tail=current;
    				while(tail.next!=head){
    					tail=tail.next;
    				}
    			 node.next=head;
    			 tail.next=node;
    			 head=node;
    			
    			}else{
    				prev.next=node;
    				node.next=current;
    				return head;
    			}
    			break;
    		}else{
    			prev=current;
    			current=current.next;
    		}
    	}while(current!=head);
    	if(current==head){
    		prev.next=node;
    	    node.next=head;
    	}
    	return head;
    }
    public Node swapKK(Node head, int k){
    	if(head==null)
    		return null;
    	if(head.next==null)
    		return head;
    	
    	Node current=head, prevkth=null, nextkth=null, current1, kth, lastkth, lastkthprev = null, lastkthnext;
    	int i=1;
    	while(current!=null&&i!=k){
    		prevkth=current;
    		current=current.next;
    		i++;
    	}
    	
    	if(i!=k){
    		System.out.println("Wrong");
    	}else{
    		kth=current;
    		nextkth=current.next;
    		
    		current1=current;
    		current=head;
    		i=1;
    		while(current1.next!=null){
    			lastkthprev=current;
    			current=current.next;
    			current1=current1.next;
    		}
    		lastkth=current;
    		lastkthnext=lastkth.next;
    		
    		if(prevkth!=null)
    		prevkth.next=lastkth;
    		else
    			head=lastkth;
    		
    		
    		lastkthprev.next=kth;
    		Node temp=kth.next;
    		kth.next=lastkth.next;
    		lastkth.next=temp;
    	
    	}
    	return head;
    }
	public static void main(String[] args){
		LlistOps llistOps=new LlistOps();
		Node head=llistOps.llist.head;
		//System.out.println(llistOps.searchNode(6, llistOps.llist.head));
		//llistOps.swapNodes(1, 8);
		//System.out.println(llistOps.findMiddle(llistOps.llist.head).data);
		//System.out.println(llistOps.nthNodefromEnd(4,head).data);
		//Node node= llistOps.reverseListRecur(head,null,null);
		//llistOps.llist.printList(node);
		
        //llistOps.llist.printList(llistOps.mergeLists(llist1.head,llist2.head));
		//llistOps.llist.printList(llistOps.insertInSorted(head,4));
		//llistOps.deleteNode(head.next.next);
		//llistOps.llist.printList(head);
	    // System.out.println(llistOps.floydAlgo(llist1.head));
		
		//llistOps.llist.printList(llistOps.pairwiseRecurSwap(head));
		 LinkedList llist1 = new LinkedList();
	        LinkedList llist2 = new LinkedList();
	 llist1.push(1);
	 llist1.push(2);
	 llist1.push(3);
	 llist1.push(4);
	 llist1.push(5);
	 llist1.push(6);
	 llist1.push(7);
	        //Linked List 1 : 1->3->30->90->110->120->NULL
	        //Linked List 2 : 0->3->12->32->90->100->120->130->NULL
	 
	    //    llist1.push(120);
//	        llist1.push(9);
//	        llist1.push(9);
//	        llist1.push(9);
//	        llist1.push(1);
////	        llist1.push(7);
////	        llist1.push(3);
////	        llist1.push(4);
//	        llist1.printList();
//	       
//	        llist2.push(130);
//	        llist2.push(120);
//	        llist2.push(100);
//	        llist2.push(90);
//	        llist2.push(32);
//	        llist2.push(12);
//	        llist2.push(3);
//	        llist2.push(0);
//		
//	        llist2.printList();
	       // llist1.push('a');
//	        llist1.push('s');
//	        llist1.push('k');
//	        llist1.push('e');
//	        llist1.push('e');
//	        llist1.push('g');
//	        llist1.printList();
//	       
//	      //  llist2.push('b');
//	        llist2.push('s');
//	        llist2.push('k');
//	        llist2.push('e');
//	        llist2.push('e');
//	        llist2.push('g');
		
//	        llist2.printList();
		//llistOps.llist.printList(llistOps.intersectTwoSortedListsRecur(llist1.head, llist2.head, null));
		//llistOps.llist.printList(llistOps.deleteAlternateNodesRecur(head));
		
//		LinkedList llist1=new LinkedList();
//		llist1.push(3);
//		llist1.push(2);
//		llist1.push(6);
//		llist1.push(5);
//		llist1.push(11);
//		llist1.push(10);
//		llist1.push(15);
//		llist1.push(12);
//		llist1.printList();
////		llistOps.llist.printList(llistOps.reverseListRecursive(llist1.head,null));
//		
//		//llistOps.llist.printList(llistOps.reverseAlternateKNodes(head, 1,true));
//		//llistOps.llist.printList(llistOps.reverseInGroupsSimple(head, 3));
//		//llistOps.deleteNodesWithGreaterValue(llist1.head);
//		llist1.printList(llistOps.segregateGoodMethod(llist1.head));
//		LinkedList llist1=new LinkedList();
//		llist1.push(6);
//		llist1.push(4);
//		llist1.push(9);
//		llist1.push(5);
//		llist1.push(7);
//		LinkedList llist2=new LinkedList();
//		//llist2.push(2);
//		llist2.push(4);
//		llist2.push(8);
//		
//		llist1.printList();
//		llist2.printList();
//		
//		llist1.printList(llistOps.addTwoNumbers(llist1.head, llist2.head));
//		llistOps.addTwoListsImpl(llist1.head, llist2.head);
	//	llistOps.mergeAlternate(llist1.head, llist2.head);
		//llist1.printList();
//	        LinkedList result=new LinkedList();
//	        llistOps.maxSumLL(llist1.head, llist2.head,result);
//	        result.printList();
//	        llistOps.insertionSort(llist1.head, llist1);
//	        llist1.printList();
//	        Node node=llistOps.rearrange(llist1.head);
//	        llist1.printList(node);
//	        llistOps.mergeDec(llist1.head, llist2.head);
	//        System.out.println(llistOps.strCmp(llist1.head,llist2.head));
	 //       Node node=llistOps.evenOdd(llist1.head);
	   //     new LinkedList().printList(node);
	        
//	       new LinkedList().printList(llistOps.zigzag(llist1.head));
	        
	       // new LinkedList().printList(llistOps.add1Impl(llist1.head));
//	        Node tail=new Node(10);
//	        llist1.add(tail);
	       // llist1.push(8);
//	        llist1.push(5);
//	        llist1.push(2);
//	        llist1.printList();
//	        llist1.printList(llistOps.swapKK(llist1.head, 1));
//	        Node head1=new Node(1);
//	        llist1.add(head1);
//	        tail.next=head1;
//	        Node c=head1;
//	        do{
//	        	System.out.print(c.data+"->");
//	        	c=c.next;
//	        }while(c!=head1);
//	        System.out.println();
//	      //  llist1.printList();
////	        new LinkedList().printList(llistOps.absoluteSort(llist1.head));
//	        head1=(llistOps.insertSortedCLL(llist1.head, 7));
//	         c=head1;
//	        do{
//	        	System.out.print(c.data+"->");
//	        	c=c.next;
//	        }while(c!=head1);
	}
}
