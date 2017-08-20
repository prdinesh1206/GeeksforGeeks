package GraphQuestions;

import java.util.Iterator;
import java.util.LinkedList;
public class Graph1{
LinkedList<Integer>[] adj;
int v;

public Graph1(int v){
this.v=v;
adj=new LinkedList[v];
}

public void addNode(int index, int value){
if(adj[index]==null)
adj[index]=new LinkedList<Integer>();

adj[index].add(value);

if(adj[value]==null){
adj[value]=new LinkedList<Integer>();
adj[value].add(index);
}
else{
Iterator it=adj[value].iterator();
int t;
boolean found=false;
while(it.hasNext()){
t=(Integer)it.next();
if(t==index)
found=true;
}
if(!found)
adj[value].add(index);
}
}

public void printGraph(){
for(int i=0;i<v;i++){
LinkedList l=adj[i];
System.out.println("Node "+i+" "+l);

}
}
public static void main(String[] args){
//Graph1 g=new Graph1(5);
    //Graph1 g1=new Graph1(9);
    //g1.addNode(0, 1);
    //g1.addNode(0, 2);
    //g1.addNode(1, 2);
    //g1.addNode(1, 5);
    //g1.addNode(2, 3);
    //g1.addNode(2, 4);
    //g1.addNode(2, 5);
    //g1.addNode(2, 6);
    //g1.addNode(3, 4);
    //g1.addNode(3, 6);
    //g1.addNode(3, 7);
    //g1.addNode(4, 6);
    //g1.addNode(4, 7);
    //g1.addNode(5, 6);
    //g1.addNode(5, 8);
    //g1.addNode(6, 7);
    //g1.addNode(6, 8);
//g.addNode(0,1);
//g.addNode(0,4);
//g.addNode(1,2);
//g.addNode(1,3);
//g.addNode(1,4);
//g.addNode(2,3);
//g.addNode(3,4);
//System.out.println("Before");
//g1.printGraph();
//
////BFS bfs=new BFS(g,2);
//System.out.println("After");
//new KCores(g1);
    //Graph1 g=new Graph1(7);
    //g.addNode(0, 1);
    //g.addNode(0, 2);
    //g.addNode(1, 3);
    //g.addNode(1, 4);
    //g.addNode(2, 5);
    //g.addNode(2, 6);
	//new IDDF(g);
	Graph1 g=new Graph1(5);
	g.addNode(0,1);
	g.addNode(0,2);
	g.addNode(1,2);
	g.addNode(0,3);
	g.addNode(3,4);
	new DetectCycleInUD(g);

}
}
