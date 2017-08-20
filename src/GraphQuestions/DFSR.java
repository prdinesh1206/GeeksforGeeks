package GraphQuestions;

import java.util.Iterator;

public class DFSR{
boolean[] visited;

public DFSR(int v){
visited=new boolean[v];
System.out.println("Recursive DFS: ");
}
public void dfsr(DirectedG g, int dv){
if(!visited[dv]){
System.out.println(dv+" ");
Iterator it=g.adj[dv].iterator();
visited[dv]=true;
while(it.hasNext()){
dfsr(g, (Integer)it.next());
}
}
}
public void dfsr1(DirectedG g, int dv, boolean[] visited1){
if(!visited1[dv]){
System.out.print(dv+" ");
Iterator it=g.adj[dv].iterator();
visited1[dv]=true;
while(it.hasNext()){
dfsr1(g, (Integer)it.next(), visited1);
}
}
}
}
