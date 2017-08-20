package GraphQuestions;

import java.util.Iterator;

public class DetectCycle{
DirectedG g;
boolean[] visited;
boolean[] findRepeat;
  
  public DetectCycle(DirectedG g){
	this.g=g;
	visited=new boolean[g.v];
	findRepeat=new boolean[g.v];
	findCycle();
}	
public boolean doDFS(int index){
	if(findRepeat[index]){
		return true;
	}else{
		visited[index]=true;
		findRepeat[index]=true;
		Iterator it=g.adj[index].iterator();
		
		while(it.hasNext()){
			if(doDFS((int)it.next())){
				return true;
			}
		}
	}
	findRepeat[index]=false;
	return false;
}

public void findCycle(){
	int i;
	for(i=0;i<g.v;i++){
		//visited=new boolean[g.v];
		if(doDFS(i)){
			System.out.println("Cycle found");
			break;
		}
	}
	if(i>=g.v)
		System.out.println("No cycle found. search for car :P");
}
}