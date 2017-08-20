package GraphQuestions;

//Kruskal’s Minimum Spanning Tree Algorithm
//Greedy Method
//1. Sort all the edges in increasing order of their weight
//2. Find if there are cycle for each edge in 1
//3. If no, insert into the mst

import java.util.Arrays;
public class Krushal{
	class Edge implements Comparable{
		int src, dest, weight;
		public Edge(int src, int dest, int weight){
			this.src=src;
			this.dest=dest;
			this.weight=weight;
		}
		public int compareTo(Object e){
			Edge e1=(Edge)e;
			return this.weight-e1.weight;
		}
	}
	Edge[] resultEdges;
	int v;
	Edge[] edges;
	UnionFindRank u;
	int resultEdgesCount;
	public Krushal(int v){
		this.v=v;
		resultEdges=new Edge[v];
		edges=new Edge[v];
		
		u=new UnionFindRank();
		resultEdgesCount=0;
	}
	public void doAlgo(){
		edges[0]=new Edge(0,1,10);
		edges[1]=new Edge(0,2,6);
		edges[2]=new Edge(0,3,5);
		edges[3]=new Edge(1,3,15);
		edges[4]=new Edge(2,3,4);
		Arrays.sort(edges);
		
		for(int i=0;i<v;i++){
			Edge current=edges[i];
			if(!u.isCycle(current.src, current.dest)){
				resultEdges[resultEdgesCount++]=current;
			}
		}
	}
	public static void main(String[] args){
		Krushal k=new Krushal(5);
		k.u.makeSet(0);
		k.u.makeSet(2);
		k.u.makeSet(1);
		k.u.makeSet(3);
		
		
		k.doAlgo();
		
		for(int i=0;i<k.resultEdgesCount;i++){
			System.out.println(k.resultEdges[i].src+"-->"+k.resultEdges[i].dest+" = "+k.resultEdges[i].weight);
		}
	}
	
	
	
}