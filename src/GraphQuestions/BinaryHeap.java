package GraphQuestions;

public class BinaryHeap{
	int[] heap;
	int heapsize;
	int maxsize;
	public BinaryHeap(int m){
		heapsize=0;
		maxsize=m;
		heap=new int[maxsize];
	}
	public int parent(int i){
		return (i-1)/2 ;
	}
	public int left(int i){
		return (2*i+1);
	}
	public int right(int i){
		return (2*i+2);
	}
	public void swap(int i, int j){
		int temp=heap[j];
		heap[j]=heap[i];
		heap[i]=temp;
	}
	public void insertKey(int key){
		if(heapsize>=maxsize){
			System.out.println("Heap overflow!!");
			return;
		}
		if(heapsize==0){
			heap[heapsize++]=key;
			return;
		}
		heapsize++;
		int i=heapsize-1;
		heap[i]=key;
		while(i!=0 && heap[parent(i)]>=heap[i]){
			swap(parent(i),i);
			i=parent(i);
		}
	}
	public int extractMin(){
		if(heapsize<=0){
			System.out.println("Nothing in the heap");
			return Integer.MAX_VALUE;
		}
		if(heapsize==1){
			heapsize--;
			return heap[0];
		}
		int root=heap[0];
		heap[0]=heap[heapsize-1];
		heapsize--;
		minHeapify(0);
		return root;
	}
	public void decreaseKey(int i, int value){
		if(i>=0&&i<heapsize){
			heap[i]=value;
			while(i!=0&&heap[parent(i)]>heap[i]){
				swap(i,parent(i));
				i=parent(i);
			}
		}
	}
	public void minHeapify(int i){
		int l=left(i);
		int r=right(i);
		int smallest=i;
		if(l<heapsize&&heap[i]>heap[l])
			smallest=l;
		if(r<heapsize&&heap[smallest]>heap[r])
			smallest=r;
		if(i!=smallest){
		    swap(i,smallest);
			minHeapify(smallest);
		}
	}
	public void deleteKey(int i){
		if(i>=0&&i<heapsize){
			decreaseKey(i,Integer.MIN_VALUE);
			extractMin();
		}
	}
	public int getMin(){
		return heap[0];
	}
	public static void main(String[] args){
		BinaryHeap h=new BinaryHeap(10);
		 h.insertKey(3);
    h.insertKey(2);
    h.deleteKey(1);
    h.insertKey(15);
    h.insertKey(5);
    h.insertKey(4);
    h.insertKey(45);
	System.out.println(h.extractMin());
	System.out.println(h.getMin());
	h.decreaseKey(2,1);
	System.out.println(h.getMin());
	}
}