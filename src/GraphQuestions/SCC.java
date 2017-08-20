package GraphQuestions;

import java.util.Iterator;
import java.util.Stack;
public class SCC{

boolean[] visited;
DirectedG g;
Stack stack;
DirectedG g1;

public SCC(DirectedG g){
this.g =g;
g1=new DirectedG(g.v);
visited=new boolean[g.v];
stack=new Stack();
doDFS(1);
reverseAdj();
findStrong();
}
public void doDFS(int index){
if(!visited[index]){

Iterator it=g.adj[index].iterator();
visited[index]=true;

while(it.hasNext()){
doDFS((Integer)it.next());
}
stack.push(index);
}
}
public void reverseAdj(){
Iterator it;
System.out.println("Reversed Graph");
for(int i=0;i<g.v;i++){
 it=g.adj[i].iterator();

while(it.hasNext()){
int x=(Integer)it.next();
g1.adj[x].add(i);

}
}
g1.printGraph();
}


public void findStrong(){
int value;
Iterator it;
System.out.println("SCC");
DFSR dfsr=new DFSR(g.v);
for(int i=0;i<g.v;i++)
visited[i]=false;

while(!stack.empty()){
value=(Integer)stack.pop();
//doDFS(value);
dfsr.dfsr1(g1,value,visited);
System.out.println();
}
}
}
