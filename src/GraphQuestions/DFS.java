package GraphQuestions;

import java.util.Iterator;
import java.util.Stack;

public class DFS{

public DFS(DirectedG g, int v){

Stack stack=new Stack();
boolean[] visited=new boolean[g.v];

stack.push(v);
System.out.print("DFS: ");
while(!stack.empty()){
int current=(Integer)stack.pop();
if(!visited[current]){
System.out.print(current+" ");
Iterator it=g.adj[current].iterator();

while(it.hasNext()){
stack.push((Integer)it.next());
}
visited[current]=true;
}

}

}
}
