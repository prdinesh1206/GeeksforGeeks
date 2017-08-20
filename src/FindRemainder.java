import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindRemainder {

	public static void main(String[] args){
		int x, n, d;
		Scanner scan = new Scanner(System.in);
		x=scan.nextInt();
		n=scan.nextInt();
		d=scan.nextInt();
		FindRemainder fin = new FindRemainder();
		System.out.println(fin.pow(x, n, d));
	}
	public int pow(int x, int n, int d){
		ArrayList<Long> al = new ArrayList<Long>();
		HashSet<Long> hashset = new HashSet<Long>();
		long current;
		int count=1;
		if(x>0&&x<=d){
			return x;
		}
		while(count<=n){
	        current=(long)(((double)Math.pow(x,count))%d);
	        if(hashset.contains(current))
	            break;
	        al.add(current);
	        hashset.add(current);
	        count++;
	    }
		System.out.println(al);
		System.out.println(count);
		int value = al.get((n%count)-1).intValue();
		if(value<0)
			value=d+value;
		System.out.println(value);
		return value;
	}
}
