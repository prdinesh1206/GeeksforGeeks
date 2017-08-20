package GraphQuestions;

//Longest Path in a Directed Acyclic Graph
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;
public class WeightedDGraph{
	int v;
	LinkedList<AdjNode>[] adj;
	Stack<Integer> stack;
	boolean[] visited;
	public WeightedDGraph(int v){
		this.v=v;
		adj=new LinkedList[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList<AdjNode>();
		}
		visited=new boolean[v];
	}
	public void addEdge(int src, int dest, int weight){
		AdjNode node=new AdjNode(dest, weight);
		adj[src].add(node);
	}
	public void doTopoSortUtil(){
		stack=new Stack<Integer>();
		for(int i=0;i<v;i++){
			doTopoSort(i);
		}
		
	}
	//Topological Sort Algo
	public void doTopoSort(int index){
		
		if(!visited[index]){
			visited[index]=true;
			Iterator it=adj[index].iterator();
			while(it.hasNext()){
				
				doTopoSort(((AdjNode)it.next()).index);
			}
			stack.push(index);
		}
	}
	//Algorithm
	public void findLongestPath(int s){
		doTopoSortUtil();
		int[] dist=new int[v];
		for(int i=0;i<v;i++)
			dist[i]=Integer.MIN_VALUE;
		dist[s]=0;
		//For each element in the stack, pop it, calculate the distances of each element from the source
		while(!stack.empty()){
			int current=stack.pop();
			if(dist[current]!=Integer.MIN_VALUE){ //if dist[current] is equal to Integer.Min_value, then it is not the neighbor of source or cannot be reached by source
				Iterator it=adj[current].iterator();
				while(it.hasNext()){
					AdjNode c=(AdjNode)it.next();
				if(dist[c.index]<dist[current]+c.weight){
					dist[c.index]=dist[current]+c.weight;
				}
				}
			}
		}
		System.out.println("Distances");
		for(int i=0;i<v;i++){
			if(dist[i]==Integer.MIN_VALUE){
				System.out.print("INF ");
			}else{
				System.out.print(dist[i]+" ");
			}
		}
	}
	public static void main(String[] args){
		WeightedDGraph g=new WeightedDGraph(6);
		g.addEdge(0, 1, 5);
    g.addEdge(0, 2, 3);
    g.addEdge(1, 3, 6);
    g.addEdge(1, 2, 2);
    g.addEdge(2, 4, 4);
    g.addEdge(2, 5, 2);
    g.addEdge(2, 3, 7);
    g.addEdge(3, 5, 1);
    g.addEdge(3, 4, -1);
    g.addEdge(4, 5, -2);
	int s=1;
	g.findLongestPath(s);
	}
	class AdjNode{
		int index, weight;
		public AdjNode(int index, int weight){
			this.index=index;
			this.weight=weight;
		}
	}
}