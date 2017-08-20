
public class MyStack {

	int[] array;
	int top, size;
	StackNode stack_top;
	
	public MyStack(){
		stack_top=null;
	}
	
	public void push(int data){
		
		if(stack_top==null){
			stack_top=new StackNode(data);
			return;
		}
		StackNode node=new StackNode(data);
		node.next=stack_top;
		stack_top=node;
	}
	public StackNode pop(){
		if(stack_top==null)
			return stack_top;
		else{
			StackNode next=stack_top.next;
			stack_top=stack_top.next;
			next.next=null;
			return next;
		}
		
	}
	public int peek(){
		if(stack_top==null)
			return -1;
		return stack_top.data;
	}
	public void printStack(){
		StackNode c=stack_top;
	    while(c!=null){
	    	System.out.print(c.data);
	    	c=c.next;
	    }
	    System.out.println();
	}
	public void printStack(boolean arrType){
		int stacktop=top;
		while(stacktop!=-1){
			System.out.print(array[stacktop--]+" ");
		}
		System.out.println();
	}
	
	public MyStack(boolean arType, int size){
		array=new int[size];
		top=-1;
		this.size=size;
	}
	public void push(boolean arType, int data){
		
		if(top>=size)
		{
			System.out.println("Not possible");
			return;
		}
		array[++top]=data;
	}
	public int pop(boolean arType){
		if(top==-1){
			System.out.println("Can't pop");
			return -1;
		}
		return array[top--];
	}
	public int peek(boolean arType){
		if(top==-1)
			return -1;
		return array[top];
	}
}
 
class StackNode{
	StackNode next;
	int data;
	public StackNode(int data){
		this.data=data;
		next=null;
	}
}