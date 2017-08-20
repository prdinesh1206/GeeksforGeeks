package GraphQuestions;

public class UnionFind{
	int[] nodes, parents;
	class Edge{
		int src, dest;
	}
	Edge edges[];
	
	public UnionFind(int ecount){
		edges=new Edge[ecount];
		for(int i=0;i<ecount;i++)
			edges[i]=new Edge();
		parents=new int[ecount];
		for(int i=0;i<ecount;i++)
			parents[i]=-1;
		
	}
	public int find(int value){
		if(parents[value]==-1)
			return value;
		return find(parents[value]);
	}
	public void union(int src, int dest){
		parents[src]=dest;
	}
	public void findCycle(){
		int findofsrc, findofdest;
		for(Edge e: edges){
			findofsrc=find(e.src);
			findofdest=find(e.dest);
			
			if(findofsrc==findofdest){
				System.out.println("Found at: "+e.src+" "+e.dest);
				return;
			}
			union(findofsrc,findofdest);
		}
	}
	public static void main(String[] args){
		UnionFind u=new UnionFind(5);
		
		u.edges[0].src=0;
		u.edges[0].dest=1;
		u.edges[1].src=0;
		u.edges[1].dest=2;
		u.edges[2].src=1;
		u.edges[2].dest=3;
		u.edges[3].src=1;
		u.edges[3].dest=4;
		u.edges[4].src=3;
		u.edges[4].dest=4;
		
		u.findCycle();
		
	}
}