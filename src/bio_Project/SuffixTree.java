package bio_Project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class SuffixTree{
	
 class SuffixNode {

	SuffixNode children[];
	SuffixNode suffixLink;
	
	int start;
	int index;
	boolean isMarked;
	int height;
	Endvariable end;
	
	public SuffixNode(){
		children=new SuffixNode[256];
		suffixLink=null;
		isMarked=false;
	}
	
}
 
 
 class Endvariable{
	 int end;
	 public Endvariable(int e){
		 this.end=e;
	 }
 }
 public SuffixNode createNewNode(int start, Endvariable end){
	 SuffixNode node = new SuffixNode();
	 int i;
	 
	 for(i=0;i<256;i++){
		 node.children[i]=null;
	 }
	 node.suffixLink=root;
	 node.index=-1;
	 node.height=0;
	 node.start=start;
	 node.end=end;
	 return node;
}
 
 public int lengthOfEdge(SuffixNode n){
	 return n.end.end-n.start+1;
 }
 

 
 public void setSuffixIndex(SuffixNode n, int height){
	 if(n==null)
		 return;
	// System.out.println("Started marking Suffix Index");
	 if(n.start!=-1){
		// print(n.start, n.end.end);
	 }
	 boolean leaf =true;
	 int i;
	 int childcount=0;
	 for(i=0;i<256;i++){
		 if(n.children[i]!=null){
			 n.children[i].height=height;
			 if(leaf && n.start!=-1)
				// System.out.println(" "+n.index);
			 
			 leaf=false;
			 setSuffixIndex(n.children[i], height+lengthOfEdge(n.children[i]));
			 childcount=childcount+1;
		 }
	 }
	 int hashes=0, dollars=0;
	 if(childcount==2 && n.start!=-1){
		
		 
		 for(int j=0;j<256;j++){
			 if(n.children[j]!=null){
				 for(int k=n.children[j].start;k<=n.children[j].end.end;k++){
					 if(input.charAt(k)=='#'){
						 hashes=hashes+1;
						 
					 }
					 if(input.charAt(k)=='$'){
						 dollars=dollars+1;
					 }
				 }
			 }
		 }
		 if(dollars==1&&hashes==2){
			 n.isMarked=true;
			 
			 if(n.end.end-n.start+n.height+1>=minMUMLength){
				 mumList.addElement(n);
			 }
		 }
	 }
	 if(leaf){
		 n.index=size-height;
		 //System.out.println(" "+n.index);
	 }
}
 public void print(int i, int j){
	 int k;
	 for(k=i;k<=j;k++){
		 System.out.print(input.charAt(k));
	 }
 }
 
 public void markMuMs(SuffixNode n){
	 if(n!=root&&n.suffixLink!=null){
		 n.suffixLink.isMarked=false;
		 markMuMs(n.suffixLink);
	 }
 }
 
 public boolean walkDown(SuffixNode node){
	 if(activeLength>=lengthOfEdge(node)){
		 activeEdge+=lengthOfEdge(node);
		 activeLength-=lengthOfEdge(node);
		 activeNode=node;
		 return true;
	 }
	 return false;
 }
 
 public void build(){
	 size=input.length();
	 int i;
	 rootEnd=new Endvariable(-1);
	 
	 root=createNewNode(-1,rootEnd);
	 activeNode=root;
	 
	 for(i=0;i<size;i++){
		 ukkonen(i);
	 }
	 int height=0;
	 setSuffixIndex(root, height);
	 System.out.println("Marked Suffix Index");
	 for(int j=0;j<mumList.size();j++){
	
		 markMuMs(mumList.get(j));
	 }
	 
	 System.out.println();
	 System.out.println("MUM ");
	 for(int j=0;j<mumList.size();j++){
		 if(mumList.get(j).isMarked){
			 System.out.print("[");
			 
			 for(int k=mumList.get(j).start-mumList.get(j).height; k<= mumList.get(j).end.end; k++){
				 System.out.print(input.charAt(k));
			 }
			 System.out.println("]");
		 }
	 }
 }
 public void ukkonen(int position){
	 leafEnd.end=position;
	 remaining++;
	 
	 lastNodeCreated=null;
	 
	 while(remaining>0){
		 if(activeLength==0)
			 activeEdge=position;
		 
		 if(activeNode.children[input.charAt(activeEdge)]==null){
			 
			 activeNode.children[input.charAt(activeEdge)]=createNewNode(position, leafEnd);
			 
			 if(lastNodeCreated!=null){
				 lastNodeCreated.suffixLink=activeNode;
				 lastNodeCreated=null;
			 }
		 }
		 else{
			 SuffixNode next=activeNode.children[input.charAt(activeEdge)];
			 
			 if(walkDown(next)){
				 continue;
			 }
			 if(input.charAt(next.start+activeLength)==input.charAt(position)){
				 
				 if(lastNodeCreated!=null && activeNode!=root){
					 lastNodeCreated.suffixLink=activeNode;
					 lastNodeCreated=null;
				 }
				 
				 activeLength++;
				 break;
			 }
			 
			 splitEnd=new Endvariable(next.start+activeLength-1);
			 SuffixNode split = createNewNode(next.start, splitEnd);
			 activeNode.children[input.charAt(activeEdge)]=split;
			 
			 split.children[input.charAt(position)]=createNewNode(position, leafEnd);
			 next.start+=activeLength;
			 split.children[input.charAt(next.start)]=next;
			 
			 if(lastNodeCreated!=null){
				 lastNodeCreated.suffixLink=split;
			 }
			 lastNodeCreated=split;
		 }
		 remaining--;
		 if(activeNode==root&&activeLength>0){
			 activeLength--;
			 activeEdge=position-remaining+1;
		 }else if(activeNode!=root){
			 activeNode=activeNode.suffixLink;
		 }
	 }
 }
 SuffixNode root;
 StringBuffer input;
 
 SuffixNode activeNode, lastNodeCreated;
 
 int activeEdge, activeLength, remaining, size;
 Endvariable splitEnd, rootEnd, leafEnd;
 int minMUMLength;
 Vector<SuffixNode> mumList;
 public SuffixTree(){
	 root=null;
	 lastNodeCreated=null;
	 activeNode=null;
	 activeEdge=-1;
	 activeLength=0;
	 remaining=0;
	 leafEnd=new Endvariable(-1);
	 rootEnd=null;
	 splitEnd=null;
	 size=-1;
	 minMUMLength=0;
	 mumList=new Vector<SuffixNode>();
 }

 
 public static void main(String[] args){
	 SuffixTree st=new SuffixTree();
	// st.input=new StringBuffer("abcabxabcd$");
	 //st.input=new StringBuffer("geeksforgeeks$");
	 File file1=new File("C:\\Personal\\Biology\\SuffixTree-master\\Input\\H_pylori26695_Bslice.txt");
	 File file2=new File("C:\\Personal\\Biology\\SuffixTree-master\\Input\\H_pylori26695_Eslice.txt");
	 BufferedReader br1, br2;
	 try {
		 br1=new BufferedReader(new FileReader(file1));
		 br2=new BufferedReader(new FileReader(file2));
		 
		 st.input=new StringBuffer(br1.readLine()+""+"$");
		 st.input.append(br2.readLine()+""+"#");
		 
		// st.input=new StringBuffer("abcabx$");
		 //st.input.append("abcd#");
		
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	
	 st.minMUMLength=10;
	 long startTime = System.nanoTime();
	//code
	
	 st.build();
	 long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime) + " ns"); 
	 
 }
 
 
 
}
