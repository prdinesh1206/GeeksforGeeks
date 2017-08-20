import java.util.*;
public class MissingNumberArray {
	public static ArrayList<Integer> repeatedNumber(final List<Integer> a) {
	    BitSet bits=new BitSet(a.size());
	    Iterator it=a.iterator();
	    ArrayList<Integer> result=new ArrayList<Integer>();
	    Integer current;
	    while(it.hasNext()){
	        current=(Integer)it.next();
	        //System.out.println(current+" "+bits.get(current-1));
	        if(bits.get(current-1)){
	            result.add(current);
	            System.out.println(current);
	        }else{
	        	bits.set(current-1);
	        }
	        
	    }
	  
	    result.add(bits.nextClearBit(0)+1);
	    return result;
	}
	public static void main(String[] args){
		ArrayList<Integer> a=new ArrayList<Integer>();
		a.add(3);
		a.add(1);
		a.add(2);
		a.add(5);
		a.add(3);
		repeatedNumber(a);
	}
}
