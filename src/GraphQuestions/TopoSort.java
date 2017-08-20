package GraphQuestions;

import java.util.Iterator;
import java.util.Stack;
public class TopoSort{

Stack s;
boolean[] visited;
DirectedG g;

public TopoSort(int v, DirectedG g){
s= new Stack();
visited=new boolean[v];
this.g=g;
TopoSort(5);
for(int i=0;i<v;i++)
TopoSort(i);

System.out.println(s);
}
public void TopoSort(int index){
if(visited[index])
return;

Iterator it=g.adj[index].iterator();
while(it.hasNext()){
TopoSort((Integer)it.next());
}
visited[index]=true;
System.out.println("Pushed: "+index);
s.push(index);
}
}
