package GraphQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class TopoKahnSort{
	int indegree[];
	boolean visited[];
	DirectedG g;
	Queue<Integer> q;
	
	public TopoKahnSort(DirectedG g){
		this.g =g;
		indegree=new int[g.v];
		visited=new boolean[g.v];
		q=new LinkedList<Integer>();
		kahnAlgo();
	}
	public void kahnAlgo(){
		//Count the indegree for each node: O(V+E)
		for(int i=0;i<g.v;i++){
			Iterator it=g.adj[i].iterator();
			while(it.hasNext()){
				indegree[(int)it.next()]++;
			}
		}
		
		//Find node with indegree =0 and add them in queue
		//O(V)
		for(int i=0;i<g.v;i++)
			if(indegree[i]==0)
				q.add(i);
		
		//while queue is not empty, reduce the indegree of all neighboring nodes in the graph
		//If an indegree of neighboring nodes is 0, then add them to queue
		
		//O(V+E)
		int vertex, neighbor, count=0;
		Iterator it;
		while(q.size()!=0){
			vertex=(int)q.poll();
			it=g.adj[vertex].iterator();
			while(it.hasNext()){
				neighbor=(int)it.next();
				indegree[neighbor]--;
				if(indegree[neighbor]==0)
					q.add(neighbor);
			}
			System.out.print(vertex+" ");
			count++;
		}
		if(count!=g.v){
			System.out.println("Topo not possible because there is a cycle");
		}
	}
}
//Overall Time complexity: O(V+E)