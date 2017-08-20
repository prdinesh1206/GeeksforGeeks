
public class StackOps {

 class Stack {

	char[] array;
	int top, size;
	StackNode stack_top;
	
	public Stack(){
		stack_top=null;
	}
	
	public void push(char data){
		
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
	    	System.out.print(c.data+" ");
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
	
	public Stack(boolean arType, int size){
		array=new char[size];
		top=-1;
		this.size=size;
	}
	public void push(boolean arType, char data){
		
		if(top>=size)
		{
			System.out.println("Not possible");
			return;
		}
		array[++top]=data;
	}
	public char pop(boolean arType){
		if(top==-1){
			System.out.println("Can't pop");
			return '$';
		}
		return array[top--];
	}
	public char peek(boolean arType){
		if(top==-1)
			return '$';
		return array[top];
	}
}
 
class StackNode{
	StackNode next;
	char data;
	public StackNode(char data){
		this.data=data;
		next=null;
	}
}

	public void infix2Postfix(String s){
		Stack stack=new Stack(true,s.length());
		char temp;
		System.out.println();
		//a+b*(c^d-e)^(f+g*h)-i
		for(char ch: s.toCharArray()){
			if((ch>='a'&&ch<='z')||(ch>='A'&&ch<='Z')){
				System.out.print(ch);
			}
			else if(ch=='('||ch=='*'||ch=='/'||ch=='^'){
				stack.push(true, ch);
				//stack.printStack(true);
			}else if(ch==')'){
					while(stack.top!=-1&&(temp=stack.pop(true))!='('){
						System.out.print(temp);
				}
					//stack.printStack(true);
			}else if(ch=='+'||ch=='-'){
				temp=stack.peek(true);
				if(temp=='*'||temp=='/'||temp=='^'){
				while(stack.top!=-1&&(temp=stack.pop(true))!='('){
					
					System.out.print(temp);
				}
				if(temp=='(')
					stack.push(true, '(');
				}
				stack.push(true,ch);
				//stack.printStack(true);
			}
		}
		while(stack.top!=-1){
			System.out.print(stack.pop(true));
		}
	}
	
	
	public static void main(String[] args){
		StackOps so=new StackOps();
		Stack s=so.new Stack(true,10);
		s.push(true,'1');
		s.push(true,'2');
		s.push(true,'3');
		s.printStack(true);
		s.pop(true);
		s.printStack(true);
		so.infix2Postfix("a+b*(c^d-e)^(f+g*h)-i");
		so.infix2Postfix("a+b*c+d");
	}
}
