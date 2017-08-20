
public class Queue {

	int[] array;
	int f, size, r;
	QNode front, rear;
	
	public Queue(){
		front=null;
	}
	
	public void push(int data){
		
		if(rear==null){
			front=new QNode(data);
			rear=front;
			return;
		}
		QNode q=new QNode(data);
		rear.next=q;
		rear=q;
			
	}
	public QNode pop(){
		if(rear==null)
			return rear;
		else{
			QNode q=front;
			front=front.next;
			q.next=null;
			return q;
		}
		
	}
	public int peek(){
		if(front==null)
			return -1;
		return front.data;
	}
	public void printQ(){
		QNode c=front;
	    while(c!=null){
	    	System.out.print(c.data);
	    	c=c.next;
	    }
	    System.out.println();
	}
	public void printQ(boolean arrType){
		int qtop=f;
		while(qtop!=r+1){
			System.out.print(array[qtop]);
			qtop++;
		}
		
	}
	
	public Queue(boolean arType, int size){
		array=new int[size];
		r=-1;
		f=-1;
		this.size=size;
	}
	public void push(boolean arType, int data){
		
		if(r>=size){
			System.out.println("Can't be added");
			return;
		}
		if(f==-1){
			f++;
			array[f]=data;
			r=f;
		}else{
			array[++r]=data;
		}
	}
	public int pop(boolean arType){
		if(r==-1){
			//System.out.println("Nothing to delete");
			return r;
		}
		int value=array[f];
		for(int i=f;i<r;i++){
			array[i]=array[i+1];
		}
		r=r-1;
		return value;
	}
	public int peek(boolean arType){
		if(r==-1)
			return -1;
		return array[f];
	}
}
 
class QNode{
	QNode next;
	int data;
	public QNode(int data){
		this.data=data;
		next=null;
	}
}