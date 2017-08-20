package GraphQuestions;

import java.util.Iterator;
public class DetectCycleInUD{
	boolean[] visited;
	Graph1 g;
	
	public DetectCycleInUD(Graph1 g){
		this.g=g;
		visited=new boolean[g.v];
		for(int i=0;i<g.v;i++)
			if(!visited[i])
				if(doDetect(i,-1))
				{
					break;
				}
	}
	
	public boolean doDetect(int index, int parent){
		Iterator it=g.adj[index].iterator();
		 int next;
		while(it.hasNext()){
			next=(int)it.next();
			if(visited[next]){
				if(next!=parent){
					System.out.println("Found at "+index+" "+next);
					return true;
				}
			}else{
				visited[index]=true;
				if(doDetect(next,index)){
					return true;
				}
			}
		}
		return false;
	}
}