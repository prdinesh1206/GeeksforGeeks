package GraphQuestions;

import java.util.Iterator;
import java.util.LinkedList;
public class Graph{

int v;

LinkedList<Node>[] adj;

public Graph(int v){
this.v =v ;
adj=new LinkedList[v];
}

public void addNode(int index, int value)
{
Node n=new Node(value);
if(adj[index]==null){
adj[index]=new LinkedList<Node>();
System.out.println("Added for "+index);
}
adj[index].add(n);

}
public void printGraph(){
for(int i=0;i<v;i++){
System.out.println("For: "+i);

Iterator it=adj[i].iterator();
while(it.hasNext()){
Node n= (Node)it.next();
System.out.print(n.value+" ");
}
System.out.println(adj[i]);
}
}
  
class Node{
  int value;
  Node next;

  public Node(int v){
    this.value=v;
    this.next=null;
}
}
public static void main(String[] args){
Graph g=new Graph(5);
g.addNode(0,1);
g.addNode(0,4);
g.addNode(1,2);
g.addNode(1,3);
g.addNode(1,4);
g.addNode(2,3);
g.addNode(3,4);
g.addNode(4,3);
g.printGraph();
}

}
