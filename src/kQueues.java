
public class kQueues {

	int free;
	int[] front, rear, next, result;
	
	public kQueues(int size){
		
		free=0;
		front=new int[size];
		rear=new int[size];
		result=new int[20];
		next=new int[20];
		
		for(int i=0;i<size;i++)
			front[i]=-1;
		for(int i=0;i<size;i++)
			rear[i]=-1;
		
		for(int i=0;i<20;i++)
			next[i]=i+1;
		next[19]=-1;
	}
	
	public void push(int data, int qn){
		if(free==-1){
			System.out.println("Nothing");
			return;
		}
		
		int i=free;
		rear[qn]=i;
		free=next[i];
		if(front[qn]==-1)
			front[qn]=i;
		else
			next[rear[qn]]=i;
		next[i]=-1;
		rear[qn]=i;
		result[i]=data;
	}
	public int pop(int qn){
		if(front[qn]==-1)
		{
			System.out.println("There is nothing");
			return -1;
		}
		
		int i=front[qn];
		front[qn]=next[i];
		next[i]=free;
		free=i;
		return result[i];
	}
	public static void main(String[] args){
		kQueues ks=new kQueues(3);
		
		ks.push(15, 2);
		ks.push(45, 2);
		
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);
		
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		
		System.out.println(ks.pop(0));
		ks.push(12, 0);
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(0));
	}
}
