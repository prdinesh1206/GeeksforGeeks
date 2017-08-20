package GraphQuestions;

import java.util.Iterator;
public class TransitiveC{
	DirectedG g;
	int[][] matrix;
	boolean[] visited;
	
	public TransitiveC(DirectedG g){
		this.g=g;
		matrix=new int[g.v][g.v];
		visited=new boolean[g.v];
		warshall();
		
		
	}
	public void warshall(){
		int i;
		Iterator it;
		for(i=0;i<g.v;i++){
			it=g.adj[i].iterator();
			matrix[i][i]=1;
			while(it.hasNext()){
				matrix[i][(int)it.next()]=1;
			}
		}
		System.out.println("Original Graph");
		printGraph();
		int j,k;
		
		for(k=0;k<g.v;k++){
			for(i=0;i<g.v;i++){
				for(j=0;j<g.v;j++){
					matrix[i][j]=((matrix[i][j]==1)||(matrix[i][k]==1&&matrix[k][j]==1))?1:0;
				}
			}
		}
		System.out.println("Transitive Closure");
		printGraph();
		
		System.out.println("Transitive Closure using DFS");
		warshallDFS();
		printGraph();
		
	}
	public void warshallDFS(){
		int i;
		for(i=0;i<g.v;i++){
			renewVisited();
			DFS(i,i);
		}
	}
	public void DFS(int index, int dest){
		if(!visited[index])
		{
			Iterator it;
			visited[dest]=true;
			matrix[index][dest]=1;
			it=g.adj[dest].iterator();
			while(it.hasNext()){
				DFS(index, (int)it.next());
			}
		}
	}
	public void renewVisited(){
		for(int i=0;i<g.v;i++)
			visited[i]=false;
	}
	public void printGraph(){
		int i,j;
		for(i=0;i<g.v;i++){
			for(j=0;j<g.v;j++)
				System.out.print(matrix[i][j]+" ");
			System.out.println();
		}
	}
	
}