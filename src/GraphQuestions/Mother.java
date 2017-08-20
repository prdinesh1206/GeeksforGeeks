package GraphQuestions;

import java.util.Iterator;
public class Mother{
	
	DirectedG g;
	boolean[] visited;
	public Mother(DirectedG g){
		this.g=g;
		visited=new boolean[g.v];
		findMother();
	}
	public void DFSR(int index){
		if(!visited[index]){
			Iterator it;
			visited[index]=true;
			it=g.adj[index].iterator();
			while(it.hasNext())
			DFSR((Integer)it.next());
		}
	}
	public void findMother(){
		int i, finishedLast=0;
		boolean foundM=true;
		for(i=0;i<g.v;i++){
			if(!visited[i]){
				DFSR(i);
				finishedLast=i;
			}
		}
		System.out.println("FinishedLast: "+finishedLast);
		
		for(i=0;i<g.v;i++)
			visited[i]=false;
		
		DFSR(finishedLast);
		
		for(i=0;i<g.v;i++){
			if(!visited[i]){
				foundM=false;
				break;
			}
		}
		if(foundM)
		System.out.println("Found Mother "+finishedLast);
	    else
		System.out.println("Not found");
	}
	
	
}