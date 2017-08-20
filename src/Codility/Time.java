package Codility;

import java.util.Arrays;
import java.util.LinkedList;

public class Time {

	public String solution(int A, int B, int C, int D){
		LinkedList<Integer> l=new LinkedList<Integer>();
		int[] a =new int[4];
		int i;
		String output="";
		boolean possible = false;
		
		a[0]=A;
		a[1]=B;
		a[2]=C;
		a[3]=D;
		
		Arrays.sort(a);
		
		for(i=3;i>=0;i--)
			l.add(a[i]);
		
		for(i=3;i>=0;i--){
			if(l.get(i)<=2){
				possible=true;
				output=output+l.get(i);
				l.remove(i);
				break;
			}
		}
		if(!possible)
			return "NOT POSSIBLE";
		
		possible=false;
		for(i=l.size()-1;i>=0;i--){
			if(output.charAt(0)=='2'){
				if(l.get(i)<=3){
					possible=true;
					output=output+l.get(i);
					l.remove(i);
					break;
				}
			}else{
				possible=true;
				output=output+l.get(i);
				l.remove(i);
				break;
			}
		}
		if(!possible)
			return "NOT POSSIBLE";
		
		possible=false;
		for(i=l.size()-1;i>=0;i--){
			if(l.get(i)<=5){
				possible=true;
				output=output+l.get(i);
				l.remove(i);
				break;
			}
		}
		if(!possible)
			return "NOT POSSIBLE";
		
		output=output+l.get(0);
		return output;
		
	}
	public String forOne(int A, int B, int C, int D){
	       char a, b, c, d;
	       
	      StringBuffer st=new StringBuffer(""+A+""+B+""+C+""+D);
	      
	      
	       
		for(int i=2359;i>=0;i--){
			
	         	   String s=Integer.toString(i);
	         	 //System.out.println(s);
	         	   StringBuffer temp=new StringBuffer(st.toString());  
	         	
//	         	   a=(int)(s.charAt(0)-'0');
//	         	   b=(int)(s.charAt(0)-'0');
//	         	   c=(int)(s.charAt(0)-'0');
//	         	   d=(int)(s.charAt(0)-'0');
	         	   if(s.length()<4){
	         		   int range=s.length();
	         		   for(int f=0;f<(4-range);f++)
	         			   s=0+""+s;
	         	   }
	         	  if(((int)(s.charAt(2)-48))<5)
	         	  {
	         	  //System.out.println("number: "+s+" "+(int)(s.charAt(3)-48));
	         	   a=s.charAt(0);b=s.charAt(1);c=s.charAt(2);d=s.charAt(3);
	         	  
	         	  
	         	   
	         	   for(int j=0;j<temp.length();j++){
	         		   if(temp.charAt(j)==a){
	         			   temp.deleteCharAt(j);
	         			   
	         			   for(int k=0;k<temp.length();k++){
	         				   if(temp.charAt(k)==b){
	         					   temp.deleteCharAt(k);
	         					   
	         					   for(int m=0;m<temp.length();m++){
	         						   if(temp.charAt(m)==c){
	         							   temp.deleteCharAt(m);
	         							   
	         							   if(temp.charAt(0)==d)
	         								   return s;
	         						   }
	         					   }
	         				   }
	         			   }
	         		   }
	         		   temp=new StringBuffer(st.toString());
	         	   }
	         	
	       }
		}
		return "NOT POSSIBLE";
	}
	
	
	
	public static void main(String[] args){
		Time t=new Time();
		System.out.println(t.forOne(2, 4, 8, 9));
		//System.out.println((int)('4'-'0'));
	//	System.out.println((int)('2'-48));
//		StringBuffer st=new StringBuffer("abcd");
//		st.deleteCharAt(1);
//		System.out.println(st.charAt(1)+" "+st);
		//char a = (char)4+48;
		//Character.forDigit(a, 1);
		//System.out.println(a);
	}
}
