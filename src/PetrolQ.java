//Find the first circular tour that visits all petrol pumps
public class PetrolQ {

	class QNode{
		int petrol,distance;
		QNode next;
		public QNode(int p, int d){
			this.petrol=p;
			this.distance=d;
			this.next=null;
		}
	}
	QNode start,rear, whole_start;
	public void push(QNode node){
		if(start==null){
			start=node;
			rear=node;
		}
		else{
			rear.next=node;
			rear=node;
		}
	}
	public QNode pop(){
		if(rear==null){
			return null;
		}else{
			if(start==rear){
				start=null;
				rear=null;
				return rear;
			}else{
				QNode r=start;
				start=start.next;
				r.next=null;
				return r;
			}
		}
	}
	public QNode peek(){
		if(rear==null)
			return null;
		return start;
	}
	
	public QNode solve(){
		QNode current=start, temp;
		
		do{
			int p, d;
			p=start.petrol;
			d=start.distance;
			if(p<d){
				temp=pop();
				push(temp);
			}else{
				boolean check=check(start);
				if(check)
					return start;
				else{
					temp=pop();
					push(temp);
				}
			}
		}while(start!=whole_start);
		return null;
	}
	public boolean check(QNode node){
	    QNode current=node;
	    int p, d, remaining=0;
	    do{
	    	p=current.petrol+remaining;
	    	d=current.distance;
	    	remaining=p-d;
	    	
	    	if(remaining<0){
	    		return false;
	    	}
	    	current=current.next;
	    }while(current!=whole_start);
	    return true;
	}
	public static void main(String[] args){
		PetrolQ pq=new PetrolQ();
		QNode s=pq.new QNode(6,4);
		pq.whole_start=s;
		pq.push(s);
		pq.push(pq.new QNode(3,6));
		pq.push(pq.new QNode(7,3));
		//pq.push(pq.new QNode(6,5));
		
		QNode ans=pq.solve();
		if(ans==null)
			System.out.println("No");
		else{
			System.out.println(ans.petrol+","+ans.distance);
		}
	}
}
