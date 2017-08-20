import java.util.LinkedList;
import java.util.Queue;
public class RotOranges {

	class Node {
		int x, y;
		public Node(int x, int y){
			this.x=x;
			this.y=y;
		}
	}
public static void main(String[] args){
	
	int row=3, col=5;
	int[][] arr= { {2, 1, 0, 2, 1},
            {1, 0, 1, 2, 1},
            {1, 0, 0, 2, 1}};
	
	Queue<Node> q=new LinkedList<>();
	int count=0,tempcount=1;
     RotOranges r=new RotOranges();
	int i,j;
	
	for(i=0;i<3;i++){
		for(j=0;j<4;j++){
			if(arr[i][j]==2)
			q.add(r.new Node(i,j));
		}
	}
	q.add(r.new Node(-1,-1));
	int temp;
	Node temp1;
	
	while(!q.isEmpty()){
		temp1=q.remove();
		if(temp1.x==-1&&temp1.y==-1){
			tempcount++;
			//q.add(r.new Node(-1,-1));
		}
		else{
		temp=arr[temp1.x][temp1.y];
		if(temp==2){
		if(temp1.x-1>0){
			if(arr[temp1.x-1][temp1.y]==1){
				arr[temp1.x-1][temp1.y]=2;
				q.add(r.new Node(temp1.x-1, temp1.y));
				if(count!=tempcount){
					count++;
				}
			}
		}
		if(temp1.x+1<row){
			if(arr[temp1.x+1][temp1.y]==1){
				arr[temp1.x+1][temp1.y]=2;
				q.add(r.new Node(temp1.x+1, temp1.y));
				if(count!=tempcount){
					count++;
				}
			}
		}
		if(temp1.y-1>0){
			if(arr[temp1.x][temp1.y-1]==1){
				arr[temp1.x][temp1.y-1]=2;
				q.add(r.new Node(temp1.x, temp1.y-1));
				if(count!=tempcount){
					count++;
				}
			}
		}
		if(temp1.y+1<col){
			if(arr[temp1.x][temp1.y+1]==1){
				arr[temp1.x][temp1.y+1]=2;
				q.add(r.new Node(temp1.x, temp1.y+1));
				if(count!=tempcount){
					count++;
				}
			}
		}
		}
		}
	}
	//count++;
	for(i=0;i<3;i++){
		for(j=0;j<4;j++){
			if(arr[i][j]==1){
				System.out.println("All oranges cannot be rotten.");
				return;
			}
		}
	}
	System.out.println("All oranges can become rotten in "+count+" time frames.");
}	
}
