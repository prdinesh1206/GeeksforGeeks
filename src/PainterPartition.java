import java.util.*;
import java.math.*;
public class PainterPartition {
	public static void main(String[] args){
		PainterPartition fin = new PainterPartition();
		Scanner scan = new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		int i=a;
		ArrayList<Integer> c = new ArrayList<Integer>();
		while(scan.hasNext())
			c.add(scan.nextInt());
		System.out.println(c);
		System.out.println(fin.paint(a, b, c));
	}

	public int paint(int a, int b, ArrayList<Integer> c) {
	    BigInteger sum = new BigInteger("0");
	    for(int i: c){
	       sum= sum.add(new BigInteger(""+i));
	    }
	    BigInteger low = BigInteger.ZERO;
	    BigInteger high = sum;
	    BigInteger mid, ans=new BigInteger("0");
	    BigInteger two = new BigInteger("2");
	    
	    while(low.compareTo(high)==0||low.compareTo(high)==-1){
	        mid=(low.add(high)).divide(two);
	        //System.out.println(low+" "+high+" "+mid);
	        if(isPossible(c, mid, a)){
	            ans=mid;
	            high=mid.subtract(BigInteger.ONE);
	        }else{
	        	low=mid.add(BigInteger.ONE);
	        }
	    }
	    return ans.intValue();
	}
	public boolean isPossible(ArrayList<Integer> c, BigInteger mid, int k){
	    int painters =1;
	    BigInteger sum=BigInteger.ZERO;
	    BigInteger current;
	    for(int i: c){
	        current = new BigInteger(""+i);
	        if(current.compareTo(mid)==1)
	        	return false;
	        if(((sum.add(current)).compareTo(mid))==1){
                painters++;
                if(painters>k){
                    return false;
                }
                sum=current;
	        }else{
	        	sum=sum.add(current);
	        }
	    }
	    return true;
	}

}
