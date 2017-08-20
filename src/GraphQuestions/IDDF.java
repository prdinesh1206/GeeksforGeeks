package GraphQuestions;

import java.util.Iterator;

public class IDDF{
	Graph1 g;
	int target, maxDepth;
	
	public IDDF(Graph1 g){
		this.g=g;
		target=6;
		maxDepth=3;
		doIDDF();
	}
	public void doIDDF(){
		for(int i=1;i<=maxDepth;i++){
			if(utilIDDF(i,0)){
				System.out.println("Found at "+i);
				return;
			}
		}
		System.out.println("Not found");
	}
	public boolean utilIDDF(int h, int index){
		if(h<=0)
			return false;
		Iterator it=g.adj[index].iterator();
		boolean found=false;
		if(index==target)
			return true;
		while(it.hasNext()){
		    found=utilIDDF(h-1,(int)it.next());
			if(found)
				return found;
		}
		return found;
	}
}