package GraphQuestions;

import java.util.Iterator;
public class KCores{
	Graph1 g;
	int[] neighborCount;
	boolean[] visited;
	boolean[] remove;
	int degree;
	public KCores(Graph1 g){
		this.g=g;
		neighborCount=new int[g.v];
		for(int i=0;i<g.v;i++)
			neighborCount[i]=g.adj[i].size();
		visited=new boolean[g.v];
		remove=new boolean[g.v];
		degree=3;
		doDFS(0);
		
		printFinalGraph();
	}
	public void doDFS(int index){
		if(!visited[index]){
			visited[index]=true;
				Iterator it=g.adj[index].iterator();
				while(it.hasNext()){
					int x=(int)it.next();
				if(neighborCount[index]<degree){;
				   neighborCount[x]--;
				}
				doDFS(x);
				}
		}
	}
	public void printFinalGraph(){
		for(int i=0;i<g.v;i++){
			System.out.print("Neighbour count of : "+i+" is "+neighborCount[i]+" ");
			if(neighborCount[i]>=degree){
				Iterator it=g.adj[i].iterator();
				System.out.print("Node "+i+": ");
				while(it.hasNext()){
					int x=(int)it.next();
					if(neighborCount[x]>=degree){
						System.out.print(x+" ");
					}
				}
			}
			System.out.println();
		}
	}
	
	
}