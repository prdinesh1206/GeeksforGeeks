package GraphQuestions;

import java.util.Iterator;
public class GraphColorAlgo{
	DirectedG g;
	int[] color;
	int src,dest;
	public GraphColorAlgo(DirectedG g){
		this.g=g;
		color=new int[g.v];
		for(int i=0;i<g.v;i++){
			color[i]=0;
		}
		detectCycle();
	}
	public boolean doDFS(int index){
		if(color[index]==2)
			return false;
		if(color[index]==1){
			//dest=index;
			System.out.print(index+" ");
			return true;
		}
		color[index]=1;
		Iterator it=g.adj[index].iterator();
		while(it.hasNext()){
		if(doDFS((int)it.next())){
			System.out.print(index+" ");
			return true;
		}
		}
		color[index]=2;
		return false;
	}
	public void detectCycle(){
		boolean found=false;
		for(int i=0;i<g.v;i++){
			if(color[i]==0)
			if((found=doDFS(i))){
				System.out.println("\nCycle found");
				break;
			}
		}
		if(!found)
			System.out.println("Not found");
	}
}