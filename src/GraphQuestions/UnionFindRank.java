package GraphQuestions;

//	Union-Find Algorithm | Set 2 (Union By Rank and Path Compression)
import java.util.HashMap;
import java.util.Map;
public class UnionFindRank{
	Map<Integer, Node> m1;
	public UnionFindRank(){
		m1=new HashMap();
	}
	
	//Make sets for individual elements
	public Node makeSet(int data){
		Node node=new Node(data);
		node.parent=node;
		m1.put(data, node);
	    //System.out.println(m1.get(data));
		return node;
		
	}
	//Find set i.e representative of the set that contains the data
	public int findSet(int data){
		return findSet (m1.get(data)).data;
	}
	
	//Find its parent
	public Node findSet(Node node){
		//System.out.println(node.data);
		if(node.parent==node)
			return node;
		node.parent=findSet(node.parent);
		return node.parent;
	}
	//Combine two sets into one. i.e make one of the representative the parent of the other
	public void union(Node n1, Node n2){
		
		if(n1.rank>=n2.rank){
			if(n1.rank==n2.rank){
				n1.rank=n1.rank+1;
			}
			n2.parent=n1;
		}
		else
			n1.parent=n2;
	}
	public boolean isCycle(int src, int dest){
		Node n1=(Node)m1.get(src);
		Node n2=(Node)m1.get(dest);
		//System.out.println(n1);
		Node p1=findSet(n1);
		Node p2=findSet(n2);
		
		if(p1==p2){
			return true;
		}
		union(p1,p2);
		return false;
	}
	public static void main(String[] args){
		UnionFindRank u=new UnionFindRank();
		int[][] v=new int[3][2];
		v[0][0]=0; v[0][1]=1;
		v[1][0]=1; v[1][1]=2;
		v[2][0]=0; v[2][1]=2;
		
		u.makeSet(0);
		u.makeSet(1);
		u.makeSet(2);
		System.out.println(u.m1);
		for(int i=0;i<3;i++){
		//	System.out.println(v[i][0]+" "+v[i][1]);
				if(u.isCycle(v[i][0], v[i][1])){
					System.out.println("Cycle found");
					break;
				}
		}
		
	}
	class Node{
		int rank;
		Node parent;
		int data;
		public Node(int data){
			this.data=data;
			rank=0;
		}
	}
}
