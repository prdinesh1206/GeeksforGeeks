package GraphQuestions;


import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
public class BFS{

public BFS(DirectedG g, int index){

//Graph1 g=new Graph1(5);
boolean[] visited=new boolean[g.v];
int i;
//System.out.println(visited[2]);

Queue<Integer> q=new LinkedList<>();
q.add(index);

while(q.size()!=0){
int current=q.remove();
if(!visited[current]){
System.out.print(current);
visited[current]=true;
Iterator it=g.adj[current].iterator();

while(it.hasNext()){

q.add((Integer)it.next());
}

}

}
}

}
