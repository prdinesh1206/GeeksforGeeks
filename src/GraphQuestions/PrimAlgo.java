package GraphQuestions;

//Prim's Algorithm for MST
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
public class PrimAlgo{
	class AdjNode{
		int dest, weight;
		public AdjNode(int d, int w){
			this.dest=d;
			this.weight=w;
		}
	}
	class Edge{
		int src, dest, weight;
		public Edge(int s, int d, int w){
			src=s;
			dest=d;
			weight=w;
		}
	}
	class HeapNode{
		int node, weight;
		public HeapNode(int n, int w){
			node=n;
			weight=w;
		}
	}
	class BHeap{
		int heapsize, maxsize;
		HeapNode[] heap;
		public BHeap(int maxsize){
			this.maxsize=maxsize;
			heap=new HeapNode[maxsize];
			heapsize=0;
		}
		public int parent(int i){
			return (i-1)/2;
		}
		public int left(int i){
			return 2*i+1;
		}
		public int right(int i){
			return 2*i+2;
		}
		public void swap(int i, int j){
			HeapNode temp=heap[i];
			heap[i]=heap[j];
			heap[j]=temp;
		}
		public void insertKey(int i, int w){
			if(heapsize>=maxsize){
				System.out.println("Sorry exceeded");
				return;
			}
			HeapNode h=new HeapNode(i,w);
			if(heapsize==0){
				heap[0]=h;
				heapsize++;
				return;
			}
			heapsize++;
			int hi=heapsize-1;
			heap[hi]=h;
			while(hi!=0&&heap[parent(hi)].weight>heap[hi].weight){
				swap(hi,parent(hi));
				hi=parent(hi);
			}
		}
		public HeapNode extractMin(){
			if(heapsize==0){
				return null;
			}
			if(heapsize==1){
				heapsize--;
				return heap[0];
			}
			HeapNode h=heap[0];
			heap[0]=heap[heapsize-1];
			heapsize--;
			minHeapify(0);
			
			return h;
		}
		public void minHeapify(int i){
			int l=left(i);
			int r=right(i);
			int smallest=i;
			if(l<heapsize&&heap[l].weight<heap[i].weight)
				smallest=l;
			if(r<heapsize&&heap[r].weight<heap[smallest].weight)
				smallest=r;
			if(smallest!=i){
				swap(i,smallest);
				minHeapify(smallest);
			}
		}
		public int find(int x){
			for(int i=0;i<heapsize;i++){
				if(heap[i].node==x){
					return i;
				}
			}
			return -1;
		}
		public void decreaseKey(int x, int value){
			    int i=find(x);
				//System.out.println("Find: "+x+" "+i);
				heap[i].weight=value;
				while(i!=0&&heap[parent(i)].weight>heap[i].weight){
					swap(i,parent(i));
					i=parent(i);
				}
			
		}
		public void deleteKey(int i){
			
				decreaseKey(i,Integer.MIN_VALUE);
				extractMin();
			
		}
		public boolean isEmpty(){
			return (heapsize<=0?true:false);
		}
		
	}
	public void addEdge(int src, int dest, int weight){
		adj[src].add(new AdjNode(dest, weight));
		Iterator it=adj[dest].iterator();
        AdjNode t;
        boolean found=false;
        while(it.hasNext()){
        t=(AdjNode)it.next();
        if(t.dest==src)
        found=true;
        }
        if(!found)
        adj[dest].add(new AdjNode(src,weight));
        
	}

	BHeap h;
	Map<Integer, Edge> m;
	DirectedG g;
	LinkedList<AdjNode>[] adj;
	LinkedList<Edge> result;
	boolean[] visited;
    
	public PrimAlgo(int v){
		m=new HashMap();
		h=new BHeap(v);
		adj=new LinkedList[v];
		result=new LinkedList();
		visited=new boolean[v];
		for(int i=0;i<v;i++){
			adj[i]=new LinkedList();
		}
		h.insertKey(0,0);
		h.insertKey(1,Integer.MAX_VALUE);
		h.insertKey(2,Integer.MAX_VALUE);
		h.insertKey(3,Integer.MAX_VALUE);
		h.insertKey(4,Integer.MAX_VALUE);
		h.insertKey(6,Integer.MAX_VALUE);
		h.insertKey(7,Integer.MAX_VALUE);
		h.insertKey(8,Integer.MAX_VALUE);
		h.insertKey(5,Integer.MAX_VALUE);
		
		//addEdge(0,1,3);
		//addEdge(0,3,1);
		//addEdge(1,3,3);
		//addEdge(1,2,1);
		//addEdge(2,3,1);
		//addEdge(3,4,6);
		//addEdge(2,4,5);
		//addEdge(2,5,4);
		//addEdge(5,4,2);
		addEdge(0, 1, 4);
    addEdge(0, 7, 8);
    addEdge(1, 2, 8);
    addEdge(1, 7, 11);
    addEdge(2, 3, 7);
    addEdge(2, 8, 2);
    addEdge(2, 5, 4);
    addEdge(3, 4, 9);
    addEdge(3, 5, 14);
    addEdge(4, 5, 10);
    addEdge(5, 6, 2);
    addEdge(6, 7, 1);
    addEdge(6, 8, 6);
    addEdge(7, 8, 7);
		doPrimAlgo();
	}
	public void doPrimAlgo(){
		while(!h.isEmpty()){
			HeapNode hnode=h.extractMin();
			if(m.get(hnode.node)!=null){
				result.add((Edge)m.remove(hnode.node));
			}
			Iterator it=adj[hnode.node].iterator();
			//System.out.println("Now checking vertex "+hnode.node);
			while(it.hasNext()){
				AdjNode a=(AdjNode)it.next();
				int adjacent=h.find(a.dest);
				if(adjacent!=-1 && h.heap[adjacent].weight>a.weight){
					//System.out.println("Weight is less than map: "+h.heap[adjacent].weight+" "+hnode.node+"->"+a.dest);
					h.decreaseKey(a.dest, a.weight);
					m.put(a.dest,new Edge(hnode.node,a.dest,a.weight));
				}
				
			}
		}
		Iterator it=result.iterator();
		System.out.println("MST");
		while(it.hasNext()){
			Edge e=(Edge)it.next();
			System.out.println(e.src+"->"+e.dest+"="+e.weight);
		}
	}
	public static void main(String[] args){
		new PrimAlgo(9);
	}
	
	
}