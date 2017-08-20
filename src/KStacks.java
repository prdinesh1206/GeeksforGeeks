
public class KStacks {

	int free;
	int[] top, next, result;
	
	public KStacks(int k){
		
		
		top=new int[k];
		for(int i=0;i<k;i++)
			top[i]=-1;
		next=new int[20];
		for(int i=0;i<20;i++)
			next[i]=i+1;
		next[19]=-1;
		result=new int[20];
		
	}
	public void push(int data, int sn){
		if(free==-1){
			System.out.println("Over");
			return;
		}
			
		int i=free;
		free=next[i];
		
		next[i]=top[sn];
		top[sn]=i;
		
		result[i]=data;
	}
	public int pop(int sn){
		if(top[sn]==-1){
			System.out.println("Nothing to pop");
			return -1;
		}
		int i=top[sn];
		top[sn]=next[i];
		
		next[i]=free;
		free=i;
		return result[i];
	}
	
	public static void main(String[] args){
		KStacks ks=new KStacks(3);
		ks.push(15, 2);
		ks.push(45, 2);
		
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);
		
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);
		
		System.out.println(ks.pop(0));
		System.out.println(ks.pop(1));
		System.out.println(ks.pop(2));
	}
}
