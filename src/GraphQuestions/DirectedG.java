package GraphQuestions;

import java.util.LinkedList;
public class DirectedG{
LinkedList<Integer>[] adj;
int v;

public DirectedG(int v){
this.v=v;
adj=new LinkedList[v];
for(int i=0;i<v;i++)
adj[i]=new LinkedList<>();
}

public void addNode(int index, int value){
if(adj[index]==null)
adj[index]=new LinkedList<>();
adj[index].add(value);
}

public void printGraph(){
for(int i=0;i<v;i++){
LinkedList l=adj[i];
System.out.println("Node "+i+" "+l);

}
}
public static void main(String[] args){
//DirectedG g=new DirectedG(5);
//g.addNode(0,1);
//g.addNode(0,2);
//g.addNode(1,2);
//g.addNode(2,0);
////g.addNode(1,4);
//g.addNode(2,3);
//g.addNode(3,3);
//g.printGraph();
//new GraphColorAlgo(g);

//BFS bfs=new BFS(g,2);
//System.out.println();
//DFS dfs =new DFS(g,2);
//DFSR recdfs =new DFSR(5);
//recdfs.dfsr(g,2);

DirectedG g1=new DirectedG(6);
g1.addNode(5,0);
g1.addNode(5,2);
g1.addNode(2,3);
g1.addNode(3,1);
g1.addNode(4,0);
g1.addNode(4,1);
System.out.println("TopoSort: ");
//TopoSort t=new TopoSort(g1.v, g1);
new TopoKahnSort(g1);

//System.out.println("Strongly Connected Componenets");
//DirectedG g1=new DirectedG(5);
// g1.addNode(1, 0);
//        g1.addNode(0, 2);
//        g1.addNode(2, 1);
//        g1.addNode(0, 3);
//        g1.addNode(3, 4);
//g1.printGraph();
//SCC sc=new SCC(g1);
//DirectedG g=new DirectedG(7);
//    g.addNode(0, 1);
//    g.addNode(0, 2);
//    g.addNode(1, 3);
//    g.addNode(4, 1);
//    g.addNode(6, 4);
//    g.addNode(5, 6);
//    g.addNode(5, 2);
//    g.addNode(6, 0); 
//System.out.println("Mother of vertices problem");
//Mother m=new Mother(g);

//DirectedG g=new DirectedG(5);
////g.addNode(0,1);
////g.addNode(0,3);
////g.addNode(1,2);
////g.addNode(2,3);
////
////TransitiveC t=new TransitiveC(g);
//    g.addNode(0, 1);
//    //g.addNode(0, 2);
//    g.addNode(1, 2);
//    g.addNode(0, 3);
//    g.addNode(3, 4);
//    g.addNode(4, 0);
//	new DetectCycle(g);
 


}
}
